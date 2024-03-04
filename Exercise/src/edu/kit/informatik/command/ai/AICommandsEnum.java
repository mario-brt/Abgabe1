package edu.kit.informatik.command.ai;

/**
 * Enum representing the STOP command for the AI.
 * This command stops the AI's execution.
 * It has a position of 0 in the command sequence.
 *
 * @author uistu
 */
public enum AICommandsEnum {
    /**
     * STOP command.
     */
    STOP(0),
    /**
     * MOV_R command.
     */
    MOV_R(1),
    /**
     * MOV_I command.
     */
    MOV_I(2),
    /**
     * ADD command.
     */
    ADD(3),
    /**
     * ADD_R command.
     */
    ADD_R(4),
    /**
     * JMP command.
     */
    JMP(5),
    /**
     * JMZ command.
     */
    JMZ(6),
    /**
     * CMP command.
     */
    CMP(7),
    /**
     * SWAP command.
     */
    SWAP(8);

    private final int position;

    /**
     * Constructs an AICommandsEnum object with the specified position.
     *
     * @param newPosition The position of the command
     */
    AICommandsEnum(final int newPosition) {
        position = newPosition;
    }

    /**
     * Retrieves the position of the command.
     *
     * @return The position of the command
     */
    public int getCommand() {
        return position;
    }
}
