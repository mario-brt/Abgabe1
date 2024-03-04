package edu.kit.informatik.command.player;

import edu.kit.informatik.MemoryCell;
import edu.kit.informatik.command.CommandResult;
import edu.kit.informatik.command.CommandResultType;

/**
 * Represents a command for initializing the game state.
 */
public class InitCommand implements CommandPlayer {

    private final CommandHandlerPlayer commandHandlerPlayer;

    /**
     * Constructs an InitCommand object with the specified CommandHandlerPlayer.
     *
     * @param commandHandler the CommandHandlerPlayer to associate with this command
     */
    InitCommand(CommandHandlerPlayer commandHandler) {
        this.commandHandlerPlayer = commandHandler;
    }

    /**
     * Executes the initialization command based on the current game state.
     *
     * @param ignored           the memory to execute the command on (not used in this implementation)
     * @param commandArguments the arguments of the command
     * @param gameState        the current state of the game
     * @return the result of executing the command
     */
    @Override
    public CommandResult execute(MemoryCell[] ignored, String[] commandArguments, GameState gameState) {
        if (gameState == GameState.INIT_PHASE) {
            if (commandArguments.length > 2) {
                return new CommandResult(CommandResultType.FAILURE, "Too many arguments");
            }
            String[] oldInitMode = commandHandlerPlayer.getInitMode();
            String[] newCommandArguments = new String[2];
            newCommandArguments[0] = commandArguments[0];
            if (commandArguments[0].equals("INIT_MODE_STOP")) {
                newCommandArguments[1] = "";
                commandHandlerPlayer.setInitMode(commandArguments);
                if(oldInitMode[0].equals("INIT_MODE_STOP")) {
                    return new CommandResult(CommandResultType.SUCCESS, "Changed init mode from " + oldInitMode[0] + " to " + newCommandArguments[0]);
                } else {
                    return new CommandResult(CommandResultType.SUCCESS, "Changed init mode from " + oldInitMode[0] + " " + oldInitMode[1] + " to " + newCommandArguments[0]);
                }
            } else if (commandArguments[0].equals("INIT_MODE_RANDOM") && commandArguments.length == 2) {
                newCommandArguments[1] = commandArguments[1];
                int seed = 10000;
                try {
                    seed = Integer.parseInt(newCommandArguments[1]);
                } catch (NumberFormatException e) {
                    return new CommandResult(CommandResultType.FAILURE, "Your seed is invalid");
                }
                if (seed >= -1337 && seed <= 1337) {
                    commandHandlerPlayer.setInitMode(commandArguments);
                    if(oldInitMode[0].equals("INIT_MODE_STOP")) {
                        return new CommandResult(CommandResultType.SUCCESS, "Changed init mode from " + oldInitMode[0] + " to " + newCommandArguments[0] + " " + newCommandArguments[1]);
                    } else {
                        return new CommandResult(CommandResultType.SUCCESS, "Changed init mode from " + oldInitMode[0] + " " + oldInitMode[1] + " to " + newCommandArguments[0] + " " + newCommandArguments[1]);
                    }
                } else {
                    return new CommandResult(CommandResultType.FAILURE, "Your seed must be within -1337 and 1337");
                }

            } else {
                return new CommandResult(CommandResultType.FAILURE, "Mode not found");
            }
        } else {
            return new CommandResult(CommandResultType.FAILURE, "This command is not available");
        }
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
