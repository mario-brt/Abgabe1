package edu.student.kit;

import edu.student.kit.command.Commands;

public class MemoryCell {

    private Commands aiCommand;
    private int argument1;
    private int argument2;
    private final String symbol;

    public MemoryCell(String symbol) {
        this.symbol = symbol;
    }

    //Setter
    public void setAiCommand(Commands aiCommand) {
        this.aiCommand = aiCommand;
    }

    public void setArgument1(int argument1) {
        this.argument1 = argument1;
    }

    public void setArgument2(int argument2) {
        this.argument2 = argument2;
    }

    //Getter
    public Commands getAiCommand() {
        return aiCommand;
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


}
