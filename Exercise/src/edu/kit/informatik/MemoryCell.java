package edu.kit.informatik;

import edu.kit.informatik.command.ai.AICommands;

public class MemoryCell {

    private AICommands aiCommand;
    private int argument1;
    private int argument2;
    private final String symbol;
    private boolean wasEdited = false;

    public MemoryCell(String symbol) {
        this.symbol = symbol;
    }

    //Setter
    public void setAiCommand(AICommands aiCommand) {
        this.aiCommand = aiCommand;
        wasEdited = true;
    }

    public void setArgument1(int argument1) {
        this.argument1 = argument1;
    }

    public void setArgument2(int argument2) {
        this.argument2 = argument2;
    }

    //Getter
    public AICommands getAiCommand() {
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
