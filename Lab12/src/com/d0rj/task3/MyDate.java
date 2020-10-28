package com.d0rj.task3;


public class MyDate {

    public final int year;
    public final int mouth;
    public final int day;


    public MyDate(int year, int mouth, int day) {
        this.year = year;
        this.mouth = mouth;
        this.day = day;
    }


    public int calendarMouth() {
        return mouth - 1;
    }


    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", mouth=" + mouth +
                ", day=" + day +
                '}';
    }
}
