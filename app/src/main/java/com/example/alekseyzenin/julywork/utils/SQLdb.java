package com.example.alekseyzenin.julywork.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import com.example.alekseyzenin.julywork.model.Workout;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class SQLdb  {
    final static Connection conn = MyConnection.getConnection();



    static void  createTable() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn1 = MyConnection.getConnection();
            Statement st = conn1.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS WORKOUT_DB_RECORDS" +
                    "(lesson VARCHAR(255) not NULL, " +
                    " records INTEGER not NULL, " +
                    " date VARCHAR(255), " +
                    " PRIMARY KEY ( lesson ))";
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static void saveRecords(String lesson, int records) {

        Statement st = null;
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");

        String sqlText = String.format("update %s set date = %s, records = &d where lesson = %s",
                Constants.WORKOUT_DB_RECORDS, formatDate.format(new Date()),records);
        try {
            st = conn.createStatement();
            st.execute(sqlText);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void loadRecords(Workout workout) throws ParseException, SQLException {
        createTable();
        Statement st = null;
        String sqlText = String.format("select top 1 * from %s where lesson = %s", Constants.WORKOUT_DB_RECORDS, workout.getTitle());
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        ResultSet rs = st.executeQuery(sqlText);
        while (rs.next()){
            workout.setLastRecordDate(formatDate.parse(rs.getString(2)));
            workout.setLastRecordRepeats(rs.getInt(1));
        }

    }


}
