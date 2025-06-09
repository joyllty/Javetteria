package view;

import utils.InputHelper;

import java.util.Scanner;

public class MenuFuncionario {
    //#---------------- CORES ----------------#
    public static final String LAVENDER = "\u001B[38;5;183m";
    public static final String CREME = "\u001B[38;5;229m";
    public static final String BROWN = "\u001B[38;5;130m";
    public static final String RESET = "\u001B[0m";
    //---------------------------#--------------------------//

    public static void menuFuncionario(){
        int op;

        do {
            System.out.println("\n ╔══════════════════════════╗");
            System.out.println(" ║                          ║");
            System.out.println(" ║ [1] REGISTRAR PEDIDOS    ║");
            System.out.println(" ║ [2] ACOMPANHAR PEDIDOS   ║");
            System.out.println(" ║ [3] PAGAMENTO            ║");
            System.out.println(" ║ [4] VOLTAR               ║");
            System.out.println(" ║                          ║");
            System.out.println(" ╚══════════════════════════╝ ");

            System.out.print(
                    "\n" + (LAVENDER + ">>" + RESET) + CREME + " Selecione uma opção: ");
            op = InputHelper.lerInt();

            switch(op){
                case 1:
                    System.out.println("Registrando pedido......");

                    break;
                case 2:
                    System.out.println("Exibir fila de pedidos.....");
                    break;
                case 3:
                    System.out.println("[1] CARTÃO\n[2] DINHEIRO\n[3]PIX");
                    break;
                case 4:
                    System.out.println("\nVoltando...");
                    break;
                default:
                    System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + " Opção inválida!");
            }

        } while (op != 4);
    }
}
