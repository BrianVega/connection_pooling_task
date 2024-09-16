package com.gd.sql.injection.task;

import com.gd.sql.injection.task.utils.DbUtilsHikariCP;
import com.zaxxer.hikari.HikariDataSource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadedApplicationPoolConnections {

    public static long run(int numberOfThreads) throws InterruptedException {
        DbUtilsHikariCP dbUtilsHikariCP = new DbUtilsHikariCP();
        HikariDataSource hikariDataSource = new HikariDataSource(dbUtilsHikariCP.getDataSource());
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> new SleepTaskHikariCP(hikariDataSource).run());
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);

        long endTime = System.currentTimeMillis();

        return endTime - startTime;

    }
}
