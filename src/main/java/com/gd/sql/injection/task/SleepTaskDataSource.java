package com.gd.sql.injection.task;

import com.gd.sql.injection.task.utils.DbUtilsDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SleepTaskDataSource implements Runnable {
    private DbUtilsDataSource dbUtilsDataSource;

    SleepTaskDataSource(DbUtilsDataSource dbUtilsDataSource) {
        this.dbUtilsDataSource = dbUtilsDataSource;
    }


    @Override
    public void run() {
        try (Connection conn = dbUtilsDataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT pg_sleep(5)")) { // SELECT pg_sleep(5)
            preparedStatement.execute();
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            System.out.println(rs.getString(2));
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
// 192351