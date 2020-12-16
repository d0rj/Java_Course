package com.d0rj;

public class Main {

    public static void main(String[] args) {
        Priceable car = new Car(1_000_000, "Vedro", "Toyota");
        Priceable phone = new Phone(25_000, "Redmi 20 Pro");

        System.out.println(car.getPrice());
        System.out.println(phone.getPrice());
    }
}
