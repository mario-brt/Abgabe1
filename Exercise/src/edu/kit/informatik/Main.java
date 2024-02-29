package edu.kit.informatik;

import edu.kit.informatik.userinteaction.InOutput;

public class Main {
    public static void main(String[] args) {
        String input = InOutput.nextInput();
        while (!input.equals("stop")) {
            if (input.equals("help")) {
                GameUtility.help();
            }

            input = InOutput.nextInput();
        }
    }
}

