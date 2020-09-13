package com.d0rj.task2.interfaces;

import com.d0rj.task2.FunctionalChair;
import com.d0rj.task2.MagicChair;
import com.d0rj.task2.VictorianChair;


public interface AbstractChairFactory {

    VictorianChair createVictorianChair();
    MagicChair createMagicChair();
    FunctionalChair createFunctionalChair();
}
