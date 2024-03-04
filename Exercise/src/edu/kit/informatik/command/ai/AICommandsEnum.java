package edu.kit.informatik.command.ai;

/**
 * Enum representing different AI commands.
 * @author uistu
 */
public enum AICommandsEnum {
    STOP(0),
    MOV_R(1),
    MOV_I(2),
    ADD(3),
    ADD_R(4),
    JMP(5),
    JMZ(6),
    CMP(7),
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
