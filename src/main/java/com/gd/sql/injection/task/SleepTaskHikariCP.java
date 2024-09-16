package com.gd.sql.injection.task;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SleepTaskHikariCP implements Runnable {

    HikariDataSource hikariDataSource;

    public SleepTaskHikariCP(HikariDataSource hikariDataSource) {
        this.hikariDataSource = hikariDataSource;
    }

    @Override
    public void run() {
        try(Connection conn = hikariDataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT pg_sleep(5)")) { // SELECT pg_sleep(5)
            preparedStatement.execute();
//            ResultSet rs = preparedStatement.executeQuery();
//            rs.next();
//            System.out.println(rs.getString(2));
//            rs.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
