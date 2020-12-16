package com.d0rj;


public class Circle {

    private  double x;
    private double  y;
    private double radius;


    public Circle(double x, double y , double r)
    {
        this.x = x;
        this.y = y;
        this.radius = r;
    }


    public double getSquare() {
        return Math.PI * radius * radius;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

