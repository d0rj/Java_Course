package com.d0rj.task3.parser;

import com.d0rj.task3.expressions.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class ExpressionParser {

    private static final String VarPattern = "^([a-zA-Z1-9_']+(?!<|>|\\+|\\-|\\*|\\/)).*";

    private static final Map<String, Integer> OperationWeight = new HashMap<>() {{
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

        // else it's complex expression
        List<String> tokens = tokenize(input);
        tokens = infixToPostFix(tokens.toArray(new String[0]));
        tokens.removeIf((x) -> x.equals("(") || x.equals(")"));

        if (tokens.size() == 1) {
            return toValue(tokens.get(0));
        }

        var values = new ArrayList<String>();
        for (var token : tokens)
            if (isNumeric(token) || isVariable(token))
                values.add(token);

        var operators = new ArrayList<String>();
        for (var token : tokens)
            if (OperationWeight.containsKey(token))
                operators.add(token);

        BinaryOperation currentValue = null;
        for (var operator : operators) {

            IValue leftValue;
            IValue rightValue;

            if (currentValue == null) {
                var left = values.remove(0);
                var right = values.remove(0);

                leftValue = toValue(left);
                rightValue = toValue(right);
            }
            else {
                leftValue = currentValue;
                rightValue = toValue(values.remove(0));
            }

            BinaryOperation op = switch (operator) {
                case "+" -> new Add(leftValue, rightValue);
                case "-" -> new Subtract(leftValue, rightValue);
                case "*" -> new Multiply(leftValue, rightValue);
                case "/" -> new Divide(leftValue, rightValue);
                case "^" -> new Pow(leftValue, rightValue);
                default -> throw new IllegalArgumentException();
            };

            currentValue = op;
        }

        return currentValue;
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
        return Pattern.compile(VarPattern).matcher(strVar).find();
    }


    private static IValue toValue(String value) throws IllegalArgumentException {
        if (isNumeric(value))
            return new Const(Double.parseDouble(value));
        else if (isVariable(value))
            return new Variable(value);
        else
            throw new IllegalArgumentException();
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


    static int precedence(String c){
        if (OperationWeight.containsKey(c))
            return OperationWeight.get(c);

        return -1;
    }


    static ArrayList<String> infixToPostFix(String[] expression){

        var result = new ArrayList<String>();
        var stack = new Stack<String>();

        for (String c : expression) {
            //check if char is operator
            if (precedence(c) > 0) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    result.add(stack.pop());
                }
                stack.push(c);
            }
            else if (c.equals(")")) {
                String x = stack.pop();

                while (!x.equals("(")) {
                    result.add(x);
                    x = stack.pop();
                }

            }
            else if (c.equals("(")) {
                stack.push(c);
            }
            else {
                result.add(c);
            }
        }

        for (int i = 0; i < stack.size() ; ++i) {
            result.add(stack.pop());
        }

        return result;
    }
}
