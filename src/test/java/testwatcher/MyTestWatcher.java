package testwatcher;

import batabaseconnection.ConnectionToDB;
import jpetstoretests.JPetStoreTestsOne;
import jpetstoretests.JPetStoreTestsTwo;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.lang.reflect.Method;
import java.sql.*;
public class MyTestWatcher implements TestWatcher, BeforeTestExecutionCallback {
    private static final String START_TIME = "start time";

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        getStore(context).put(START_TIME, System.currentTimeMillis());
    }
    //Stores all test information
    private ExtensionContext.Store getStore(ExtensionContext context) {
        return context.getStore(ExtensionContext.Namespace.create(getClass(), context.getRequiredTestMethod()));
    }
    @Override
    public void testSuccessful(ExtensionContext context) {

        ConnectionToDB sql = new ConnectionToDB();
        Method testMethod = context.getRequiredTestMethod(); // Print out the test method used
        long startTime = getStore(context).remove(START_TIME, long.class);
        long duration = System.currentTimeMillis() - startTime;
        try {
            sql.sendToDB(testMethod.getName(), "Passed", String.valueOf(duration/1000));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        ConnectionToDB sql = new ConnectionToDB();
        Method testMethod = context.getRequiredTestMethod();
        long startTime = getStore(context).remove(START_TIME, long.class);
        long duration = System.currentTimeMillis() - startTime;
        try {
            sql.sendToDB(testMethod.getName(), "Fail", cause.getClass().getCanonicalName(), String.valueOf(duration/1000));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void result(){
        Result result = new JUnitCore().run(JPetStoreTestsOne.class, JPetStoreTestsTwo.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.getTrace());
        }
    }


}

