package parallelexecution;

import jpetstoretests.JPetStoreTestsOne;
import jpetstoretests.JPetStoreTestsTwo;
import org.junit.jupiter.api.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.JUnitCore;
import testwatcher.MyTestWatcher;

@ExtendWith(MyTestWatcher.class)
public class ParallelExecution {
    @Test
    public void test(){
        Class[] cls = { JPetStoreTestsOne.class, JPetStoreTestsTwo.class};
        JUnitCore.runClasses(new ParallelComputer(true, false), cls);
    }
}
