package batabaseconnection;

import java.sql.*;

public class ConnectionToDB {

    private static final String url ="jdbc:mysql://localhost:3306/logging_test_results";
    private static final String user = "root";
    private static final String password = "Nonzaliseko@";
    public void sendToDB(String Test_Case, String Result, String Failure_Msg, String Test_Duration )throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement statement = conn.createStatement()) {
            String sqlInsert = "INSERT INTO test_results_table "
                    + "VALUES (null,'" + Test_Case + "','" + Result + "','" + Failure_Msg + "','" + Execution_Date_Time() + "','" + Test_Duration + "')";
            statement.executeUpdate(sqlInsert);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void sendToDB(String Test_Case, String Result, String Test_Duration )throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            String sqlInsert = "INSERT INTO test_results_table "
                    + "VALUES (null,'" + Test_Case + "','" + Result + "', null ,'" + Execution_Date_Time() + "','" + Test_Duration + "')";
            stmt.executeUpdate(sqlInsert);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        public String Execution_Date_Time()
        {
            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat sdf =
                    new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(dt);
        }
}