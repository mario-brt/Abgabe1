package edu.kit.informatik;

import edu.kit.informatik.command.ai.AICommandsEnum;

/**
 * Represents a memory cell used in the game.
 * @author uistu
 */
public class MemoryCell {

    private AICommandsEnum aiCommand = AICommandsEnum.STOP;
    private int argument1 = 0;
    private int argument2 = 0;
    private String symbol;
    private boolean wasEdited = false;

    /**
     * Constructs a MemoryCell object with the specified default symbol.
     *
     * @param defaultSymbol the default symbol for the memory cell
     */
    public MemoryCell(String defaultSymbol) {
        this.symbol = defaultSymbol;
    }

    // Setter methods

    /**
     * Sets the AI command for this memory cell.
     *
     * @param aiCommand the AI command to set
     */
    public void setAiCommand(AICommandsEnum aiCommand) {
        this.aiCommand = aiCommand;
        wasEdited = true;
    }

    /**
     * Sets the first argument for this memory cell.
     *
     * @param argument1 the first argument to set
     */
    public void setArgument1(int argument1) {
        this.argument1 = argument1;
    }

    /**
     * Sets the second argument for this memory cell.
     *
     * @param argument2 the second argument to set
     */
    public void setArgument2(int argument2) {
        this.argument2 = argument2;
    }

    /**
     * Sets the symbol for this memory cell.
     *
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Sets whether this memory cell was edited or not.
     *
     * @param wasEdited true if the memory cell was edited, false otherwise
     */
    public void setWasEdited(boolean wasEdited) {
        this.wasEdited = wasEdited;
    }

    // Getter methods

    /**
     * Gets the AI command of this memory cell.
     *
     * @return the AI command of this memory cell
     */
    public AICommandsEnum getAiCommand() {
        return this.aiCommand;
    }

    /**
     * Gets the first argument of this memory cell.
     *
     * @return the first argument of this memory cell
     */
    public int getArgument1() {
        return argument1;
    }

    /**
     * Gets the second argument of this memory cell.
     *
     * @return the second argument of this memory cell
     */
    public int getArgument2() {
        return argument2;
    }

    /**
     * Gets the symbol of this memory cell.
     *
     * @return the symbol of this memory cell
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Checks whether this memory cell was edited or not.
     *
     * @return true if the memory cell was edited, false otherwise
     */
    public boolean isWasEdited() {
        return wasEdited;
    }
}
