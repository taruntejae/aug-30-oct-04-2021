package com.friday.jpmc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcHorrorTale {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/training";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, "root", "root");
            Statement stmt = conn.createStatement();
            String query = "insert into persons values(101, 'Sam', 12)";
            stmt.execute(query);
            stmt.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            conn.close();
        }



    }
}
