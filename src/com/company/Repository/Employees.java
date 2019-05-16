package com.company.Repository;


import java.sql.SQLException;

public class Employees extends EmployeesTable implements TableOperations {

    public Employees() throws SQLException{
        super("emploees");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS emploees(" +
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
//    public void addEmployee() throws SQLException {
//
//        super.executeSqlStatement("INSERT INTO emploees(id, name, surname, rating) VALUES(5, , , ); ");
//    }

    @Override
    public void addEmployee() throws SQLException {


        super.addEmployeePreparedStatement("INSERT INTO emploees(name, surname, rating) VALUES(?, ?, ?); ",  "User was added");
    }

    @Override
    public void showEmployees() throws SQLException {
        super.executeQuery("SELECT * FROM emploees; ", "Users was showed");
    }

    @Override
    public void updateTable() throws SQLException {

    }
}
