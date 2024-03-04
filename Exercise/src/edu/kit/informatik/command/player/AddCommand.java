package edu.kit.informatik.command.player;

import edu.kit.informatik.ArtificialIntelligence;
import edu.kit.informatik.MemoryCell;
import edu.kit.informatik.command.CommandResult;
import edu.kit.informatik.command.CommandResultType;
import edu.kit.informatik.command.ai.AICommandsEnum;
import edu.kit.informatik.command.ai.AiCommand;

public class AddCommand implements CommandPlayer{


    private final CommandHandlerPlayer commandHandlerPlayer;

    AddCommand(CommandHandlerPlayer commandHandler) {
        this.commandHandlerPlayer = commandHandler;
    }
    /**
     * @param ignored           the memory to execute the command on
     * @param commandArguments the arguments of the command
     * @param gameState
     * @return
     */
    @Override
    public CommandResult execute(MemoryCell[] ignored, String[] commandArguments, GameState gameState) {
        if (commandArguments.length % 3 != 1) {
            return new CommandResult(CommandResultType.FAILURE, "your arguments are faulty");
        }
        String name = commandArguments[0];
        AiCommand[] commands = new AiCommand[commandArguments.length / 3];
        for(int i = 1; i < commandArguments.length; i+=3) {
            for (int j = 0; j < commands.length; j ++ ) {
                commands[j] = new AiCommand(AICommandsEnum.commandArguments[i], commandArguments[i+1], commandArguments[i+2]);
            }
        }
    }

    @Override
    public int getNumberOfArguments() {
        return 0;
    }
}
