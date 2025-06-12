package view;

import model.Funcionario;
import model.Gerente;
import model.Menu;
import utils.Cores;
import utils.InputHelper;
import controller.MenuPedidoGerenteController;
import controller.PedidoController;
import controller.PagamentoController;

public class MenuFuncionario {

    private static final MenuPedidoGerenteController menuPedidoGerenteController;
    private static Funcionario funcionarioAtual;

    static {
        PedidoController pedidoController = new PedidoController();
        PagamentoController pagamentoController = new PagamentoController();
        menuPedidoGerenteController = new MenuPedidoGerenteController(pedidoController, pagamentoController);
    }

    public static void menuFuncionario(Funcionario funcionario){
        funcionarioAtual = funcionario;
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

            System.out.print(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + " Selecione uma opção: ");

            opFuncionario = InputHelper.lerInt();

            switch (opFuncionario) {
                case 1 -> menuPedidoGerenteController.registrarPedido(funcionarioAtual.getLogin());
                case 2 -> menuPedidoGerenteController.listarPedidosPendentes();
                case 3 -> menuPedidoGerenteController.pagamentoPedido();
                case 0 -> System.out.println("\nVoltando para o menu principal...");
                default -> System.out.print(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + "Opção inválida!");
            }
        } while(opFuncionario != 0);
    }
}