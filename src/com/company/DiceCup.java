package com.company;

import java.util.ArrayList;

public class DiceCup {
    private final ArrayList<Dice> diceCup;
    private int sum;

    public DiceCup(int diceAmount){
        this.diceCup = new ArrayList<>();
        for(int i = 0; i < diceAmount; i++){
            this.diceCup.add(new Dice(6));
        }
    }

    public void rollDices(){
        this.sum = 0;
        for(Dice dice : this.diceCup){
            dice.rollDice();
            this.sum += dice.getLastRoll();
        }
    }

    public int getSum() {
        return this.sum;
    }
}
