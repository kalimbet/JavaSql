package com.company.Repository;

import com.company.OfficeDB;

import java.io.Closeable;
import java.sql.*;
import java.util.Scanner;

public class EmployeesTable implements Closeable {

    Connection connection;
    String tableName;
    Scanner input = new Scanner(System.in);

    EmployeesTable(String tableName) throws SQLException {
        this.tableName = tableName;
        this.connection = OfficeDB.getConection();
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
        reopenConection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
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

    //Data sampling with ExecuteQuery
    void executeQuery(String sql, String description) throws SQLException{
        reopenConection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            int rating = resultSet.getInt(4);
            System.out.println(id + " " + name + " " + surname + " " + rating);
        }
        statement.close();
        if(description != null){
            System.out.println(description);
        }
    }

    void executeQuery(String sql) throws SQLException{
        executeQuery(sql);
    }

    //Add employee with PreparedStatement
    void addEmployeePreparedStatement(String sql, String description) throws SQLException{
        reopenConection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("        Write name:");
        preparedStatement.setString(1, input.nextLine());
        System.out.println("        Write surname:");
        preparedStatement.setString(2, input.nextLine());
        System.out.println("        Write rating:");
        preparedStatement.setInt(3,input.nextInt());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        if(description != null){
            System.out.println(description);
        }
    }

    void addEmployeePreparedStatement(String sql) throws SQLException{
        addEmployeePreparedStatement(sql);
    }

    // Activate the connection with the DBMS, if it is not active.
    void reopenConection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = OfficeDB.getConection();
        }
    }
}
