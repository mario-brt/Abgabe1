package edu.kit.informatik.command.ai;

public enum AICommands {
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

    AICommands (final int newPosition) {
        position = newPosition;
    }

    public int getCommand() {
        return position;
    }
}
