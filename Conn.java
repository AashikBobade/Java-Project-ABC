package firstproject;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conn {
    Connection c;
    Statement s;
    
    String database_connection_string = "jdbc:postgresql://localhost:5432/ABC";
    String database_user_name = "postgres";
    String database_user_password = "SATARA@11";
    
    public Conn(){
        try {
            c = DriverManager.getConnection(database_connection_string, database_user_name, database_user_password );
            s = c.createStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
