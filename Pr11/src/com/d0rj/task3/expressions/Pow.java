package com.d0rj.task3.expressions;


public final class Pow extends BinaryOperation {

    public Pow(IValue left, IValue right) {
        super(left, right);
    }


    @Override
    protected String getSymbol() {
        return "^";
    }


    @Override
    protected void additionalChecks(double leftValue, double rightValue) throws ArithmeticException {

    }


    @Override
    protected double function(double leftValue, double rightValue) {
        return Math.pow(leftValue, rightValue);
    }


    @Override
    public String toString() {
        return "(" + left.toString() + getSymbol() + "(" + right.toString() + ")" + ")";
    }
}
