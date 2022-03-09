package com.company;

public class Dice {
    private final int sides;
    private int lastRoll;

    public Dice(int Sides){
        this.sides = Sides;
    }

    public void rollDice(){
        this.lastRoll = (int)(Math.random()*this.sides)+1;
    }

    public int getLastRoll() {
        return lastRoll;
    }
}
