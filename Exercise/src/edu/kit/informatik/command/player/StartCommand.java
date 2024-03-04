package edu.kit.informatik.command.player;

import edu.kit.informatik.ArtificialIntelligence;
import edu.kit.informatik.MemoryCell;
import edu.kit.informatik.command.CommandResult;
import edu.kit.informatik.command.CommandResultType;
import edu.kit.informatik.command.ai.AICommandsEnum;

import java.util.List;
import java.util.Random;

/**
 * Represents a command for starting the game.
 * @author uistu
 * @author Programmieren-Team
 */
public class StartCommand implements CommandPlayer {

    private static final int NUMBER_OF_AI_COMMANDS = 7;
    private final CommandHandlerPlayer commandHandlerPlayer;


    /**
     * Constructs a StartCommand object with the specified CommandHandlerPlayer.
     *
     * @param commandHandler the CommandHandlerPlayer to associate with this command
     */
    StartCommand(CommandHandlerPlayer commandHandler) {
        this.commandHandlerPlayer = commandHandler;
    }

    /**
     * Executes the start command based on the current game state.
     *
     * @param memory           the memory to execute the command on
     * @param commandArguments the arguments of the command
     * @param gameState        the state of the game
     * @return the result of executing the command
     */
    @Override
    public CommandResult execute(MemoryCell[] memory, String[] commandArguments, GameState gameState) {
        if (gameState == GameState.PLAY_PHASE) {
            return new CommandResult(CommandResultType.FAILURE, "The game has already started.");
        }
        initializeMemory(memory, commandArguments[1]);
        loadAis(commandHandlerPlayer.getAiList(), memory);

        return new CommandResult(CommandResultType.SUCCESS, "Game started.");
    }

    /**
     * Gets the number of arguments required for this command.
     *
     * @return the number of arguments required
     */
    @Override
    public int getNumberOfArguments() {
        return 0;
    }

    /**
     * Initializes the memory with either STOP commands or random AI commands.
     *
     * @param memory    the memory to initialize
     * @param seedString the seed for random initialization
     */
    private void initializeMemory(MemoryCell[] memory, String seedString) {
        if (commandHandlerPlayer.getInitMode()[0].equals("INIT_MODE_STOP")) {
            for (MemoryCell memoryCell : memory) {
                memoryCell.setAiCommand(AICommandsEnum.STOP);
                memoryCell.setArgument1(0);
                memoryCell.setArgument2(0);
            }
        } else {
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

    /**
     * Loads the artificial intelligences into the game.
     *
     * @param artificialIntelligences the list of artificial intelligences
     * @param memoryCells             the memory cells of the game
     */
    private void loadAis(List<ArtificialIntelligence> artificialIntelligences, MemoryCell[] memoryCells) {
        // Implementation needed
    }
}
