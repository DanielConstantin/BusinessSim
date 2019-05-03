/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author daniel.constantin
 */
public class DatabaseUtil {
    Connection con = null;
    Statement stmt = null;
    
public Connection derbyDBConnection(String url){
   // Connection con = null;

    String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    try {
        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(url, "", "");
        con.setSchema("APP");
    } catch (ClassNotFoundException | SQLException | 
            InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(DatabaseUtil.class.getName())
                .log(Level.SEVERE, null, ex);
    }
    return con;
}

public ResultSet GetAction(int actiontype){
    
   
    ResultSet rs=null;
        try {
            rs = stmt.executeQuery("SELECT * FROM APP.ACTIONS WHERE ACTIONID=2;");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    return rs;
}
}
