package com.d0rj.task3.expressions;

import java.util.Map;


public interface IValue {

    double Evaluate() throws MissingVariableValue, ArithmeticException;
    double Evaluate(Map<String, Double> variableValues) throws MissingVariableValue, ArithmeticException;

    String toString();
}
