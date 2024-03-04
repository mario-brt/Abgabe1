package edu.kit.informatik.command.player;

import edu.kit.informatik.ArtificialIntelligence;
import edu.kit.informatik.MemoryCell;
import edu.kit.informatik.command.CommandResult;
import edu.kit.informatik.command.CommandResultType;

import java.util.List;

/**
 * Represents a command for removing an artificial intelligence (AI) from the game.
 * @author uistu
 * @author Programmieren-Team
 */
public class RemoveCommand implements CommandPlayer {

    private final CommandHandlerPlayer commandHandlerPlayer;

    /**
     * Constructs a RemoveCommand object with the specified CommandHandlerPlayer.
     *
     * @param commandHandler the CommandHandlerPlayer to associate with this command
     */
    RemoveCommand(CommandHandlerPlayer commandHandler) {
        this.commandHandlerPlayer = commandHandler;
    }

    /**
     * Executes the remove command based on the current game state.
     *
     * @param ignored           the memory to execute the command on (not used in this implementation)
     * @param commandArguments the arguments of the command
     * @param gameState        the state of the game
     * @return the result of executing the command
     */
    @Override
    public CommandResult execute(MemoryCell[] ignored, String[] commandArguments, GameState gameState) {
        if (gameState == GameState.PLAY_PHASE) {
            return new CommandResult(CommandResultType.FAILURE, "This command is not available in this phase.");
        }
        String name = commandArguments[0];
        List<ArtificialIntelligence> ais = commandHandlerPlayer.getAiList();
        for (int i = 0; i < ais.size(); i++) {
            if (ais.get(i).getName().equals(name)) {
                ais.remove(i);
                return new CommandResult(CommandResultType.SUCCESS, name);
            }
        }
        return new CommandResult(CommandResultType.FAILURE, "AI not found.");
    }

    /**
     * Gets the number of arguments required for this command.
     *
     * @return the number of arguments required
     */
    @Override
    public int getNumberOfArguments() {
        return 1;
    }
}
