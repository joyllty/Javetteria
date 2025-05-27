package View;

import java.util.Scanner;

public class MenuGerente {
    public static final String LAVENDER = "\u001B[38;5;183m";
    public static final String CREME = "\u001B[38;5;229m";
    public static final String BROWN = "\u001B[38;5;130m";
    public static final String RESET = "\u001B[0m";

    public static Scanner input = new Scanner(System.in);
    //---------------------------#--------------------------//

    public static void menuGerente() {
        int opGerente;
        do {
            System.out.println("  __________________________");
            System.out.println(" |                          |");
            System.out.println(" | [1] PEDIDOS              |");
            System.out.println(" | [2] ESTOQUE              |");
            System.out.println(" | [3] GERENCIAMENTO        |");
            System.out.println(" | [4] VOLTAR               |");
            System.out.println(" |                          |");
            System.out.println(" |__________________________| ");

            System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + " Selecione uma opção: ");
            opGerente = input.nextInt();

            switch(opGerente){
                case 1:
                    menuGerentePedidos();
                    break;
                case 2:
                    System.out.println("ESTOQUE");
                    break;
                case 3:
                    System.out.println("Parei aqui\n[1] EXIBIR FUNCIONÁRIOS\n[2] HISTÓRICO DE VENDAS");

                    break;
                default:

            }

        } while (opGerente != 4);
    }

    public static void menuGerentePedidos(){
        int opPedidosG;
        do {
            System.out.println("  __________________________");
            System.out.println(" |                          |");
            System.out.println(" | [1] REGISTRAR PEDIDOS    |");
            System.out.println(" | [2] ACOMPANHAR PEDIDOS   |");
            System.out.println(" | [3] REMOVER PEDIDOS      |");
            System.out.println(" | [4] PAGAMENTO            |");
            System.out.println(" | [5] VOLTAR               |");
            System.out.println(" |                          |");
            System.out.println(" |__________________________| ");

            System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + " Selecione uma opção: ");
            opPedidosG = input.nextInt();

            switch(opPedidosG){
                case 1:
                    System.out.println("Registrando pedido......");
                    break;
                case 2:
                    System.out.println("Exibir fila de pedidos.....");
                    break;
                case 3:
                    System.out.println("Buscar pedido por numero e remover");
                    break;
                case 4:
                    System.out.println("[1] CARTÃO\n[2] DINHEIRO\n[3]PIX");
                    break;
                case 5:
                    break;

                default:
                    System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + "Opção inválida! Digite novamente: ");
                    opPedidosG = input.nextInt();
            }

        } while(opPedidosG != 5);
    }

}
