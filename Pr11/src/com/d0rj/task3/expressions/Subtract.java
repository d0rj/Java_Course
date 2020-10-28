package com.d0rj.task3.expressions;


public class Subtract extends BinaryOperation {

    public Subtract(IValue left, IValue right) {
        super(left, right);
    }


    @Override
    protected String getSymbol() {
        return "-";
    }


    @Override
    protected void additionalChecks(double leftValue, double rightValue) throws ArithmeticException {

    }


    @Override
    protected double function(double leftValue, double rightValue) {
        return leftValue - rightValue;
    }
}
