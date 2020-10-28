package com.d0rj.task3.expressions;


public class Divide extends BinaryOperation {

    public Divide(IValue left, IValue right) {
        super(left, right);
    }


    @Override
    protected String getSymbol() {
        return "/";
    }


    @Override
    protected void additionalChecks(double leftValue, double rightValue) throws ArithmeticException {
        if (rightValue == 0)
            throw new ArithmeticException("Division by zero in: " + this.toString());
    }


    @Override
    protected double function(double leftValue, double rightValue) {
        return leftValue / rightValue;
    }
}
