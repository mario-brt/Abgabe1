package edu.kit.informatik;

public class Game extends GameUtility{
    private Memory memory;
    private static final String GREETING_MESSAGE = "Welcome to CodeFight 2024. Enter 'help' for more details.";

    public Game (String[] args){
        if(checkArgumentsGameStart(args)) {
            this.memory = new Memory(Integer.parseInt(args[0]));
        }
    }

    public void playCodeFight() {

    }
}
