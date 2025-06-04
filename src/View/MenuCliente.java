package view;

import utils.InputHelper;

import java.util.Scanner;

public class MenuCliente {
    public static final String LAVENDER = "\u001B[38;5;183m";
    public static final String CREME = "\u001B[38;5;229m";
    public static final String BROWN = "\u001B[38;5;130m";
    public static final String RESET = "\u001B[0m";

    public static Scanner input = new Scanner(System.in);
    //---------------------------#--------------------------//

    public static void menuCliente(){
        int op;
        do {
            System.out.println("\n ╔═════════════════════════╗");
            System.out.println(" ║                         ║");
            System.out.println(" ║ [1] ABRIR CARDÁPIO      ║");
            System.out.println(" ║ [2] FAZER PEDIDO        ║");
            System.out.println(" ║ [3] VOLTAR              ║");
            System.out.println(" ║                         ║");
            System.out.println(" ╚═════════════════════════╝");

            System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + " Selecione uma opção: ");
            op = InputHelper.lerInt();


            switch(op){
                case 1 -> System.out.println("CARDÁPIO");
                case 2 -> System.out.println("CHAMANDO ATENDENTE");
                case 3 -> System.out.println("\nVoltando...");
                default -> System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + "Opção inválida!" +
                        " Digite novamente: ");
            }

        } while (op != 3);
    }
}
