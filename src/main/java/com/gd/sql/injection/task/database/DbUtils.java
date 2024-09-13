package com.gd.sql.injection.task.database;

import io.github.cdimascio.dotenv.Dotenv;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class DbUtils implements DataSource{
    private Connection connection;

    @Override
    public Connection getConnection() throws SQLException {
        Dotenv dotenv = Dotenv.load();

        String url = String.format("%s://%s:%s/%s",
                dotenv.get("DB_URL"),
                dotenv.get("HOST"),
                dotenv.get("DB_PORT"),
                dotenv.get("DB_NAME"));

        Connection tempConnection = null;
            if (connection == null || connection.isClosed()) {

                tempConnection = DriverManager.getConnection(
                    url,
                    dotenv.get("DB_USER"),
                    dotenv.get("DB_PASSWORD")
                );

                if (tempConnection == null) {
                    throw new SQLException("Could not connect to the database");
                }
                connection = tempConnection;
        }
        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return getConnection();
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
