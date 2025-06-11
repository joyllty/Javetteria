package view;

import model.Cliente;
import model.Menu;
import utils.Cores;
import utils.InputHelper;

public class MenuCliente{

    // função principal do menu cliente - sobrescrita


    // view menu cliente
    public static void menuCliente(Cliente cliente){
        int opCliente = 0;
        do {
            System.out.println("\n ╔═════════════════════════╗");
            System.out.println(" ║                         ║");
            System.out.println(" ║ [1] ABRIR CARDÁPIO      ║");
            System.out.println(" ║ [2] FAZER PEDIDO        ║");
            System.out.println(" ║ [3] VER MEUS DADOS      ║");
            System.out.println(" ║ [4] ALTERAR ENDEREÇO    ║");
            System.out.println(" ║ [0] VOLTAR              ║");
            System.out.println(" ║                         ║");
            System.out.println(" ╚═════════════════════════╝");

            System.out.print("\n" + (Cores.LAVENDER + ">>" + Cores.RESET) + Cores.CREME + " Selecione uma opção: ");
            opCliente = InputHelper.lerInt();

            switch (opCliente) {
                case 1 -> System.out.println("CARDÁPIO");
                case 2 -> System.out.println("CHAMANDO ATENDENTE");
                case 3 -> Acessar.verDadosCliente(cliente);
                case 4 -> Acessar.alterarEnderecoCliente(cliente);
                case 0 -> System.out.println("\nVoltando...");
                default ->
                        System.out.print("\n" + (Cores.LAVENDER + ">>" + Cores.RESET) + Cores.CREME + "Opção inválida!");
            }
        } while(opCliente != 0);
    }
}