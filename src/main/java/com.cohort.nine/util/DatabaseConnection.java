package com.cohort.nine.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    private Connection getDbConnection() throws Exception{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "roseann");
    }

    public ResultSet readFromDatabase(String sql){
        if  (sql == null || sql.trim().equals(""))
            return null;

        try {
            Statement statement = getDbConnection().createStatement();
            return statement.executeQuery(sql);

        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }

        return null;

    }

    public void writeToDatabase(String sql){
        if  (sql == null || sql.trim().equals(""))
            return;

        try {
            Statement statement = getDbConnection().createStatement();
            statement.executeUpdate(sql);

        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }
    }
}
