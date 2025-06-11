package view;

import model.Cliente;
import model.Gerente;
import model.Menu;
import utils.Cores;
import utils.InputHelper;

public class MenuGerente{

    // view menu gerente
    public static void menuGerente(Gerente gerente){
        int opGerente = 0;
        do {
            System.out.println("\n ╔══════════════════════════╗");
            System.out.println(" ║                          ║");
            System.out.println(" ║ [1] PEDIDOS              ║");
            System.out.println(" ║ [2] ESTOQUE              ║");
            System.out.println(" ║ [3] GERENCIAMENTO        ║");
            System.out.println(" ║ [0] VOLTAR               ║");
            System.out.println(" ║                          ║");
            System.out.println(" ╚══════════════════════════╝ ");

            System.out.print("\n" + (Cores.LAVENDER + ">>" + Cores.RESET) + Cores.CREME + " Selecione uma opção: ");
            opGerente = InputHelper.lerInt();

            switch (opGerente) {
                case 1 -> menuGerentePedidos();
                case 2 -> new view.EstoqueView().executar();
                case 3 -> menuGerenteGerenciamento();
                case 0 -> System.out.println("\nVoltando para o menu principal...");
                default ->
                        System.out.print("\n" + (Cores.LAVENDER + ">>" + Cores.RESET) + Cores.CREME + "Opção inválida!");
            }
        } while(opGerente != 0);
    }

    // view menu gerência - pedidos
    public static void menuGerentePedidos() {
        int opPedidosG;
        do {
            System.out.println("\n ╔══════════════════════════╗");
            System.out.println(" ║                          ║");
            System.out.println(" ║ [1] REGISTRAR PEDIDOS    ║");
            System.out.println(" ║ [2] ACOMPANHAR PEDIDOS   ║");
            System.out.println(" ║ [3] REMOVER PEDIDOS      ║");
            System.out.println(" ║ [4] PAGAMENTO            ║");
            System.out.println(" ║ [0] VOLTAR               ║");
            System.out.println(" ║                          ║");
            System.out.println(" ╚══════════════════════════╝ ");

            System.out.print("\n" + (Cores.LAVENDER + ">>" + Cores.RESET) + Cores.CREME + " Selecione uma opção: ");
            opPedidosG = InputHelper.lerInt();

            switch (opPedidosG) {
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
                case 0:
                    System.out.println("\nVoltando...");
                    break;
                default:
                    System.out.print("\n" + (Cores.LAVENDER + ">>" + Cores.RESET) + Cores.CREME + " Opção inválida!");
            }

        } while (opPedidosG != 0);
    }

    // view menu gerência - gerenciamento
    public static void menuGerenteGerenciamento () {
        int opGerencia;
        do {
            System.out.println("\n ╔═════════════════════════════════╗");
            System.out.println(" ║                                ║");
            System.out.println(" ║ [1] EXIBIR FUNCIONÁRIOS        ║");
            System.out.println(" ║ [2] EXIBIR CLIENTES            ║");
            System.out.println(" ║ [3] CADASTRAR FUNCIONÁRIO      ║");
            System.out.println(" ║ [4] REMOVER FUNCIONÁRIO        ║");
            System.out.println(" ║ [5] ALTERAR SENHA DO USUÁRIO   ║");
            System.out.println(" ║ [6] HISTÓRICO DE VENDAS        ║");
            System.out.println(" ║ [0] VOLTAR                     ║");
            System.out.println(" ║                                ║");
            System.out.println(" ╚════════════════════════════════╝ ");

            System.out.print("\n" + (Cores.LAVENDER + ">>" + Cores.RESET) + Cores.CREME + " Selecione uma opção: ");
            opGerencia = InputHelper.lerInt();

            switch (opGerencia) {
                case 1 -> Acessar.listarFuncionariosGerente();
                case 2 -> Acessar.listarClientesGerente();
                case 3 -> Acessar.cadastrarNovoFuncionarioGerente();
                case 4 -> Acessar.removerFuncionarioGerente();
                case 5 -> Acessar.alterarSenhaUsuarioGerente();
                // ESPERANDO ARTHUR case 6 -> Acessar.
                case 0 -> System.out.println("\nVoltando...");
            }
        } while (opGerencia != 0);
    }

}