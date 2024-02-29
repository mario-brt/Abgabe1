package edu.kit.informatik.userinteaction;

import java.util.Scanner;

public class InOutput {

    public static String nextInput() {
        String nextInput;
        Scanner scanner = new Scanner(System.in);
        nextInput = scanner.nextLine();
        scanner.close();
        return nextInput;
    }

    public static void print(String text) {
        System.out.println(text);
    }
}
