package edu.kit.informatik;

import edu.kit.informatik.command.ai.AICommands;

public class Main {
    public static void main (String[] args) {
        String x = "INIT_MODE_RANDOM 23";
        System.out.println(Integer.parseInt(x.replaceAll("\\D", "")));
    }
}
