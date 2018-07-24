package com.example.alekseyzenin.julywork.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    static Connection instanse = null;

    public static Connection getConnection(){
        if (instanse == null){
            try {
                instanse = DriverManager.getConnection("jdbc:sqlite:WORKOUT_DB_RECORDS");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instanse;
    }
}
