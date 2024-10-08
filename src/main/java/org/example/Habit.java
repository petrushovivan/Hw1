package org.example;

import java.util.Date;

public class Habit {
    String name;
    Date date;
    public Habit(String name, Date date){
        this.name = name;
        this.date = date;
    }
    public String toString(){
        return name +" since "+date.toString();
    }
}
