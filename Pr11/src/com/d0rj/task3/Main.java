package com.d0rj.task3;

import com.d0rj.task3.expressions.*;
import com.d0rj.task3.parser.ExpressionParser;

import java.util.HashMap;
import java.util.Map;


public class Main {

    static Map<String, Double> variables  = new HashMap<String, Double>() {{
        put("x", 5.0);
        put("y", 2.0);
    }};


    public static void main(String[] args) {
        double result;

        try {
            result = ExpressionParser.Parse("x^2 +  2* 5 + 1").Evaluate(variables);

        } catch (MissingVariableValue e) {
            System.out.println("Error!");
            System.out.println(e.getMessage());
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input string.");
            return;
        }

        System.out.println(result);
    }
}
