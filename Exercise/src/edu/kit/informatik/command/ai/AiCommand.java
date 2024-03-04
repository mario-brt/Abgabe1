package edu.kit.informatik.command.ai;

/**
 * Represents a command in an AI's command list.
 * @author uistu
 */
public class AiCommand {
    private final AICommandsEnum commandName;
    private final int argument1;
    private final int argument2;

    /**
     * Constructs an AiCommand object with the given command name and arguments.
     *
     * @param commandName The name of the command
     * @param argument1   The first argument of the command
     * @param argument2   The second argument of the command
     */
    public AiCommand(AICommandsEnum commandName, int argument1, int argument2) {
        this.commandName = commandName;
        this.argument1 = argument1;
        this.argument2 = argument2;
    }

    /**
     * Retrieves the name of the command.
     *
     * @return The name of the command
     */
    public AICommandsEnum getCommandName() {
        return commandName;
    }

    /**
     * Retrieves the first argument of the command.
     *
     * @return The first argument of the command
     */
    public int getArgument1() {
        return argument1;
    }

    /**
     * Retrieves the second argument of the command.
     *
     * @return The second argument of the command
     */
    public int getArgument2() {
        return argument2;
    }
}
