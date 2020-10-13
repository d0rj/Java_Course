package com.d0rj.task2;


import com.d0rj.task2.interfaces.Chair;

public class Person {

    private Chair chair;

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }


    public void Sit(Chair chair) {
        System.out.println("Sit");
    }


    public void Sit(FunctionalChair chair) {
        System.out.println(chair.sum(2, 2));
    }


    public void Sit(VictorianChair chair) {
        System.out.println(chair.getAge());
    }



    public void Sit() {
        System.out.println("Sit on current chair.");

    }
}
