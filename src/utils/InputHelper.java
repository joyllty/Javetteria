package utils;

import java.util.Scanner;

public class InputHelper {

    static Scanner input = new Scanner(System.in);

    public static int lerInt() {
        return Integer.parseInt(input.nextLine());
    }
    public static String lerString() {
        return input.nextLine();
    }
    public static float lerFloat() {
        return Float.parseFloat(input.nextLine().replace(",", "."));
    }
}