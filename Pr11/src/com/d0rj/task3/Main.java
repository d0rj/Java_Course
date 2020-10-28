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
            result = ExpressionParser.Parse("4 * x / 2 + 1").Evaluate(variables);

        } catch (MissingVariableValue e) {
            System.out.println("Error!");
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(result);
    }
}
