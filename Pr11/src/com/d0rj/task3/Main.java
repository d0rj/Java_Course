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
                    new Add(
                            new Square(new Variable("x")),
                            new UnaryMinus(new Multiply(new Const(2), new Variable("x")))
                    ),
                    new Const(1)
            ).Evaluate(variables);

        } catch (MissingVariableValue e) {
            System.out.println("Error!");
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(result);
    }
}
