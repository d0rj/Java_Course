package com.d0rj;


public class Book {

    private final String name;
    private final String author;
    private final int year;
    private final double cost;


    public Book(String name, String author, int year, double cost) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.cost = cost;
    }


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public double getCost() {
        return cost;
    }


    @Override
    public String toString() {
        return "Book {" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", cost=" + cost +
                '}';
    }
}
