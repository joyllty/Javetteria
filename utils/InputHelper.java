package utils;

import java.util.Scanner;

public class InputHelper {

    static Scanner input = new Scanner(System.in);

    public static int lerInt() {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("\n\u001B[38;5;130mEntrada inválida! Por favor, digite um número inteiro.\u001B[0m" +
                        Cores.CREME);
            }
        }
    }
    public static String lerString() {
        String entrada = input.nextLine().trim();
        while (entrada.isEmpty()) {
            System.out.println("\n\u001B[38;5;130mEntrada inválida! Por favor, digite um texto.\u001B[0m" +
                    Cores.CREME);
            entrada = input.nextLine().trim();
        }
        return entrada;
    }
    public static float lerFloat() {
        while (true) {
            try {
                return Float.parseFloat(input.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("\n\u001B[38;5;130mEntrada inválida! Por favor, digite um número decimal.\u001B[0m" +
                        Cores.CREME);
            }
        }
    }
}