package com.d0rj;

public class Main {

    public static void main(String[] args) {
        var circle = new Circle( 1.5,2,1);

        System.out.println("Площадь с радиусом " + circle.getRadius() + " равна " + circle.getSquare());

        circle.setRadius(2);
        System.out.println("Площадь с радиусом " + circle.getRadius() + " равна " + circle.getSquare());
    }
}
