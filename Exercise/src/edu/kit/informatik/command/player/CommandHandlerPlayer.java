package edu.kit.informatik.command.player;

import edu.kit.informatik.ArtificialIntelligence;
import edu.kit.informatik.MemoryCell;
import edu.kit.informatik.command.CommandResult;

import java.util.*;

/**
 * This class handles the commands issued by the player and executes them.
 * @author uistu
 * @author Programmieren-Team
 */
public final class CommandHandlerPlayer {

    private static final String COMMAND_SEPARATOR_REGEX = " +";
    private static final String ERROR_PREFIX = "Error, ";
    private static final String COMMAND_NOT_FOUND_FORMAT = "command '%s' not found!";
    private static final String WRONG_ARGUMENTS_COUNT_FORMAT = "wrong number of arguments for command '%s'!";
    private static final String INIT_COMMAND_NAME = "set-init-mode";
    private static final String ADD_COMMAND_NAME = "add-ai";
    private static final String REMOVE_COMMAND_NAME = "remove-ai";
    private static final String START_COMMAND_NAME = "start-game";
    private static final String INVALID_RESULT_TYPE_FORMAT = "Unexpected value: %s";
    private static final String HELP_COMMAND_NAME = "help";
    private static final String QUIT_COMMAND_NAME = "quit";

    private final MemoryCell[] memory;
    private final Map<String, CommandPlayer> commands;
    private boolean running = false;
    private GameState gameState = GameState.INIT_PHASE;
    private static String[] initMode = new String[2];
    private static List<ArtificialIntelligence> aiList = new ArrayList<>();

    /**
     * Sets the list of artificial intelligences.
     *
     * @param aiList The list of artificial intelligences to set
     */
    public void setAiList(List<ArtificialIntelligence> aiList) {
        CommandHandlerPlayer.aiList = aiList;
    }

    /**
     * Gets the list of artificial intelligences.
     *
     * @return The list of artificial intelligences
     */
    public List<ArtificialIntelligence> getAiList() {
        return aiList;
    }

    /**
     * Gets the current initialization mode.
     *
     * @return The current initialization mode
     */
    public String[] getInitMode() {
        return initMode;
    }

    /**
     * Sets the initialization mode.
     *
     * @param initMode The initialization mode to set
     */
    public void setInitMode(String[] initMode) {
        CommandHandlerPlayer.initMode = initMode;
    }

    /**
     * Constructs a new CommandHandlerPlayer instance with the given memory.
     *
     * @param memory The memory to initialize
     */
    public CommandHandlerPlayer(MemoryCell[] memory) {
        this.memory = Objects.requireNonNull(memory);
        this.commands = new HashMap<>();
        this.initCommands();
        initMode[0] = "INIT_MODE_STOP";
        initMode[1] = "";
    }

    /**
     * Handles the user input and executes the commands.
     */
    public void handleUserInput() {
        this.running = true;

        try (Scanner scanner = new Scanner(System.in)) {
            while (running && scanner.hasNextLine()) {
                executeCommand(scanner.nextLine());
            }
        }
    }

    /**
     * Quits the command handler, stopping user input processing.
     */
    public void quit() {
        this.running = false;
    }

    private void executeCommand(String commandWithArguments) {
        String[] splittedCommand = commandWithArguments.trim().split(COMMAND_SEPARATOR_REGEX);
        String commandName = splittedCommand[0];
        String[] commandArguments = Arrays.copyOfRange(splittedCommand, 1, splittedCommand.length);

        executeCommand(commandName, commandArguments);
    }

    private void executeCommand(String commandName, String[] commandArguments) {
        if (!commands.containsKey(commandName)) {
            System.err.println(ERROR_PREFIX + COMMAND_NOT_FOUND_FORMAT.formatted(commandName));
        } else if (commands.get(commandName).getNumberOfArguments() > commandArguments.length) {
            System.err.println(ERROR_PREFIX + WRONG_ARGUMENTS_COUNT_FORMAT.formatted(commandName));
        } else {
            CommandResult result = commands.get(commandName).execute(memory, commandArguments, gameState);
            String output = switch (result.getType()) {
                case SUCCESS -> result.getMessage();
                case FAILURE -> ERROR_PREFIX + result.getMessage();
            };
            if (output != null) {
                switch (result.getType()) {
                    case SUCCESS -> System.out.println(output);
                    case FAILURE -> System.err.println(output);
                    default -> throw new IllegalStateException(INVALID_RESULT_TYPE_FORMAT.formatted(result.getType()));
                }
            }
        }
    }

    private void initCommands() {
        this.addCommand(QUIT_COMMAND_NAME, new QuitCommand(this));
        this.addCommand(INIT_COMMAND_NAME, new InitCommand(this));
        this.addCommand(ADD_COMMAND_NAME, new AddCommand(this));
        this.addCommand(REMOVE_COMMAND_NAME, new RemoveCommand(this));
        this.addCommand(HELP_COMMAND_NAME, new HelpCommand());
        this.addCommand(START_COMMAND_NAME, new StartCommand(this));
    }

    private void addCommand(String commandName, CommandPlayer command) {
        this.commands.put(commandName, command);
    }
}
