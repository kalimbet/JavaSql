package com.company;

import com.company.Model.Employee;
import com.company.Repository.Emplayee;
import com.company.Repository.EmplayeeRatingTable;

import java.sql.*;
import java.util.Scanner;


public class OfficeDB {

    public static final String DB_URL = "jdbc:h2:/C:/Users/wikto/IdeaProjects/testBD/db/officeDB";
    public static final String DB_DRIVER = "org.h2.Driver";
    public Scanner input;

    Employee employee;
    //DBMS Tables
    Emplayee employees;
    EmplayeeRatingTable employeesRating;

    //Get a new database connection
    public static Connection getConection() throws SQLException{
        return DriverManager.getConnection(DB_URL);
    }

    // Initialization
    public OfficeDB() throws SQLException,ClassNotFoundException{
        Class.forName(DB_DRIVER);
        //Initialization tables
        employees = new Emplayee();
        employeesRating = new EmplayeeRatingTable();
        employee = new Employee();
        input = new Scanner(System.in);

    }

    //Creating all the tables and keys in between
    public void createTablesAndForeignKeys() throws SQLException{
        employees.createTable();
        employeesRating.createTable();
        // Create foreign keys (connection between tables)
        employeesRating.createForeingKeys();
    }

    public void addEmployee() throws SQLException {
        employees.addToDataBase();
        chech();
    }



    public void showEmployees() throws SQLException{
        employees.showFromDataBase();
    }

    public void chech() throws SQLException {
        String condition;
        System.out.println("Menu: ");
        System.out.println("    1. Add Employee");
        System.out.println("    2. Show Emplayee");
        System.out.println("    3. Update Employee");
        condition = input.nextLine();
        switch (condition){
            case "1":
                addEmployee();
                break;
            case "2":
                showEmployees();
                break;

        }
    }

    public static void main(String[] args) {


        try {
            OfficeDB officeDB = new OfficeDB();
            officeDB.createTablesAndForeignKeys();
            System.out.println("Connection with DBMS is made");
            officeDB.chech();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC DBMS Driver Not Found!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL error!");
        }

    }
}
