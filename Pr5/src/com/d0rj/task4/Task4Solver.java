package com.d0rj.task4;

import java.util.Scanner;


public class Task4Solver {

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int k, s;

        System.out.println("Введите k: ");
        k = Integer.parseInt(input.nextLine());
        System.out.println("Введите s: ");
        s = Integer.parseInt(input.nextLine());

        solve(k, s);
    }


    public static int digitsSum(int num) {
        return digitsSumHelper(num, 0);
    }

    private static int digitsSumHelper(int num, int sum) {
        if (num == 0)
            return sum;
        else
            return digitsSumHelper(num / 10, sum + (num % 10));
    }


    public static void solve(int k, int s) {
        System.out.println("Количество чисел: " + solveHelper(k, s, (int)Math.pow(10, k - 1), 0));
    }

    private static int solveHelper(int k, int s, int number, int count) {
        if (number == Math.pow(10, k))
            return count;
        else {
            if (digitsSum(number) == s)
                ++count;

            return solveHelper(k, s, ++number, count);
        }
    }
}
