package com.d0rj.task1;


public class ConcreteFactory implements ComplexAbstractFactory {

    @Override
    public Complex createComplex() {
        return new Complex();
    }


    @Override
    public Complex CreateComplex(int real, int image) {
        var result = new Complex();
        result.real = real;
        result.image = image;
        
        return result;
    }
}
