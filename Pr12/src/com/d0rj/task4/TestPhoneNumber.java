package com.d0rj.task4;


public class TestPhoneNumber {

    public static void main(String[] args) {
        System.out.println("From international: ");
        System.out.println(PhoneNumber.fromInternational("+79175655655").toUnique());

        System.out.println("From *RUSSIAN*:");
        System.out.println(PhoneNumber.fromRussian("89175655655").toUnique());
    }
}
