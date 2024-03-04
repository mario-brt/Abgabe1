package edu.kit.informatik;

import edu.kit.informatik.command.ai.AiCommand;

/**
 * Represents an artificial intelligence (AI) in the game.
 * @author uistu
 */
public class ArtificialIntelligence {

    private final String name;
    private AiCommand[] commands;
    private boolean running = true;

    /**
     * Constructs an ArtificialIntelligence object with the specified name and command chain.
     *
     * @param name         the name of the AI
     * @param commandChain the command chain for the AI
     */
    public ArtificialIntelligence(String name, AiCommand[] commandChain) {
        this.name = name;
        this.commands = new AiCommand[commandChain.length];
    }

    /**
     * Gets the command chain of this AI.
     *
     * @return the command chain of this AI
     */
    public AiCommand[] getCommandChain() {
        return commands;
    }

    /**
     * Gets the name of this AI.
     *
     * @return the name of this AI
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if the AI is running.
     *
     * @return true if the AI is running, false otherwise
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Sets the running status of the AI.
     *
     * @param running true if the AI is running, false otherwise
     */
    public void setRunning(boolean running) {
        this.running = running;
    }
}
