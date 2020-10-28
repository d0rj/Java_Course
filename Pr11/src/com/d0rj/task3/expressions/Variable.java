package com.d0rj.task3.expressions;

import java.util.Map;


public final class Variable implements IValue {

    private final String name;


    public Variable(String name) {
        this.name = name;
    }


    @Override
    public double Evaluate() throws MissingVariableValue {
        throw new MissingVariableValue("Missing value for variable: '" + name + "'.");
    }


    @Override
    public double Evaluate(Map<String, Double> variableValues) throws MissingVariableValue {
        Double value = variableValues.get(name);

        if (value == null)
            throw new MissingVariableValue("Missing value for variable: '" + name + "'.");

        return value;
    }


    @Override
    public String toString() {
        return name;
    }
}
