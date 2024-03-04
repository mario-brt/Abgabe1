package edu.kit.informatik;

import edu.kit.informatik.command.ai.AICommandsEnum;

public class MemoryCell {

    private AICommandsEnum aiCommand = AICommandsEnum.STOP;
    private int argument1 = 0;
    private int argument2 = 0;

    private String symbol;



    private boolean wasEdited = false;

    public MemoryCell(String defaultSymbol) {
        this.symbol = defaultSymbol;
    }

    //Setter
    public void setAiCommand(AICommandsEnum aiCommand) {
        this.aiCommand = aiCommand;
        wasEdited = true;
    }

    public void setArgument1(int argument1) {
        this.argument1 = argument1;
    }

    public void setArgument2(int argument2) {
        this.argument2 = argument2;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setWasEdited(boolean wasEdited) {
        this.wasEdited = wasEdited;
    }

    //Getter
    public AICommandsEnum getAiCommand() {
        return this.aiCommand;
    }

    public int getArgument1() {
        return argument1;
    }

    public int getArgument2() {
        return argument2;
    }
    public String getSymbol() {
        return symbol;
    }


    public boolean isWasEdited() {
        return wasEdited;
    }



}
