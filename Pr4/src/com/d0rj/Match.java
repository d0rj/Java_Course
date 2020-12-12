package com.d0rj;


public class Match {

    private final Team first;
    private final Team second;
    private int firstGoals = 0;
    private int secondGoals = 0;


    public Match(Team first, Team second) {
        this.first = first;
        this.second = second;
    }


    public void firstGoal() {
        ++firstGoals;
    }

    public void secondGoal() {
        ++secondGoals;
    }


    public Team getFirst() {
        return first;
    }

    public Team getSecond() {
        return second;
    }


    public int getFirstGoals() {
        return firstGoals;
    }

    public int getSecondGoals() {
        return secondGoals;
    }


    public Team getWinner() {
        if (firstGoals == secondGoals)
            return null;

        return firstGoals > secondGoals ? first : second;
    }
}
