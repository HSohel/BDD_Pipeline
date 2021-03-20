package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class SqlConnector {
    private static final Logger LOGGER = LogManager.getLogger(SqlConnector.class);
    private static final String Url = "jdbc:postgresql://localhost:5433/mortgage_calculator";
    private static final String User = "postgres";
    private static final String Password = "Wafir3316";


    private static Connection connect() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Url, User, Password);
        } catch (SQLException e) {
            LOGGER.info("SQL Connection exception :" + e.getMessage());
        }

        return conn;
    }


    public static ResultSet readData(String SQL) {
        ResultSet rs = null;
        try {
            Connection conn = connect();
            Statement stat = conn.createStatement();
            rs=stat.executeQuery(SQL);

        } catch (SQLException e) {
            LOGGER.error("SQL resultSet exception :"+e.getMessage() );
        }
        return rs;
   }
}



