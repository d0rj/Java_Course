package com.d0rj;


public class TestAddress {

    public static void main(String[] args) {
        var ad1 = Address.fromString("Страна, Регион, Город, Улица, Дом, Корпус, Квартира");
        var ad2 = Address.fromAnotherString("Страна; Регион; Город; Улица; Дом; Корпус; Квартира");

        System.out.println(ad1);
        System.out.println(ad2);
    }
}
