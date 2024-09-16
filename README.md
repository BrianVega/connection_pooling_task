# Multi-Threaded Database Access Application

## Overview

This project demonstrates how to perform database operations in a multi-threaded environment using different connection management techniques. It includes two implementations:

1. **Direct Database Connection**: Uses a custom `DataSource` to manage database connections.
2. **HikariCP Connection Pool**: Uses HikariCP for efficient connection pooling and management.

The application measures the time taken to execute a number of database operations using a fixed thread pool. The goal is to compare performance between using a single `DataSource` and a connection pool.

## Project Structure

The project consists of the following main components:

- **Main Class**: `Main.java` - Entry point for the application, which runs the tests and prints the results.
- **Multi-Threaded Applications**:
    - `MultiThreadedApplicationDataSource.java` - Executes database operations using a single `DataSource` instance.
    - `MultiThreadedApplicationPoolConnections.java` - Executes database operations using a HikariCP connection pool.
- **Task Classes**:
    - `SleepTaskDataSource.java` - Executes a database query using a `DataSource`.
    - `SleepTaskHikariCP.java` - Executes a database query using a HikariCP connection pool.
- **Utilities**:
    - `DbUtilsDataSource.java` - Custom `DataSource` implementation.
    - `DbUtilsHikariCP.java` - Configuration for HikariCP connection pooling.

## How to Run

1. **Setup Environment Variables**:

   Ensure you have the following environment variables set up in your `.env` file or system environment:

```
DB_URL=jdbc:postgresql://localhost 
HOST=localhost 
DB_PORT=5432 
DB_NAME=your_database 
DB_USER=your_username 
DB_PASSWORD=your_password
```


2. **Build and Run**:

- **Compile the Project**:
  ```sh
  javac -d out src/com/gd/sql/injection/task/*.java src/com/gd/sql/injection/task/utils/*.java
  ```

- **Run the Main Class**:
  ```sh
  java -cp out com.gd.sql.injection.task.Main
  ```

This will execute the application with 10 threads and measure the time taken for both connection management methods.

## Results

### Behavior

When using a ResultSet and reading the output, the application prints the following results:

## Example Output

```
John Doe 
John Doe 
John Doe 
John Doe 
John Doe 
Pool Connection
John Doe 
John Doe 
John Doe 
John Doe 
John Doe 
John Doe 
John Doe 
John Doe 
John Doe 
John Doe 
```
We can see that even when 10 threads where executed, just 5 `John Doe` where printed, while on the other hand, when using the pool of connections, all threads retrieved data successfully.

### Performance

When executing the `pg_sleep(5)` statement we can see that the results are as follows:


- **DataSource result**: Time taken to execute operations using a single `DataSource` instance.
- **Pool connection result**: Time taken to execute operations using HikariCP connection pooling.


## Example Output

```
DataSource result: 55843
Pool connection result: 15045
```

## Key Components

### `Main.java`

The entry point of the application. It runs the tests for both connection management methods and prints the results.

### `MultiThreadedApplicationDataSource.java`

Manages database operations using a single `DataSource` instance. Submits tasks to a fixed thread pool.

### `MultiThreadedApplicationPoolConnections.java`

Manages database operations using a HikariCP connection pool. Submits tasks to a fixed thread pool.

### `SleepTaskDataSource.java` and `SleepTaskHikariCP.java`

Runnable tasks that execute database queries and print results. Used by the multi-threaded application classes.

### `DbUtilsDataSource.java`

Custom implementation of `DataSource` that provides a single connection for all threads.

### `DbUtilsHikariCP.java`

Configuration for HikariCP, including setting up the connection pool.