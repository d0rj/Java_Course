package com.d0rj.task3.expressions;


public final class UnaryMinus extends UnaryOperation {

    public UnaryMinus(IValue value) {
        super(value);
    }


    @Override
    protected double function(double value) {
        return (- value);
    }


    @Override
    public String toString() {
        return "-" + value.toString();
    }
}
