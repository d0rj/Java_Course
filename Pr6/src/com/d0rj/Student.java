package com.d0rj;


public class Student implements Comparable<Student> {

    private final int age;
    private final String name;
    private double averageScore;


    public Student(int age, String name, double averageScore) {
        this.age = age;
        this.name = name;
        this.averageScore = averageScore;
    }


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }


    @Override
    public int compareTo(Student o) {
        return Double.compare(averageScore, o.averageScore);
    }


    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", averageScore=" + averageScore +
                '}';
    }
}
