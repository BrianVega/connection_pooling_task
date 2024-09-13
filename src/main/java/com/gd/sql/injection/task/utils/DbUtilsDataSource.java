package com.gd.sql.injection.task.utils;

import io.github.cdimascio.dotenv.Dotenv;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class DbUtilsDataSource implements DataSource {
    private Connection connection;

    @Override
    public synchronized Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {

            Dotenv dotenv = Dotenv.load();
            String url = String.format("%s://%s:%s/%s",
                    dotenv.get("DB_URL"),
                    dotenv.get("HOST"),
                    dotenv.get("DB_PORT"),
                    dotenv.get("DB_NAME"));
            String user = dotenv.get("DB_USER");
            String password = dotenv.get("DB_PASSWORD");

            connection = DriverManager.getConnection(
                        url,
                        user,
                        password
                    );
        }
        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return getConnection();
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        throw new SQLFeatureNotSupportedException("Not supported yet.");
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        throw new SQLFeatureNotSupportedException("Not supported yet.");
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        throw new SQLFeatureNotSupportedException("Not supported yet.");
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        throw new SQLFeatureNotSupportedException("Not supported yet.");
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException("Not supported yet.");
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new SQLFeatureNotSupportedException("Not supported yet.");
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new SQLFeatureNotSupportedException("Not supported yet.");
    }
}
