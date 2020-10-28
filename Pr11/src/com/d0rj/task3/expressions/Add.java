package com.d0rj.task3.expressions;


public final class Add extends BinaryOperation {

    public Add(IValue left, IValue right) {
        super(left, right);
    }


    @Override
    protected String getSymbol() {
        return "+";
    }


    @Override
    protected void additionalChecks(double leftValue, double rightValue) {

    }


    @Override
    protected double function(double leftValue, double rightValue) {
        return leftValue + rightValue;
    }
}
