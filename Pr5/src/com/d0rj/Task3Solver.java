package com.d0rj;

import java.util.Scanner;


public class Task3Solver {

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int a, b;

        System.out.println("Введите A: ");
        a = Integer.parseInt(input.nextLine());
        System.out.println("Введите B: ");
        b = Integer.parseInt(input.nextLine());

        Task3Solver.solve(a, b);
    }


    private static void printLowToHigh(int a, int b) {
        System.out.println(a);

        if (a != b)
            printLowToHigh(++a, b);
    }


    private static void printHighToLow(int a, int b) {
        System.out.println(a);

        if (a != b)
            printHighToLow(--a, b);
    }


    public static void solve(int a, int b) {
        if (a < b)
            printLowToHigh(a, b);
        else
            printHighToLow(a, b);
    }
}
