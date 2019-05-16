package com.company.Repository;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Emplayee extends EmplayeeTable implements TableOperations {

    public Emplayee() throws SQLException{
        super("employees");
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


    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS employees(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL," +
                "surname VARCHAR(255) NOT NULL," +
                "rating INTEGER NOT NULL)", "Table created " + tableName);
    }

    @Override
    public void createForeingKeys() throws SQLException {

    }

    @Override
    public void createExtraConstrains() throws SQLException {

    }

//    @Override
//    public void addToDataBase() throws SQLException {
//
//        super.executeSqlStatement("INSERT INTO employees(id, name, surname, rating) VALUES(5, , , ); ");
//    }

    @Override
    public void addToDataBase() throws SQLException {


        addEmployeePreparedStatement("INSERT INTO employees(name, surname, rating) VALUES(?, ?, ?); ",  "User was added");
    }

    @Override
    public void showFromDataBase() throws SQLException {
        executeQuery("SELECT * FROM employees; ", "Users was showed");
    }

    @Override
    public void updateTable() throws SQLException {

    }
}
