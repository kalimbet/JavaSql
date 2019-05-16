package com.company.Model;

import java.util.Objects;

// Model base class, id key
public class EmployeeModel {

    protected long id;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public EmployeeModel(){

    }

    public EmployeeModel(long id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        EmployeeModel employeeModel = (EmployeeModel) o;
        return id == employeeModel.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
