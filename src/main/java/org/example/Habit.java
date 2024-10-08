package org.example;

import java.util.Date;

public class Habit {
    private String name;
    private Date date;
    private int frequency;
    private String describe;
    public Habit(String name, Date date, int frequency){
        this.name = name;
        this.date = date;
        this.frequency = frequency;
    }
    public String toString(){
        return name +" since "+date.toString() +" with frequency "+ frequency;
    }

    public String getName(){
        return name;
    }

}
