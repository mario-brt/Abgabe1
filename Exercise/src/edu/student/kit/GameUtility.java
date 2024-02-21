package edu.student.kit;

import edu.student.kit.userinteaction.InOutput;

public abstract class GameUtility {
    private static final int MEMORY_MIN_VALUE = 7;
    private static final int MEMORY_MAX_VALUE = 1337;
    private static final String MEMORY_ERROR_MESSAGE = "Error, your value for the memory size is not an allowed value";
    private static final String SYMBOLS_ERROR_MESSAGE = "Error, the given symbols are not allowed";
    private static final String GREETING_MESSAGE = "Welcome to CodeFight 2024. Enter 'help' for more details.";

    public GameUtility() {

    }

    public static void initializeGame(String[] args) {
        if (checkArgumentsGameStart(args)) {
            Memory memory = new Memory(Integer.parseInt(args[0]) - 1);
        }
    }
    private static boolean checkArgumentsGameStart(String[] args) {
        if(checkMemorySize(args)) {
            if (checkArgumentsLength(args)) {
                if (checkArgumentsRepetitive(args)){
                    for (int i = 1; i < args.length; i++) {
                        if (args[i].contains(" ")) {
                            return false;
                        }
                    }
                    return true;
                }else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }

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
    private static boolean checkArgumentsLength(String[] args) {
        return args.length >= 9;
    }

    private static boolean checkMemorySize(String[] args) {
        int memorySize = 0;
        try {
            memorySize = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            InOutput.print(MEMORY_ERROR_MESSAGE);
        }
        if (memorySize != 0) {
            return memorySize <= MEMORY_MAX_VALUE && memorySize >= MEMORY_MIN_VALUE;
        } else {
            return false;
        }
    }

    private static boolean checkSymbols(String[] symbols) {
        for (String symbol : symbols) {
            if (symbol.contains(" ")) {
                InOutput.print(SYMBOLS_ERROR_MESSAGE);
                return false;
            }
            for (String otherSymbol : symbols) {
                if (symbol.equals(otherSymbol) && (symbol != otherSymbol)) {
                    InOutput.print(SYMBOLS_ERROR_MESSAGE);
                    return false;
                }
            }

        }
        return true;
    }

    private static boolean checkArgumentsAddCommand(String arguments) {
        return true;
    }



}
