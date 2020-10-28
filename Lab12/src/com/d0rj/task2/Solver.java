package com.d0rj.task2;

import java.util.regex.Pattern;


public class Solver {

    private static final Pattern SolvePattern = Pattern.compile("\\d+.*\\+");


    public static void main(String[] args) {
        System.out.println(hasDigitBeforePlus("1231   fds     + asfsa"));
        System.out.println(hasDigitBeforePlus("    dsadas + 2312"));
    }


    public static boolean hasDigitBeforePlus(String input) {
        return SolvePattern.matcher(input).find();
    }
}
