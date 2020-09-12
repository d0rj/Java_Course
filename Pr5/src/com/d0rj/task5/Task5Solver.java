package com.d0rj.task5;

import java.util.Scanner;


public class Task5Solver {

    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.println("Введите N: ");
        int n = Integer.parseInt(input.nextLine());

        System.out.println(sumOfDigits(n));
    }


    public static int sumOfDigits(int n) {
        return sumOfDigitsHelper(n, 0);
    }

    private static int sumOfDigitsHelper(int n, int sum) {
        if (n == 0)
            return sum;
        else
            return sumOfDigitsHelper(n / 10, sum + (n % 10));
    }
}
