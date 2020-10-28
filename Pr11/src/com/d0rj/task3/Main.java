package com.d0rj.task3;

import com.d0rj.task3.expressions.*;

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
            result = new Add(
                    new Subtract(
                            new Multiply(new Variable("x"), new Variable("x")),
                            new Multiply(new Const(2), new Variable("x"))
                    ),
                    new Const(1)
            ).Evaluate(variables);

        } catch (MissingVariableValue e) {
            System.out.println("Error!");
            e.printStackTrace();
            return;
        }

        System.out.println(result);
    }
}
