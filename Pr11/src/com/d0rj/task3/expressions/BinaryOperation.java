package com.d0rj.task3.expressions;

import java.util.Map;


public abstract class BinaryOperation implements IValue {

    protected IValue left;
    protected IValue right;


    public BinaryOperation(IValue left, IValue right) {
        this.left = left;
        this.right = right;
    }


    protected abstract String getSymbol();


    protected abstract void additionalChecks(double leftValue, double rightValue) throws ArithmeticException;


    protected abstract double function(double leftValue, double rightValue);


    @Override
    public final double Evaluate() throws MissingVariableValue, ArithmeticException {
        double leftValue;
        double rightValue;

        try {
            leftValue = left.Evaluate();
        } catch (MissingVariableValue e) {
            String message = e.getMessage();
            message += "\n\t" + "Missing variable value in: " + left.toString() + ".";
            throw new MissingVariableValue(message);
        }

        try {
            rightValue = right.Evaluate();
        } catch (MissingVariableValue e) {
            String message = e.getMessage();
            message += "\n\t" + "Missing variable value in: " + right.toString() + ".";
            throw new MissingVariableValue(message);
        }

        additionalChecks(leftValue, rightValue);

        return function(leftValue, rightValue);
    }


    @Override
    public final double Evaluate(Map<String, Double> variableValues) throws MissingVariableValue, ArithmeticException {
        double leftValue;
        double rightValue;

        try {
            leftValue = left.Evaluate(variableValues);
        } catch (MissingVariableValue e) {
            String message = e.getMessage();
            message += "\n\t" + "Missing variable value in: " + left.toString() + ".";
            throw new MissingVariableValue(message);
        }

        try {
            rightValue = right.Evaluate(variableValues);
        } catch (MissingVariableValue e) {
            String message = e.getMessage();
            message += "\n\t" + "Missing variable value in: " + right.toString() + ".";
            throw new MissingVariableValue(message);
        }

        additionalChecks(leftValue, rightValue);

        return function(leftValue, rightValue);
    }


    @Override
    public String toString() {
        return "(" + left.toString() + " " + getSymbol() + " " + right.toString() + ")";
    }
}
