package edu.kit.informatik;


import edu.kit.informatik.command.ai.AICommandsEnum;
import edu.kit.informatik.command.player.CommandHandlerPlayer;
import edu.kit.informatik.command.player.CommandPlayer;
import edu.kit.informatik.userinteaction.InOutput;

import java.util.Random;

public class Main {
    private static final int MEMORY_MIN_VALUE = 7;
    private static final int MEMORY_MAX_VALUE = 1337;
    private static final String MEMORY_ERROR_MESSAGE = "Error, your value for the memory size is not an allowed value";

    public static void main(String[] args) {
        if(checkArgumentsGameStart(args)){
            System.out.println("Welcome to CodeFight 2024. Enter 'help' for more details");
            MemoryCell[] memory = new MemoryCell[Integer.parseInt(args[0])];
            for (int i = 0; i < memory.length; i++) {
                memory[i] = new MemoryCell();
            }
            CommandHandlerPlayer commandPlayer = new CommandHandlerPlayer(memory, calcMaxAis(args));
            commandPlayer.handleUserInput();
        }


    }

    private static int calcMaxAis(String[] args){
        return (args.length - 5) / 2;
    }
    private static boolean checkArgumentsGameStart(String[] args) {

        return checkArgumentsLength(args) && checkArgumentsRepetitive(args) && checkMemorySize(args) && checkContainsWhitespace(args);
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
        return args.length >= 9 && args.length % 2 == 1;
    }

    private static boolean checkMemorySize(String[] args) {
        int memorySize = 0;
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
    private static boolean checkContainsWhitespace(String[] args) {
        for (int i = 1; i < args.length; i++) {
            if (args[i].contains(" ")) {
                return false;
            }
        }
        return true;
    }

}

