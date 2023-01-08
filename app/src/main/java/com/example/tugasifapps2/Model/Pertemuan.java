package com.example.tugasifapps2.Model;

public class Pertemuan {
    private String title;
    private String date;

    public Pertemuan (String title, String date){
        this.title = title;
        this.date = date;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDate(){
        return this.date;
    }

    public void setDate(String date){
        this.date = date;
    }
}
