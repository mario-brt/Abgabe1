package edu.kit.informatik;

import edu.kit.informatik.command.ai.AICommandsEnum;
import edu.kit.informatik.command.player.CommandHandlerPlayer;
import edu.kit.informatik.userinteaction.InOutput;

import java.util.Random;

public abstract class GameUtility {
    private static final int MEMORY_MIN_VALUE = 7;
    private static final int MEMORY_MAX_VALUE = 1337;
    private static final int NUMBER_AI_COMMAND = 7;
    private static final String MEMORY_ERROR_MESSAGE = "Error, your value for the memory size is not an allowed value";
    private static final String SYMBOLS_ERROR_MESSAGE = "Error, the given symbols are not allowed";
    private static final String GREETING_MESSAGE = "Welcome to CodeFight 2024. Enter 'help' for more details.";
    private static final String START_MESSAGE = "Game started";
    private static final String INIT_MODE_RANDOM = "INIT_MODE_RANDOM";
    private static final String REGEX_START_GAME = "start-game\\s((\\S+\\s)+)+";
    private static final String HELP_COMMAND = "help";
    private static final String QUIT_COMMAND = "quit";
    private static final String END_COMMAND = "end-game";

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

    private static final String END_GAME_COMMAND_DESCRIPTION ="end-game: ends the game and displays the AI's";


    private static final String HELP_COMMAND_DESCRIPTION = "help: shows all the available commands";
    private static final String QUIT_COMMAND_DESCRIPTION = "quit: ends the game immediately";


    public GameUtility() {

    }

    public static void initializeGame(String[] args) {
        if (checkArgumentsGameStart(args)) {
            Memory memory = new Memory(Integer.parseInt(args[0]) - 1);
        }
    }

    protected static boolean checkArgumentsGameStart(String[] args) {
        if (checkMemorySize(args)) {
            if (checkArgumentsLength(args)) {
                if (checkArgumentsRepetitive(args)) {
                    for (int i = 1; i < args.length; i++) {
                        if (args[i].contains(" ")) {
                            return false;
                        }
                    }
                    return true;
                } else {
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


    protected boolean validateStartGame(String command) {
        return true;
    }

    protected void setInitMode(String mode, Memory memory) {

        if (mode.contains(INIT_MODE_RANDOM)) { //RANDOM
            int seed = Integer.parseInt(mode.replaceAll("\\D", "")); //replaces all letters with whitespace and takes value of int
            Random ran = new Random(seed);
            AICommandsEnum[] commands = AICommandsEnum.values();
            for (int i = 0; i < memory.MEMORY_CELLS.length; i++) {
                memory.MEMORY_CELLS[i].setAiCommand(commands[ran.nextInt(NUMBER_AI_COMMAND)]);
                memory.MEMORY_CELLS[i].setArgument1(ran.nextInt());
                memory.MEMORY_CELLS[i].setArgument2(ran.nextInt());
            }
        } else { //STOP
            for (int i = 0; i < memory.MEMORY_CELLS.length; i++) {
                memory.MEMORY_CELLS[i].setAiCommand(AICommandsEnum.STOP);
                memory.MEMORY_CELLS[i].setArgument1(0);
                memory.MEMORY_CELLS[i].setArgument2(0);
            }
        }
    }


    protected boolean initializeGame(Memory memory) {
        System.out.println(GREETING_MESSAGE);
        String input = InOutput.nextInput();
        String initMode = "";
        //herausfinden wie die KIS im speicher liegen und generell wann und wie alles darauf geladen wird
        System.out.println(GREETING_MESSAGE);
        while (!input.matches(REGEX_START_GAME)) {
            if (input.equals(QUIT_COMMAND)) {
                return false;
            }
            while (input.equals(HELP_COMMAND)) {
                input = help(0);
            }
            CommandHandlerPlayer.executePlayerCommand(input, memory);
            input = InOutput.nextInput();
            if (input.matches(REGEX_START_GAME)) {
                if (!validateStartGame(input)) {
                    input = "";
                }
            }
        }
        setInitMode(initMode, memory);
        return true;
    }

    protected void startGame() {
        String input = InOutput.nextInput();
        while (!input.equals(END_COMMAND)) {
            if (input.equals(QUIT_COMMAND)) {
                break;
            }
            while (input.equals(HELP_COMMAND)) {
                input = help(1);
            }

        }
        System.out.println(START_MESSAGE);

    }

    public static String help(int gameState) { //0: initialize phase - 1: play phase
        if (gameState == 0) {
            System.out.println(ADD_AI_COMMAND_DESCRIPTION);
            System.out.println(HELP_COMMAND_DESCRIPTION);
            System.out.println(QUIT_COMMAND_DESCRIPTION);
            System.out.println(REMOVE_AI_COMMAND_DESCRIPTION);
            System.out.println(SET_INIT_MODE_COMMAND_DESCRIPTION);
            System.out.println(START_GAME_COMMAND_DESCRIPTION);
        } else {
            System.out.println(END_GAME_COMMAND_DESCRIPTION);
            System.out.println(HELP_COMMAND_DESCRIPTION);
            System.out.println(NEXT_COMMAND_DESCRIPTION);
            System.out.println(QUIT_COMMAND_DESCRIPTION);
            System.out.println(SHOW_AI_COMMAND_DESCRIPTION);
            System.out.println(SHOW_MEMORY_COMMAND_DESCRIPTION);
        }



        return InOutput.nextInput();
    }

}



