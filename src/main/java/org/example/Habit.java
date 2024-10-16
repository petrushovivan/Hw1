package org.example;

import java.util.ArrayList;
import java.util.Date;

public class Habit {

    private String name;

    private Date date;

    private int frequency;

    private Date lastPointDate = new Date();

    private int streek = 0;

    private ArrayList<Date> pointDates = new ArrayList<>();

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

    public void setDescribe(String describe){
        this.describe = describe;
    }

    public String getDescribe(){
        return describe;
    }

    public Date getDate(){
        return date;
    }

    public void pointDate(Date date){
        pointDates.add(date);
        if(date.getTime()-lastPointDate.getTime()>=86_400_000L&&date.getTime()-lastPointDate.getTime()<=172_800_000L){
            streek++;
            lastPointDate = date;
        }
        else{
            streek=0;
        }
    }

    public int countPointsForMonth(){
        int result = 0;
        Date nowDate = new Date();
        for(Date date : pointDates){
            if(nowDate.getTime()-date.getTime()<=2_592_000_000L){
                result++;
            }
            else {
                break;
            }
        }
        return result;
    }

    public int countPointsForWeek(){
        int result = 0;
        Date nowDate = new Date();
        for(Date date : pointDates){
            if(nowDate.getTime()-date.getTime()<=604_800_000L){
                result++;
            }
            else {
                break;
            }
        }
        return result;
    }

    public int countPointsForToday(){
        int result = 0;
        Date nowDate = new Date();
        for(Date date : pointDates){
            if(nowDate.getTime()-date.getTime()<=86_400_000L){
                result++;
            }
            else {
                break;
            }
        }
        return result;
    }

    public int getStreek(){
        return streek;
    }
}
