package com.d0rj.task5;

import java.util.Scanner;
import java.util.regex.Pattern;


public class PasswordChecker {

    private static final String[] SafePasswordRegexes = new String[] {
            ".{8,}",
            "[A-Z]",
            "[a-z]",
            "[0-9]",
    };


    public static boolean PasswordIsSafe(String password) {
        for (int i = 0; i < SafePasswordRegexes.length; ++i)
            if (!Pattern.compile(SafePasswordRegexes[i]).matcher(password).find())
                return false;

        return true;
    }


    // F032_Password
    // TrySpy1_
    // smart_pass
    // A007
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите пароль: ");
            var password = scanner.nextLine();

            if (PasswordChecker.PasswordIsSafe(password)) {
                System.out.println("Ваш пароль безопасен.");
                return;
            }
            else {
                System.out.println("Ваш пароль небезопасен.");
            }
        }
    }
}
