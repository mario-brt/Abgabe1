package edu.kit.informatik.command.ai;

public class AiCommand {
    private final AICommandsEnum commandName;
    private final int argument1;
    private final int argument2;

    public AiCommand(AICommandsEnum commandName, int argument1, int argument2) {
        this.commandName = commandName;
        this.argument1 = argument1;
        this.argument2 = argument2;
    }


    //Getter
    public AICommandsEnum getCommandName() {
        return commandName;
    }

    public int getArgument1() {
        return argument1;
    }

    public int getArgument2() {
        return argument2;
    }
}
