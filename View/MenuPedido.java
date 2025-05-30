package View;

import Controller.PedidoController;
import Controller.PagamentoController;
import Model.*;
import Utils.InputHelper;

import java.util.List;

public class MenuPedido {
    public static final String LAVENDER = "\u001B[38;5;183m";
    public static final String CREME = "\u001B[38;5;229m";
    public static final String BROWN = "\u001B[38;5;130m";
    public static final String RESET = "\u001B[0m";

    private static PedidoController pedidoController = new PedidoController();
    private static PagamentoController pagamentoController = new PagamentoController();

    public static void menuPedidos(String usuario) {
        int op;
        do {
            System.out.println(CREME + "  ___________________________ ");
            System.out.println(" |                           |");
            System.out.println(" | [1] Registrar pedido      |");
            System.out.println(" | [2] Acompanhar pedidos    |");
            System.out.println(" | [3] Remover pedido        |");
            System.out.println(" | [4] Pagamento             |");
            System.out.println(" | [5] Voltar                |");
            System.out.println(" |___________________________| ");
            op = InputHelper.lerInt("\n" + LAVENDER + ">>" + RESET + CREME + " Selecione uma opção: " + RESET);

            switch (op) {
                case 1 -> registrarPedido(usuario);
                case 2 -> acompanharPedidos(usuario);
                case 3 -> removerPedido(usuario);
                case 4 -> pagamentoPedido(usuario);
                case 5 -> System.out.println(LAVENDER + "Voltando..." + RESET);
                default -> System.out.println(BROWN + "Opção inválida!" + RESET);
            }
        } while (op != 5);
    }

    private static void registrarPedido(String usuario) {
        Pedido pedido = pedidoController.criarPedido(usuario);
        String nomeProduto = InputHelper.lerString("Nome do produto: ");
        int quantidade = InputHelper.lerInt("Quantidade: ");
        ItemPedido item = new ItemPedido(nomeProduto, quantidade);
        pedidoController.adicionarItem(pedido, item);
        System.out.println(CREME + "Pedido registrado!" + RESET);
    }

    private static void acompanharPedidos(String usuario) {
        List<Pedido> pedidos = pedidoController.listarPedidos();
        System.out.println(LAVENDER + "Seus pedidos:" + RESET);
        for (Pedido p : pedidos) {
            if (p.getUsuario().equals(usuario)) {
                System.out.println(p);
            }
        }
    }

    private static void removerPedido(String usuario) {
        int numero = InputHelper.lerInt("Número do pedido para remover: ");
        Pedido pedido = pedidoController.buscarPedido(numero).orElse(null);
        if (pedido != null && pedido.getUsuario().equals(usuario)) {
            pedidoController.listarPedidos().remove(pedido);
            System.out.println(CREME + "Pedido removido!" + RESET);
        } else {
            System.out.println(BROWN + "Pedido não encontrado ou não pertence a você." + RESET);
        }
    }

    private static void pagamentoPedido(String usuario) {
        int numero = InputHelper.lerInt("Número do pedido para pagar: ");
        Pedido pedido = pedidoController.buscarPedido(numero).orElse(null);
        if (pedido == null || !pedido.getUsuario().equals(usuario)) {
            System.out.println(BROWN + "Pedido não encontrado ou não pertence a você." + RESET);
            return;
        }
        System.out.println(CREME + "Formas de pagamento:" + RESET);
        System.out.println("[1] Cartão\n[2] PIX\n[3] Dinheiro");
        int op = InputHelper.lerInt("Escolha: ");
        Pagamento pagamento = null;
        switch (op) {
            case 1 -> {
                String numeroCartao = InputHelper.lerString("Número do cartão: ");
                pagamento = pagamentoController.criarPagamentoCartao(numeroCartao);
            }
            case 2 -> {
                String chavePix = InputHelper.lerString("Chave PIX: ");
                pagamento = pagamentoController.criarPagamentoPix(chavePix);
            }
            case 3 -> {
                double valorRecebido = InputHelper.lerDouble("Valor recebido: ");
                pagamento = pagamentoController.criarPagamentoDinheiro(valorRecebido);
            }
            default -> System.out.println(BROWN + "Opção inválida." + RESET);
        }
        if (pagamento != null && pagamentoController.processarPagamento(pedido, pagamento)) {
            System.out.println(LAVENDER + "Pagamento realizado com sucesso!" + RESET);
            if (pagamento instanceof PagamentoPix pix) {
                System.out.println(CREME + "Comprovante PIX: " + pix.getComprovante() + RESET);
            }
        } else {
            System.out.println(BROWN + "Falha no pagamento." + RESET);
        }
    }
}
