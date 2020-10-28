package com.d0rj.task3.expressions;

import java.util.Map;


public final class Const implements IValue {

    private double value;


    public Const(double value) {
        this.value = value;
    }


    @Override
    public double Evaluate() {
        return value;
    }


    @Override
    public double Evaluate(Map<String, Double> variableValues) {
        return value;
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}
