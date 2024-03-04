package edu.kit.informatik.userinteaction;

import java.util.Scanner;

public final class InOutput {

    private InOutput() {

    }
    public static String nextInput() {
        String nextInput;
        Scanner scanner = new Scanner(System.in);
        nextInput = scanner.nextLine();

        return nextInput;
    }

    public static void print(String text) {
        System.out.println(text);
    }
}
