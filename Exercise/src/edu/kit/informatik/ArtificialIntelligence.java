package edu.kit.informatik;

import edu.kit.informatik.command.ai.AiCommand;

public class ArtificialIntelligence {



    private  final String name;
    private AiCommand[] commands;
    private boolean running = true;


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
    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

}
