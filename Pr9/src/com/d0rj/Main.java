package com.d0rj;

import com.d0rj.exception.InvalidInnException;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        var shop = new Shop();
        var input = new Scanner(System.in);

        System.out.println("Введите ИНН: ");
        var inputInn = input.nextLine();

        try {
            shop.checkout(inputInn);
        } catch (InvalidInnException e) {
            System.out.println("Некорректный ИНН.");
        }
    }
}
