package com.company;

public class Player {
    private final DiceCup diceCup;
    private final String name;
    private int totalPoints;

    public Player(String name){
        this.diceCup = new DiceCup(5);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void rollDice(){
        this.diceCup.rollDices();
        this.totalPoints += diceCup.getSum();
    }
}
