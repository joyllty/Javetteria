package view;

import model.Cliente;
import view.CardapioView;
import controller.MenuPedidoController;
import controller.PedidoController;
import controller.PagamentoController;

import utils.Cores;
import utils.InputHelper;

public class MenuCliente {
    private static final MenuPedidoController menuPedidoController;

    static {
        PedidoController pedidoController = new PedidoController();
        PagamentoController pagamentoController = new PagamentoController();
        menuPedidoController = new MenuPedidoController(pedidoController, pagamentoController);
    }

    public static void menuCliente(Cliente cliente){
        int opCliente = 0;
        do {
            System.out.println(Cores.CREME + "\n ╔════════════════════════╗");
            System.out.println(" ║                        ║");
            System.out.println(" ║ [1] ABRIR CARDÁPIO     ║");
            System.out.println(" ║ [2] FAZER PEDIDO       ║");
            System.out.println(" ║ [3] VER MEUS DADOS     ║");
            System.out.println(" ║ [4] ALTERAR ENDEREÇO   ║");
            System.out.println(" ║ [0] VOLTAR             ║");
            System.out.println(" ║                        ║");
            System.out.println(" ╚════════════════════════╝" + Cores.RESET);

            System.out.print(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + " Selecione uma opção: " + Cores.RESET);
            opCliente = InputHelper.lerInt();

            switch (opCliente) {
                case 1 -> CardapioView.exibirCardapioCompleto();
                case 2 -> menuPedidoController.iniciar(cliente.getLogin());
                case 3 -> Acessar.verDadosCliente(cliente);
                case 4 -> Acessar.alterarEnderecoCliente(cliente);
                case 0 -> System.out.println(Cores.CREME + "\nVoltando para o menu principal..." + Cores.RESET);
                default ->
                        System.out.print(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + "Opção inválida!" + Cores.RESET);
            }
        } while(opCliente != 0);
    }
}