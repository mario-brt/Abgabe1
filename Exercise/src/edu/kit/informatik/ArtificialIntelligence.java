package edu.kit.informatik;

public class ArtificialIntelligence {



    private  final String name;
    private final String[] commandChain;
    private int commandChainIndex = 0;


    public ArtificialIntelligence(String name, String[] commandChain) {
        this.name = name;
        this.commandChain = new String[commandChain.length];
    }

    public String[] getCommandChain() {
        return commandChain;
    }

    public String getName() {
        return name;
    }

    public int getCommandChainIndex() {
        return commandChainIndex;
    }
    public void setCommandChainIndex() {
        this.commandChainIndex = (commandChainIndex + 1) % commandChain.length;
    }
}
