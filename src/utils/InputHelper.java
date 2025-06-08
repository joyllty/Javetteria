package utils;

import java.util.Scanner;

public class InputHelper {

    private static final Scanner input = new Scanner(System.in);

    public static int lerInt() {
        return Integer.parseInt(input.nextLine());
    }
    public static String lerString() {
        return input.nextLine();
    }
    public static float lerFloat() {
        return Float.parseFloat(input.nextLine().replace(",", "."));
    }

    public static void limparBuffer() {
        input.nextLine();
    }
}