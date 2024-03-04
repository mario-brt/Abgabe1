package edu.kit.informatik;

import edu.kit.informatik.command.player.CommandHandlerPlayer;
import edu.kit.informatik.userinteaction.InOutput;


/**
 * The main class that initializes and starts the CodeFight 2024 game.
 * @author uistu
 */
public final class Main {
    private static final int MEMORY_MIN_VALUE = 7;
    private static final int MEMORY_MAX_VALUE = 1337;
    private static final String MEMORY_ERROR_MESSAGE = "Error, your value for the memory size is not an allowed value";

    private Main() {

    }
    /**
     * The main method to start the CodeFight 2024 game.
     *
     * @param args the command line arguments specifying the game parameters
     */
    public static void main(String[] args) {
        if (checkArgumentsGameStart(args)) {
            System.out.println("Welcome to CodeFight 2024. Enter 'help' for more details");
            MemoryCell[] memory = new MemoryCell[Integer.parseInt(args[0])];
            for (int i = 0; i < memory.length; i++) {
                memory[i] = new MemoryCell(args[0]);
            }
            CommandHandlerPlayer commandPlayer = new CommandHandlerPlayer(memory);
            commandPlayer.handleUserInput();
        }
    }

    /**
     * Calculates the maximum number of AI opponents based on the command line arguments.
     *
     * @param args the command line arguments
     * @return the maximum number of AI opponents
     */
    private static int calcMaxAis(String[] args) {
        return (args.length - 5) / 2;
    }

    /**
     * Checks if the command line arguments are valid for starting the game.
     *
     * @param args the command line arguments
     * @return true if the arguments are valid, false otherwise
     */
    private static boolean checkArgumentsGameStart(String[] args) {
        return checkArgumentsLength(args) && checkArgumentsRepetitive(args) && checkMemorySize(args) && checkContainsWhitespace(args);
    }

    /**
     * Checks if the command line arguments contain any repetitive values.
     *
     * @param args the command line arguments
     * @return true if there are no repetitive values, false otherwise
     */
    private static boolean checkArgumentsRepetitive(String[] args) {
        for (int i = 1; i < args.length; i++) {
            for (int j = 1; j < args.length; j++) {
                if (args[i].equals(args[j]) && i != j) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if the number of command line arguments is valid.
     *
     * @param args the command line arguments
     * @return true if the number of arguments is valid, false otherwise
     */
    private static boolean checkArgumentsLength(String[] args) {
        return args.length >= 9 && args.length % 2 == 1;
    }

    /**
     * Checks if the specified memory size is within the allowed range.
     *
     * @param args the command line arguments
     * @return true if the memory size is valid, false otherwise
     */
    private static boolean checkMemorySize(String[] args) {
        int memorySize;
        try {
            memorySize = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            InOutput.print(MEMORY_ERROR_MESSAGE);
            return false;
        }
        if (memorySize != 0) {
            return memorySize <= MEMORY_MAX_VALUE && memorySize >= MEMORY_MIN_VALUE;
        } else {
            return false;
        }
    }

    /**
     * Checks if the command line arguments contain any whitespace.
     *
     * @param args the command line arguments
     * @return true if there are no whitespaces, false otherwise
     */
    private static boolean checkContainsWhitespace(String[] args) {
        for (int i = 1; i < args.length; i++) {
            if (args[i].contains(" ")) {
                return false;
            }
        }
        return true;
    }
}
