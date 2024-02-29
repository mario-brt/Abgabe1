package edu.kit.informatik.command.player;


import edu.kit.informatik.Memory;

public class CommandHandlerPlayer {

    //Eventuell nochmal überarbeiten dass der speicher erst bein start game geladen wird
    private static final String regexAddAi = "add-ai\\s(\\S+)\\s((STOP|MOV_R|MOV_I|ADD|ADD_R|JMP|JMZ|CMP|SWAP),-?\\d+,-?\\d+(,\\s*)?)+";
    private static final String regexRemoveAi = "remove-ai\\s+(\\S+)";
    private static final String setInitModeRegex = "set-init-mode\\s((INIT_MODE_RANDOM\\s\\d+)|INIT_MODE_STOP)";

    public static void executePlayerCommand(String command, Memory memory) {
        if (command.matches(regexAddAi)) {
            addAi(command);
        } else if (command.matches(regexRemoveAi)) {
            removeAi(command);
        } else if (command.matches(setInitModeRegex)) {
            setInitMode(command);
        }
    }

    private static void addAi(String command) {

    }

    private static void removeAi(String command) {

    }

    private static void setInitMode(String command) {

    }

    private void startGame() {

    }

    private void next(int nextSteps) {

    }

    private void showMemory() {

    }

    private void showAi() {

    }

    private void endGame() {

    }
}
