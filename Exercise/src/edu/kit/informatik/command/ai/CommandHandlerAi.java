package edu.kit.informatik.command.ai;

import edu.kit.informatik.MemoryCell;

/**
 * Class responsible for executing AI commands on memory cells.
 * @author uistu
 */
public class CommandHandlerAi {

    /**
     * Executes the given AI command on the memory cells.
     *
     * @param memory        The memory cells to execute the command on
     * @param AICommand     The AI command to execute
     * @param argA          The first argument of the command
     * @param argB          The second argument of the command
     */
    public void executeAiCommand(MemoryCell[] memory, AICommandsEnum AICommand, int argA, int argB) {
        switch (AICommand) {
            case STOP:
                stop();
                break;
            case MOV_R:
                movR(memory, argA, argB);
                break;
            case MOV_I:
                movI(memory, argA, argB);
                break;
            case ADD:
                add(memory, argA, argB);
                break;
            case ADD_R:
                addR(memory, argA, argB);
                break;
            case JMP:
                jmp(memory, argA, argB);
                break;
            case JMZ:
                jmz(memory, argA, argB);
                break;
            case CMP:
                cmp(memory, argA, argB);
                break;
            case SWAP:
                swap(memory, argA, argB);
                break;
            default:
                // Do nothing for unrecognized commands
                break;
        }
    }

    private void stop() {
        // Implementation for STOP command
    }

    private void movR(MemoryCell[] memory, int argA, int argB) {
        // Implementation for MOV_R command
    }

    private void movI(MemoryCell[] memory, int argA, int argB) {
        // Implementation for MOV_I command
    }

    private void add(MemoryCell[] memory, int argA, int argB) {
        // Implementation for ADD command
    }

    private void addR(MemoryCell[] memory, int argA, int argB) {
        // Implementation for ADD_R command
    }

    private void jmp(MemoryCell[] memory, int argA, int argB) {
        // Implementation for JMP command
    }

    private void jmz(MemoryCell[] memory, int argA, int argB) {
        // Implementation for JMZ command
    }

    private void cmp(MemoryCell[] memory, int argA, int argB) {
        // Implementation for CMP command
    }

    private void swap(MemoryCell[] memory, int argA, int argB) {
        // Implementation for SWAP command
    }
}
