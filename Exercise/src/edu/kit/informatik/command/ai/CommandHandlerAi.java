package edu.kit.informatik.command.ai;

import edu.kit.informatik.MemoryCell;

public class CommandHandlerAi {



    public void executeAiCommand(MemoryCell[] memory, AICommandsEnum AICommandsEnum, int argA, int argB) {
        switch(AICommandsEnum){
            case STOP:
                stop();
                break;
            case MOV_R:
                movR(memory, argA, argB);
                break;
            case MOV_I:
                movI(memory, argA,argB);
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

                break;
        }
    }

    private void stop() {

    }

    private void movR(MemoryCell[] memory, int argA, int argB) {

    }

    private void movI(MemoryCell[] memory, int argA, int argB) {

    }

    private void add(MemoryCell[] memory, int argA, int argB) {

    }

    private void addR(MemoryCell[] memory, int argA, int argB) {

    }

    private void jmp(MemoryCell[] memory, int argA, int argB) {

    }

    private void jmz(MemoryCell[] memory, int argA, int argB) {

    }

    private void cmp(MemoryCell[] memory, int argA, int argB) {

    }

    private void swap(MemoryCell[] memory, int argA, int argB) {

    }

}
