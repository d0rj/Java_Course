package com.d0rj.task3.expressions;


public final class Square extends UnaryOperation {

    public Square(IValue value) {
        super(value);
    }


    @Override
    protected double function(double value) {
        return value * value;
    }


    @Override
    public String toString() {
        return value.toString() + "^2";
    }
}
