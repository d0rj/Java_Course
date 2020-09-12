package com.d0rj;

import com.d0rj.interfaces.ICard;


public class DrunkardCard implements ICard {

    private final int weight;
    private final String name;


    public DrunkardCard(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }


    @Override
    public int compareTo(ICard o) {
        if (o.getClass() != this.getClass())
            return 0;

        var other = (DrunkardCard)o;

        if (weight == 0 && other.weight == 9)
            return 1;
        if (weight == 9 && other.weight == 0)
            return -1;

        return Integer.compare(weight, other.weight);
    }
}
