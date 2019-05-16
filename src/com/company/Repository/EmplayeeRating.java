package com.company.Repository;

import java.sql.SQLException;

public class EmplayeeRating extends EmplayeeTable implements TableOperations{


    public EmplayeeRating() throws SQLException {
        super("employee_rating");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS employee_rating(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                "operData datetime NOT NULL, " +
                "room INTEGER NOT NULL, " +
                "empid BIGINT NOT NULL, " +
                "rating INTEGER NOT NULL)", "Table created " + tableName);

    }

    @Override
    public void createForeingKeys() throws SQLException {
        super.executeSqlStatement("ALTER TABLE employee_rating ADD FOREIGN KEY (empid) REFERENCES employees(id)","test");
    }

    @Override
    public void createExtraConstrains() throws SQLException {

    }

    @Override
    public void addToDataBase() throws SQLException {

    }

    @Override
    public void showFromDataBase() throws SQLException {


    }

    @Override
    public void updateTable() throws SQLException {

    }
}
