package utils;

import java.util.Scanner;

public class InputHelper {

    static Scanner input = new Scanner(System.in);

    public static int lerInt() {
        while (true) {
            try {
                String entrada = input.nextLine().trim();
                if (entrada.isEmpty()) {
                    System.out.println("Erro: Entrada vazia. Por favor, digite um número.");
                    continue;
                }
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite um número válido.");
            }
        }
    }

    public static String lerString() {
        while (true) {
            String entrada = input.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("Erro: Entrada vazia. Por favor, digite um texto.");
                continue;
            }
            return entrada;
        }
    }

    public static float lerFloat() {
        while (true) {
            try {
                String entrada = input.nextLine().trim();
                if (entrada.isEmpty()) {
                    System.out.println("Erro: Entrada vazia. Por favor, digite um número decimal.");
                    continue;
                }
                return Float.parseFloat(entrada.replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite um número decimal válido.");
            }
        }
    }
}