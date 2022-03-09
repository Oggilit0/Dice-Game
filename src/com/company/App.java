package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class App {
    private final ArrayList<String> nameList;
    private final ArrayList<Player> playerList;

    public App(){
        this.nameList = readAllLines();
        this.playerList = new ArrayList<>();
        createPlayers(5);
        runApp();
    }

    public void runApp(){
        Logic logic = new Logic(this.playerList);

        do{
            logic.doRound();
        }while(logic.checkWinners());

        logic.highestScore();
    }

    public void createPlayers(int amountOfPlayers){
        for(int i = 0; i<amountOfPlayers;  i++){
            this.playerList.add(new Player(randomName()));
        }
    }

    public ArrayList<String> readAllLines() {
        String fileName = "names.txt";
        ArrayList<String> names = null;
        try {
            names = (ArrayList<String>) Files.readAllLines(Paths.get(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return names;
    }

    public String randomName(){
        int rand = (int) (Math.random()*999);
        return this.nameList.get(rand);
    }

}
