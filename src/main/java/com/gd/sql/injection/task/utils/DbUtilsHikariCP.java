package com.gd.sql.injection.task.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;

public class DbUtilsHikariCP {

    public HikariDataSource getDataSource() {
        HikariConfig config = new HikariConfig();

        Dotenv dotenv = Dotenv.load();
        String url = String.format("%s://%s:%s/%s",
                dotenv.get("DB_URL"),
                dotenv.get("HOST"),
                dotenv.get("DB_PORT"),
                dotenv.get("DB_NAME"));

        config.setJdbcUrl(url);
        config.setUsername(dotenv.get("DB_USER"));
        config.setPassword(dotenv.get("DB_PASSWORD"));
        config.setMaximumPoolSize(10); // -> Maximum available connections for the pool
        return new HikariDataSource(config);
    }

}
