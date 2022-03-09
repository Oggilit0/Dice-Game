package com.company;

import java.util.ArrayList;

public class Logic {

    private final ArrayList<Player> playerList;
    private final ArrayList<Player> winner;

    public Logic(ArrayList<Player> playerList){
        this.playerList = playerList;
        this.winner = new ArrayList<>();
    }

    public void doRound(){
        for(Player player : this.playerList){
            player.rollDice();
        }
        checkIsWinner();
    }

    public void checkIsWinner(){
        for(Player player : this.playerList){
            if(checkPoints(player.getTotalPoints())){
                if(!this.winner.isEmpty()){
                    checkMultipleWinners(player);
                }else{
                    this.winner.add(player);
                }
            }
        }
    }

    public boolean checkPoints (int points){
        return points >= 100;
    }

    public void checkMultipleWinners(Player winner){
        ArrayList<Player> tempList = duplicateArray(this.winner);;
        for(Player player : tempList){
            if(winner.getTotalPoints() > player.getTotalPoints()){
                this.winner.remove(player);
                    if(!this.winner.contains(winner)){
                    this.winner.add(winner);
                }
            }else if((winner.getTotalPoints() == player.getTotalPoints() )&& !this.winner.contains(winner)){
                this.winner.add(winner);
            }
        }
    }

    public void highestScore(){
        for(Player player : this.playerList){
            System.out.println(player.getName() + " " + player.getTotalPoints());
        }
        System.out.println("The winner is: ");
        for(Player player: this.winner){
            System.out.println("Player: "+player.getName() + " Score: " + player.getTotalPoints());
        }
    }

    public ArrayList<Player> duplicateArray(ArrayList<Player> list){
        return new ArrayList<>(list);
    }

    public boolean checkWinners(){
        return this.winner.isEmpty();
    }
}
