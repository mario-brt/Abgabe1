package edu.kit.informatik.command.ai;

import edu.kit.informatik.Memory;

public class CommandHandlerAi {

    public void executeAiCommand(Memory memory, AICommands AICommands, int argA, int argB) {
        switch(AICommands){
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

    private void movR(Memory memory, int argA, int argB) {

    }

    private void movI(Memory memory, int argA, int argB) {

    }

    private void add(Memory memory, int argA, int argB) {

    }

    private void addR(Memory memory, int argA, int argB) {

    }

    private void jmp(Memory memory, int argA, int argB) {

    }

    private void jmz(Memory memory, int argA, int argB) {

    }

    private void cmp(Memory memory, int argA, int argB) {

    }

    private void swap(Memory memory, int argA, int argB) {

    }

}
