package edu.kit.informatik.command.player;


import edu.kit.informatik.ArtificialIntelligence;
import edu.kit.informatik.MemoryCell;
import edu.kit.informatik.command.CommandResult;
import edu.kit.informatik.userinteaction.InOutput;

import java.util.*;

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


    private final MemoryCell[] memory;
    private final Map<String, CommandPlayer> commands;
    private boolean running = false;

    private GameState gameState = GameState.INIT_PHASE;

    private static String[] initMode = new String[2];
    private static List<ArtificialIntelligence> aiList= new ArrayList<>();
    public String[] getInitMode() {
        return initMode;
    }

    public void setInitMode(String[] initMode) {
        CommandHandlerPlayer.initMode = initMode;
    }

    public CommandHandlerPlayer(MemoryCell[] memory) {
        this.memory = Objects.requireNonNull(memory);
        this.commands = new HashMap<>();
        this.initCommands();
        initMode[0] = "INIT_MODE_STOP";
        initMode[1] = "";
    }


    public void handleUserInput() {
        this.running = true;

        try (Scanner scanner = new Scanner(System.in)) {
            while (running && scanner.hasNextLine()) {
                executeCommand(scanner.nextLine());
            }
        }
    }

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
        } else if (commands.get(commandName).getNumberOfArguments() < commandArguments.length) {
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
        this.addCommand(INIT_COMMAND_NAME, new InitCommand(this));
        this.addCommand(ADD_COMMAND_NAME, new AddCommand(this));
        this.addCommand(REMOVE_COMMAND_NAME, new RemoveCommand());
        this.addCommand(START_COMMAND_NAME, new StartCommand());

    }
    public void changeInitMode(String[] mode) {

    }
    private void addCommand(String commandName, CommandPlayer command) {
        this.commands.put(commandName, command);
    }

}
