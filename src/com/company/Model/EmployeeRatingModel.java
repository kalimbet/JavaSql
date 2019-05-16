package com.company.Model;

import java.time.LocalDateTime;

public class EmployeeRatingModel extends EmployeeModel{
    private LocalDateTime operData;
    private int room;
    private int rating;

    public EmployeeRatingModel(){

    }

    public EmployeeRatingModel(long id, LocalDateTime operData, int room, int rating){
        super(id);
        this.operData = operData;
        this.room = room;
        this.rating = rating;
    }

    public LocalDateTime getOperData(){
        return operData;
    }

    public void setOperData(LocalDateTime operData){
        this.operData = operData;
    }

    public int getRoom(){
        return room;
    }

    public void setRoom(int room){
        this.room = room;
    }

    public int getRating(){
        return rating;
    }
    public void setRating(){
        this.rating = rating;
    }
}
