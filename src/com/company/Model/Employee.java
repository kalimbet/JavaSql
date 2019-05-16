package com.company.Model;

public class Employee extends EmployeeModel {
    private String name;
    private String surname;
    private int rating;
    public Employee(){

    }

    public Employee(long id, String name, String surname, int rating){
        super(id);
        this.name = name;
        this.surname = surname;
        this.rating = rating;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public int getRating(){
        return rating;
    }

    public void setRating(int rating){
        this.rating = rating;
    }
}
