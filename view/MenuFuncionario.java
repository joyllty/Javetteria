package view;

import model.Menu;
import utils.Cores;
import utils.InputHelper;

import java.util.Scanner;

public class MenuFuncionario implements Menu {
    //#---------------- CORES ----------------#
    public static final String LAVENDER = "\u001B[38;5;183m";
    public static final String CREME = "\u001B[38;5;229m";
    public static final String BROWN = "\u001B[38;5;130m";
    public static final String RESET = "\u001B[0m";
    //---------------------------#--------------------------//

    // função principal do menu funcionário - sobrescrita
    @Override
    public void executar() {
        int opFuncionario = 0;
        do {
            menuFuncionario();
            opFuncionario= InputHelper.lerInt();
            verificarOp(opFuncionario);

        } while (opFuncionario != 4);
    }

    // ler opção do menu funcionário
    public void verificarOp(int op){

        switch (op) {
            case 1 -> System.out.println("Registrando pedido......");
            case 2 -> System.out.println("Exibir fila de pedidos.....");
            case 3 -> System.out.println("[1] CARTÃO\n[2] DINHEIRO\n[3]PIX");
            case 4 -> System.out.println("\nVoltando...");
            default -> System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + " Opção inválida!");
        }
    }

    // view menu funcionario
    public static void menuFuncionario(){
        System.out.println("\n  =======" + (Cores.LAVENDER +  " FUNCIONÁRIO " + Cores.RESET) + Cores.CREME +  "======");
        System.out.println(" ╔══════════════════════════╗");
        System.out.println(" ║                          ║");
        System.out.println(" ║ [1] REGISTRAR PEDIDOS    ║");
        System.out.println(" ║ [2] ACOMPANHAR PEDIDOS   ║");
        System.out.println(" ║ [3] PAGAMENTO            ║");
        System.out.println(" ║ [4] VOLTAR               ║");
        System.out.println(" ║                          ║");
        System.out.println(" ╚══════════════════════════╝ ");

        System.out.print(
                "\n" + (LAVENDER + ">>" + RESET) + CREME + " Selecione uma opção: ");

    }
}
