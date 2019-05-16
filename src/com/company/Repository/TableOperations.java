package com.company.Repository;

import java.sql.SQLException;

public interface TableOperations {
    void createTable() throws SQLException;
    void createForeingKeys() throws SQLException;
    void createExtraConstrains() throws SQLException;
//    void addEmployee() throws SQLException;
    void addEmployee() throws SQLException;
    void showEmployees() throws SQLException;
    void updateTable() throws SQLException;
}
