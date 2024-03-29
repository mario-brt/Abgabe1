package edu.kit.informatik.command.player;

import edu.kit.informatik.MemoryCell;
import edu.kit.informatik.command.CommandResult;

/**
 * Represents a command that can be executed in the game.
 * @author uistu
 * @author Programmieren-Team
 */
public interface CommandPlayer {

    /**
     * Executes the command.
     *
     * @param memory            the memory to execute the command on
     * @param commandArguments the arguments of the command
     * @param gameState        the state of the game
     * @return the result of the command
     */
    CommandResult execute(MemoryCell[] memory, String[] commandArguments, GameState gameState);

    /**
     * Returns the number of arguments that the command expects.
     *
     * @return the number of arguments that the command expects
     */
    int getNumberOfArguments();
}
