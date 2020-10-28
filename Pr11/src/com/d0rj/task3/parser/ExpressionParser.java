package com.d0rj.task3.parser;

import com.d0rj.task3.expressions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class ExpressionParser {

    public static void main(String[] args) {
        var res = tokenize("1 + (2.0 + x_i   ^2)");

        System.out.println(res);
    }


    private static final String VarPattern = "^([a-zA-Z1-9_']+(?!<|>|\\+|\\-|\\*|\\/)).*";

    private static final Map<String, Integer> OperationWeight = new HashMap<String, Integer>() {{
        put("^", 15);
        put("*", 10);
        put("/", 10);
        put("+", 5);
        put("-", 5);
    }};

    private static final String AllOperations = "^*/+-";


    public static IValue Parse(String input) throws IllegalArgumentException {
        input = input.strip();

        if (input == null || input.equals(""))
            throw new IllegalArgumentException("Null string.");

        if (isNumeric(input))
            return new Const(Double.parseDouble(input));

        if (isVariable(input))
            return new Variable(input);

        // else it's complex expression
        List<String> tokens = tokenize(input);
        for (var token : tokens) {
            if (token.equals("(")) {
                // TODO: write some binary tree
            }
        }

        throw new IllegalArgumentException();
    }


    private static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;

        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }


    private static boolean isVariable(String strVar) {
        Pattern pattern = Pattern.compile(VarPattern);
        Matcher matcher = pattern.matcher(strVar);

        return matcher.find();
    }


    private static List<String> tokenize(String input) {
        input = "(" + input + ")";

        var result = new ArrayList<String>();

        StringBuilder tempToken = new StringBuilder();
        char prevChar = ' ';

        for (char c : input.toCharArray()) {
            if (c == ' ' || c == '\t') {
                if (tempToken.length() > 0) {
                    result.add(tempToken.toString());
                    tempToken = new StringBuilder();
                }
                prevChar = ' ';
                continue;
            }

            if (AllOperations.indexOf(c) >= 0) {
                if (tempToken.length() > 0) {
                    result.add(tempToken.toString());
                    tempToken = new StringBuilder();
                }
                result.add(Character.toString(c));
                prevChar = c;
                continue;
            }

            if (c == '(' || c == ')') {
                if (tempToken.length() > 0) {
                    result.add(tempToken.toString());
                    tempToken = new StringBuilder();
                }
                result.add(Character.toString(c));
                prevChar = c;
                continue;
            }

            if (Character.isAlphabetic(c) || c == '_' || c == '\'') {
                if (tempToken.length() > 0 && Character.isDigit(tempToken.charAt(0))) {
                    throw new IllegalArgumentException("Illegal number: '" + (tempToken.toString() + c) + "'.");
                }
                else {
                    tempToken.append(c);
                }

                prevChar = c;
                continue;
            }

            if (Character.isDigit(c)) {
                tempToken.append(c);
                prevChar = c;
                continue;
            }

            if (c == '.' && Character.isDigit(prevChar) && tempToken.length() > 0) {
                tempToken.append(c);
                prevChar = c;
                continue;
            }

            throw new IllegalArgumentException("WTF");
        }

        if (tempToken.length() > 0)
            result.add(tempToken.toString());

        return result;
    }
}
