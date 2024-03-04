package edu.kit.informatik.command.player;

import edu.kit.informatik.ArtificialIntelligence;
import edu.kit.informatik.MemoryCell;
import edu.kit.informatik.command.CommandResult;
import edu.kit.informatik.command.CommandResultType;

public class InitCommand implements CommandPlayer {


    private final CommandHandlerPlayer commandHandlerPlayer;

    InitCommand(CommandHandlerPlayer commandHandler) {
        this.commandHandlerPlayer = commandHandler;
    }
    /**
     * @param ignored           the memory to execute the command on
     * @param commandArguments the arguments of the command
     */
    @Override
    public CommandResult execute(MemoryCell[] ignored, String[] commandArguments, GameState gameState) {

        if (gameState == GameState.INIT_PHASE) {
            String[] oldInitMode = commandHandlerPlayer.getInitMode();
            if (commandArguments[0].equals("INIT_MODE_STOP")) {
                commandHandlerPlayer.setInitMode(commandArguments);
                return new CommandResult(CommandResultType.SUCCESS, "Changed init mode from "+ oldInitMode[0] + " to " + commandArguments[0]);
            } else if (commandArguments[0].equals("INIT_MODE_RANDOM") && commandArguments.length == 2) {
                int seed = 0;
                try {
                    seed = Integer.parseInt(commandArguments[1]);
                } catch (NumberFormatException e) {
                    return new CommandResult(CommandResultType.FAILURE, "your seed is invalid");
                }
                if(seed >= -1337 && seed <= 1337) {
                    commandHandlerPlayer.setInitMode(commandArguments);
                    return new CommandResult(CommandResultType.SUCCESS, "Changed init mode from "+ oldInitMode[0] + " to " + commandArguments[0] + " " + commandArguments[1]);
                } else {
                    return new CommandResult(CommandResultType.FAILURE, "your seed must be within 7 and 1337");
                }

            } else {
                return new CommandResult(CommandResultType.FAILURE, "mode not found");
            }
        } else {
            return new CommandResult(CommandResultType.FAILURE, "this command is not available");
        }
    }

    @Override
    public int getNumberOfArguments() {
        return 2;
    }
}
