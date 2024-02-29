package edu.kit.informatik;

import edu.kit.informatik.command.ai.AiCommand;

public class ArtificialIntelligence {



    private  final String name;
    private final AiCommand[] commands;
    private int commandChainIndex = 0;


    public ArtificialIntelligence(String name, AiCommand[] commandChain) {
        this.name = name;
        this.commands = new AiCommand[commandChain.length];
    }

    public AiCommand[] getCommandChain() {
        return commands;
    }

    public String getName() {
        return name;
    }

    public int getCommandChainIndex() {
        return commandChainIndex;
    }
    public void setCommandChainIndex() {
        this.commandChainIndex = (commandChainIndex + 1) % commands.length;
    }
}
