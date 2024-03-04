package edu.kit.informatik.command.player;

import edu.kit.informatik.ArtificialIntelligence;
import edu.kit.informatik.MemoryCell;
import edu.kit.informatik.command.CommandResult;
import edu.kit.informatik.command.CommandResultType;
import edu.kit.informatik.command.ai.AICommandsEnum;

import java.util.List;
import java.util.Random;

public class StartCommand implements CommandPlayer{

    private final CommandHandlerPlayer commandHandlerPlayer;
    private static final int NUMBER_OF_AI_COMMANDS = 7;

    StartCommand(CommandHandlerPlayer commandHandler) {
        this.commandHandlerPlayer = commandHandler;
    }
    /**
     * @param memory           the memory to execute the command on
     * @param commandArguments the arguments of the command
     * @param gameState the state of the game
     * @return
     */
    @Override
    public CommandResult execute(MemoryCell[] memory, String[] commandArguments, GameState gameState) {
        if (gameState == GameState.PLAY_PHASE) {
            return new CommandResult(CommandResultType.FAILURE, "the game has already started");
        }
        initializeMemory(memory, commandArguments[1]);
        loadAis(commandHandlerPlayer.getAiList(), memory);


        return new CommandResult(CommandResultType.SUCCESS, "Game started.");
    }

    /**
     * @return
     */
    @Override
    public int getNumberOfArguments() {
        return 0;
    }
    private void initializeMemory(MemoryCell[] memory, String seedString) {
        if (commandHandlerPlayer.getInitMode()[0].equals("INIT_MODE_STOP")) {
            for (MemoryCell memoryCell : memory) {
                memoryCell.setAiCommand(AICommandsEnum.STOP);
                memoryCell.setArgument1(0);
                memoryCell.setArgument2(0);
            }
        } else  {
            int seed = Integer.parseInt(seedString);
            Random ran = new Random(seed);
            AICommandsEnum[] commands = AICommandsEnum.values();
            for (MemoryCell memoryCell : memory) {
                memoryCell.setAiCommand(commands[ran.nextInt(NUMBER_OF_AI_COMMANDS)]);
                memoryCell.setArgument1(ran.nextInt());
                memoryCell.setArgument2(ran.nextInt());
            }
        }
    }
    private void loadAis(List<ArtificialIntelligence> artificialIntelligences, MemoryCell[] memoryCells) {

    }
}
