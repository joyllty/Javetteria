package view;

import model.Funcionario;
import model.Gerente;
import model.Menu;
import utils.Cores;
import utils.InputHelper;

import java.util.Scanner;

public class    MenuFuncionario {

    public static void menuFuncionario(Funcionario funcionario){
        Acessar.menuFuncionario(funcionario);

        int opFuncionario = 0;
        do {
            System.out.println("\n  =======" + (Cores.LAVENDER +  " FUNCIONÁRIO " + Cores.RESET) + Cores.CREME +  "======");
            System.out.println(" ╔══════════════════════════╗");
            System.out.println(" ║                          ║");
            System.out.println(" ║ [1] REGISTRAR PEDIDOS    ║");
            System.out.println(" ║ [2] ACOMPANHAR PEDIDOS   ║");
            System.out.println(" ║ [3] PAGAMENTO            ║");
            System.out.println(" ║ [0] VOLTAR               ║");
            System.out.println(" ║                          ║");
            System.out.println(" ╚══════════════════════════╝ ");

            System.out.print(
                    "\n" + (Cores.LAVENDER + ">>" + Cores.RESET) + Cores.CREME + " Selecione uma opção: ");

            opFuncionario = InputHelper.lerInt();

            switch (opFuncionario) {
                case 1 -> System.out.println("Registrando pedido......");
                case 2 -> System.out.println("Exibir fila de pedidos.....");
                case 3 -> System.out.println("[1] CARTÃO\n[2] DINHEIRO\n[3]PIX");
                case 0 -> System.out.println("\nVoltando para o menu principal...");
                default -> System.out.print("\n" + (Cores.LAVENDER + ">>" + Cores.RESET) + Cores.CREME + "Opção inválida!");
            }
        } while(opFuncionario != 0);
    }


}