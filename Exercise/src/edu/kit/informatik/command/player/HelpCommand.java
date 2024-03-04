package edu.kit.informatik.command.player;

import edu.kit.informatik.MemoryCell;
import edu.kit.informatik.command.CommandResult;
import edu.kit.informatik.command.CommandResultType;

public class HelpCommand implements CommandPlayer{


    private static final String ADD_AI_COMMAND_DESCRIPTION =
            "add-ai: Adds an AI with a name and a list of commands which can be chosen by you";
    private static final String REMOVE_AI_COMMAND_DESCRIPTION = "remove-ai: removes the given AI";
    private static final String SET_INIT_MODE_COMMAND_DESCRIPTION =
            "set-init-mode: Sets game mode: INIT_MODE_RANDOM [Seed] sets a random memory, INIT_MODE_STOP sets all memory cells to stop";
    private static final String START_GAME_COMMAND_DESCRIPTION = "start-game: starts the game";
    private static final String NEXT_COMMAND_DESCRIPTION =
            "next: executes the next AI commands of the AIs. The format of the command is as follows: next [number of AI commands]. "
                    + "The number of AI commands is optional and 1 by default";
    private static final String SHOW_MEMORY_COMMAND_DESCRIPTION =
            "displays the current state of the memory. A distinction is made between the memory display and the area display";
    private static final String SHOW_AI_COMMAND_DESCRIPTION = "show-ai: displays the current state of the AI";

    private static final String END_GAME_COMMAND_DESCRIPTION = "end-game: ends the game and displays the AI's";


    private static final String HELP_COMMAND_DESCRIPTION = "help: shows all the available commands";
    private static final String QUIT_COMMAND_DESCRIPTION = "quit: ends the game immediately";
    /**
     * @param memory           the memory to execute the command on
     * @param commandArguments the arguments of the command
     * @param gameState the state of the game
     * @return
     */
    @Override
    public CommandResult execute(MemoryCell[] memory, String[] commandArguments, GameState gameState) {
        if (gameState == GameState.INIT_PHASE) {
            return new CommandResult(CommandResultType.SUCCESS, ADD_AI_COMMAND_DESCRIPTION + "\n"
                    + HELP_COMMAND_DESCRIPTION + "\n"
                    + QUIT_COMMAND_DESCRIPTION + "\n"
                    + REMOVE_AI_COMMAND_DESCRIPTION + "\n"
                    + SET_INIT_MODE_COMMAND_DESCRIPTION + "\n"
                    + START_GAME_COMMAND_DESCRIPTION);
        } else {
            return new CommandResult(CommandResultType.SUCCESS, END_GAME_COMMAND_DESCRIPTION + "\n"
                    + HELP_COMMAND_DESCRIPTION + "\n"
                    + NEXT_COMMAND_DESCRIPTION + "\n"
                    + QUIT_COMMAND_DESCRIPTION + "\n"
                    + SHOW_AI_COMMAND_DESCRIPTION + "\n"
                    + SHOW_MEMORY_COMMAND_DESCRIPTION + "\n");
        }
    }

    /**
     * @return number of arguments
     */
    @Override
    public int getNumberOfArguments() {
        return 0;
    }
}
