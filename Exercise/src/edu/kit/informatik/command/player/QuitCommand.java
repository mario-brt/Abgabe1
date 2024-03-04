package edu.kit.informatik.command.player;

import edu.kit.informatik.MemoryCell;
import edu.kit.informatik.command.CommandResult;
import edu.kit.informatik.command.CommandResultType;

/**
 * Represents a command for quitting the game.
 * @author uistu
 * @author Programmieren-Team
 */
public class QuitCommand implements CommandPlayer {

    private static final int NUMBER_OF_ARGUMENTS = 0;
    private final CommandHandlerPlayer commandHandlerPlayer;

    /**
     * Constructs a new QuitCommand.
     *
     * @param commandHandler the command handler to be quitted
     */
    QuitCommand(CommandHandlerPlayer commandHandler) {
        this.commandHandlerPlayer = commandHandler;
    }

    /**
     * Executes the quit command.
     *
     * @param memory           the memory to execute the command on
     * @param commandArguments the arguments of the command (not used in this implementation)
     * @param gameState        the state of the game
     * @return the result of executing the command
     */
    @Override
    public CommandResult execute(MemoryCell[] memory, String[] commandArguments, GameState gameState) {
        commandHandlerPlayer.quit();
        return new CommandResult(CommandResultType.SUCCESS, null);
    }

    /**
     * Gets the number of arguments required for this command.
     *
     * @return the number of arguments required
     */
    @Override
    public int getNumberOfArguments() {
        return NUMBER_OF_ARGUMENTS;
    }
}
