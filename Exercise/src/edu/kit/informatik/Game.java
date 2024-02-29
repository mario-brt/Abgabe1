package edu.kit.informatik;


public class Game extends GameUtility{
    private Memory memory;


    public Game (String[] args){
        if(checkArgumentsGameStart(args)) {
            this.memory = new Memory(Integer.parseInt(args[0]));
        }
    }

    public void playCodeFight() {

        if(initializeGame(memory)) {
            startGame();
        }

    }
}
