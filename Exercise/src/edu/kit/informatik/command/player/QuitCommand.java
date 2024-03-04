package edu.kit.informatik.command.player;

import edu.kit.informatik.MemoryCell;
import edu.kit.informatik.command.CommandResult;
import edu.kit.informatik.command.CommandResultType;

public class QuitCommand implements CommandPlayer{

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
     * @param memory           the memory to execute the command on
     * @param commandArguments the arguments of the command
     * @param gameState
     * @return
     */
    @Override
    public CommandResult execute(MemoryCell[] memory, String[] commandArguments, GameState gameState) {
        commandHandlerPlayer.quit();
        return new CommandResult(CommandResultType.SUCCESS, null);
    }

    /**
     * @return
     */
    @Override
    public int getNumberOfArguments() {
        return NUMBER_OF_ARGUMENTS;
    }
}
