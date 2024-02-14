package edu.student.kit.main;

import edu.student.kit.Memory;

public final class Game {
    private static final int MEMORY_MIN_VALUE = 7;
    private static final int MEMORY_MAX_VALUE = 1337;
    private static final String MEMORY_ERROR_MESSAGE = "Error, your value for the memory size is not an allowed value";
    private static final String SYMBOLS_ERROR_MESSAGE = "Error, the given symbols are not allowed";
    private static final String GREETING_MESSAGE = "Welcome to CodeFight 2024. Enter 'help' for more details.";

    private Game() {

    }

    private static boolean checkArguments(String[] args) {
        try {
            if (!checkMemorySize(Integer.parseInt(args[0]))) {
                System.out.println(MEMORY_ERROR_MESSAGE);
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println(MEMORY_ERROR_MESSAGE);
            return false;
        }
    }

    private static boolean checkMemorySize(int memorySize) {
        return memorySize >= MEMORY_MIN_VALUE && memorySize <= MEMORY_MAX_VALUE;
    }

    private static boolean checkSymbols(String[] symbols) {
        for (String symbol : symbols) {
            if (symbol.contains(" ")) {
                System.out.println(SYMBOLS_ERROR_MESSAGE);
                return false;
            }
            for (String otherSymbol : symbols) {
                if (symbol.equals(otherSymbol) && (symbol != otherSymbol)) {
                    System.out.println(SYMBOLS_ERROR_MESSAGE);
                    return false;
                }
            }

        }
        return true;
    }


    public static void initializeGame(String[] args) {
        if (checkArguments(args)) {
            Memory memory = new Memory(Integer.parseInt(args[0]) - 1);
        }
    }
}
