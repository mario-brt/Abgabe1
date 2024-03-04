package edu.kit.informatik.command.player;

import edu.kit.informatik.ArtificialIntelligence;
import edu.kit.informatik.MemoryCell;
import edu.kit.informatik.command.CommandResult;
import edu.kit.informatik.command.CommandResultType;

import java.util.List;

public class RemoveCommand implements CommandPlayer{


    private final CommandHandlerPlayer commandHandlerPlayer;

    RemoveCommand(CommandHandlerPlayer commandHandler) {
        this.commandHandlerPlayer = commandHandler;
    }
    /**
     * @param ignored           the memory to execute the command on
     * @param commandArguments the arguments of the command
     * @param gameState the state of the game
     * @return Success or Failure and message
     */
    @Override
    public CommandResult execute(MemoryCell[] ignored, String[] commandArguments, GameState gameState) {
        if (gameState == GameState.PLAY_PHASE) {
            return new CommandResult(CommandResultType.FAILURE, "this command is not available in this phase");
        }
        String name = commandArguments[0];
        List<ArtificialIntelligence> ais = commandHandlerPlayer.getAiList();
        for (int i = 0; i < ais.size(); i++) {
            if (ais.get(i).getName().equals(name)) {
                ais.remove(i);
                return new CommandResult(CommandResultType.SUCCESS, name);
            }
        }
        return new CommandResult(CommandResultType.FAILURE, "AI not found");

    }

    /**
     * @return the number of arguments
     */
    @Override
    public int getNumberOfArguments() {
        return 1;
    }
}
