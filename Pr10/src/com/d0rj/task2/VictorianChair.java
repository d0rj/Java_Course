package com.d0rj.task2;

import com.d0rj.task2.interfaces.Chair;


public class VictorianChair implements Chair {

    private final int age;


    public VictorianChair(int age) {
        this.age = age;
    }


    public int getAge() {
        return age;
    }
}
