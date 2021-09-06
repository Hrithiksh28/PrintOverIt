package com.example.printoverit2.Model;

public class Reminders {
    private String ReminderText;
    private String Time;
    private String Date;

    public Reminders(){

    }
    public Reminders(String reminderText, String time, String date){
        ReminderText = reminderText;
        Time = time;
        Date = date;
    }
    public String getReminderText(){ return ReminderText;}
    public void setReminderText(String reminderText) { ReminderText = reminderText;}

    public String getTime(){ return Time;}
    public void setTime(String time) { Time = time;}

    public String getDate(){ return Date;}
    public void setDate(String date) { Date = date;}



}
