package edu.kit.informatik.command.player;

import edu.kit.informatik.ArtificialIntelligence;
import edu.kit.informatik.MemoryCell;
import edu.kit.informatik.command.CommandResult;

public interface CommandPlayer {

    /**
     * Executes the command.
     *
     * @param memory            the memory to execute the command on
     * @param commandArguments the arguments of the command
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
