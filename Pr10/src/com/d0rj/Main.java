package com.d0rj;

import com.d0rj.task1.ConcreteFactory;
import com.d0rj.task2.ChairFactory;
import com.d0rj.task2.Person;
import com.d0rj.task2.interfaces.AbstractChairFactory;
import com.d0rj.task2.interfaces.Chair;

public class Main {

    public static void main(String[] args) {
        var p = new Person();

        AbstractChairFactory factory = new ChairFactory();
        Chair magicChair = factory.createMagicChair();
        Chair functional = factory.createFunctionalChair();

        p.setChair(magicChair);
        p.Sit(magicChair);
        p.setChair(functional);
        p.Sit(functional);
    }
}
