package com.d0rj.task3.expressions;

import java.util.Map;


public abstract class UnaryOperation implements IValue {

    protected IValue value;


    public UnaryOperation(IValue value) {
        this.value = value;
    }


    protected abstract double function(double value);


    @Override
    public double Evaluate() throws MissingVariableValue {
        double result;

        try {
            result = value.Evaluate();
        } catch (MissingVariableValue e) {
            String message = e.getMessage();
            message += "\n\t" + "Missing variable value in: " + value.toString() + ".";
            throw new MissingVariableValue(message);
        }

        return function(result);
    }


    @Override
    public double Evaluate(Map<String, Double> variableValues) throws MissingVariableValue {
        double result;

        try {
            result = value.Evaluate(variableValues);
        } catch (MissingVariableValue e) {
            String message = e.getMessage();
            message += "\n\t" + "Missing variable value in: " + value.toString() + ".";
            throw new MissingVariableValue(message);
        }

        return function(result);
    }
}
