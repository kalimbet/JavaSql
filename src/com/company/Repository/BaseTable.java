package com.company.Repository;

import com.company.OfficeDB;

import java.io.Closeable;
import java.sql.*;
import java.util.Scanner;
// Service parent class
public class BaseTable implements Closeable {

    Connection connection;  // JDBC connection for working with the table
    String tableName;
    Scanner input = new Scanner(System.in);

    BaseTable(String tableName) throws SQLException {  //For a real table, pass in the constructor its name.
        this.tableName = tableName;
        this.connection = OfficeDB.getConection();  // Establish a connection with the DBMS for further work
    }

    //Close
    public void close() {
        try {
            if(connection != null && !connection.isClosed())
                connection.close();
                System.out.println("Disconnected from DBMS done.");
        }catch (SQLException e){
            System.out.println("Error closing SQL Conection");
        }
    }
    // Run the SQL command without parameters in the DBMS; upon completion, issue a message to the console
    void executeSqlStatement(String sql, String description) throws SQLException{
        reopenConection();       // reopen (if it is inactive) connection to the DBMS
        Statement statement = connection.createStatement();     // Create statement to execute sql commands
        statement.execute(sql);     // Execute statement - sql command
        statement.close();      // Close statement to commit changes to the database
        if(description != null){
            System.out.println(description);
        }
    }

    void executeSqlStatement(String sql) throws SQLException {
        executeSqlStatement(sql, null);
    }

    void executeUpdate(String sql, String description) throws SQLException {
        reopenConection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();

    }


    void executeUpdate(String sql) throws SQLException{
        executeUpdate(sql);
    }




    // Activate the connection with the DBMS, if it is not active.
    void reopenConection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = OfficeDB.getConection();
        }
    }
}
