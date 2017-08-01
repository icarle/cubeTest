package com.carle.connection;

import com.carle.cubetest.TestUtility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.WebDriver;

public class DBconnection {
    
     TestUtility utility = new TestUtility();

    public static WebDriver driver;

    public Connection buildDBConnection() throws SQLException {
        Connection connection = null;

        String driverName = "oracle.jdbc.driver.OracleDriver"; //SOME OTHER CONNETION METHINKS!
        
        String username = this.utility.getProperty("db.username");
        String password = this.utility.getProperty("db.password");
        String dbServerName = this.utility.getProperty("db.serverName");
        String portNumber = this.utility.getProperty("db.portNumber");
        String sid = this.utility.getProperty("db.sid");
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException ex) {
        }
        
        
        // MySQL connection instead...
        //String url = "jdbc:oracle:thin:@" + dbServerName + ":" + portNumber + ":" + sid;
        String url = "jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)(HOST = " 
                + dbServerName 
                + ")(PORT = " 
                + portNumber 
                + "))(CONNECT_DATA =(SERVER = DEDICATED)(SERVICE_NAME = " 
                + sid 
                + ")))";

        //IF CLUSTERED ENVIRONMENT
       String cluserurl = "jdbc:oracle:thin:@(DESCRIPTION=(LOAD_BALANCE=on)"
                + "(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.1.10)"
                + "(PORT=1521))"
                + "(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.1.10)"
                + "(PORT=1521))"
                + "(CONNECT_DATA=(SERVICE_NAME=PROCESSIT)))";
    
    
    
    
    connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public String executeDB(Connection conn, String sql) {
        StringBuilder localstr = new StringBuilder();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                localstr.append(rset.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(sql);
        }
        return localstr.toString();
    }
}
