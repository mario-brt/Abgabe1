package edu.kit.informatik.command.player;

import edu.kit.informatik.ArtificialIntelligence;
import edu.kit.informatik.MemoryCell;
import edu.kit.informatik.command.CommandResult;

public class RemoveCommand implements CommandPlayer{


    /**
     * @param memory           the memory to execute the command on
     * @param commandArguments the arguments of the command
     * @param gameState
     * @return
     */
    @Override
    public CommandResult execute(MemoryCell[] memory, String[] commandArguments, GameState gameState) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public int getNumberOfArguments() {
        return 1;
    }
}