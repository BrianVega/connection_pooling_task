package com.gd.sql.injection.task;

public class Main {
    public static void main(String[] args) {
        int numberOfThreads = 10;
        try {
            long dataSourceResult = MultiThreadedApplicationDataSource.run(numberOfThreads);
            long poolConnectionResult = MultiThreadedApplicationPoolConnections.run(numberOfThreads);
            System.out.println("DataSource result: " + dataSourceResult);
            System.out.println("Pool connection result: " + poolConnectionResult);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}