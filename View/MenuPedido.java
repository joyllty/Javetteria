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
            System.out.printf("\n%s>>%s%s Selecione uma opção: %s", LAVENDER, RESET, CREME, RESET);
            op = InputHelper.lerInt();

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
        System.out.printf("Nome do produto: ");
        String nomeProduto = InputHelper.lerString();
        System.out.printf("Quantidade: ");
        int quantidade = InputHelper.lerInt();
        ItemPedido item = new ItemPedido(nomeProduto, quantidade); //Ainda vou fazer a logica do ItemPedido corretamente
        pedidoController.adicionarItem(pedido, item);
        System.out.println(CREME + "Pedido registrado!" + RESET);
    }

    private static void acompanharPedidos(String usuario) {
        List<Pedido> pedidos = pedidoController.listarPedidos();
        Pedido ultimoPedido = null;
        // Busca o último pedido criado pelo usuário
        for (int i = pedidos.size() - 1; i >= 0; i--) {
            if (pedidos.get(i).getUsuario().equals(usuario)) {
                ultimoPedido = pedidos.get(i);
                break;
            }
        }
        if (ultimoPedido != null) {
            System.out.println(LAVENDER + "Seu último pedido:" + RESET);
            System.out.println(ultimoPedido.resumoPedido());
        } else {
            System.out.println(BROWN + "Você ainda não fez nenhum pedido." + RESET);
        }
    }

    private static void removerPedido(String usuario) {
        List<Pedido> pedidos = pedidoController.listarPedidos();
        Pedido ultimoPedido = null;
        for (int i = pedidos.size() - 1; i >= 0; i--) {
            if (pedidos.get(i).getUsuario().equals(usuario)) {
                ultimoPedido = pedidos.get(i);
                break;
            }
        }
        if (ultimoPedido != null) {
            pedidoController.listarPedidos().remove(ultimoPedido);
            System.out.println(CREME + "Pedido removido!" + RESET);
        } else {
            System.out.println(BROWN + "Você ainda não fez nenhum pedido." + RESET);
        }
    }

    private static void pagamentoPedido(String usuario) {
        List<Pedido> pedidos = pedidoController.listarPedidos();
        Pedido ultimoPedido = null;
        for (int i = pedidos.size() - 1; i >= 0; i--) {
            if (pedidos.get(i).getUsuario().equals(usuario)) {
                ultimoPedido = pedidos.get(i);
                break;
            }
        }
        if (ultimoPedido == null) {
            System.out.println(BROWN + "Você ainda não fez nenhum pedido." + RESET);
            return;
        }
        System.out.println(CREME + "Formas de pagamento:" + RESET);
        System.out.println("[1] Cartão\n[2] PIX\n[3] Dinheiro");
        System.out.printf("Escolha: ");
        int op = InputHelper.lerInt();
        Pagamento pagamento = null;
        switch (op) {
            case 1 -> {
                System.out.printf("Número do cartão: ");
                String numeroCartao = InputHelper.lerString();
                pagamento = pagamentoController.criarPagamentoCartao(numeroCartao);
            }
            case 2 -> {
                System.out.printf("Chave PIX: ");
                String chavePix = InputHelper.lerString();
                pagamento = pagamentoController.criarPagamentoPix(chavePix);
            }
            case 3 -> {
                System.out.printf("Valor recebido: ");
                float valorRecebido = InputHelper.lerFloat();
                pagamento = pagamentoController.criarPagamentoDinheiro(valorRecebido);
            }
            default -> System.out.println(BROWN + "Opção inválida." + RESET);
        }
        if (pagamento != null && pagamentoController.processarPagamento(ultimoPedido, pagamento)) {
            System.out.println(LAVENDER + "Pagamento realizado com sucesso!" + RESET);
            if (pagamento instanceof PagamentoPix pix) {
                System.out.println(CREME + "Comprovante PIX: " + pix.getComprovante() + RESET);
            }
            if (pagamento instanceof PagamentoDinheiro dinheiro) {
                float troco = pagamentoController.calcularTroco(dinheiro, ultimoPedido.getValorTotal());
                System.out.println(CREME + "Troco: R$ " + troco + RESET);
            }
        } else {
            System.out.println(BROWN + "Falha no pagamento." + RESET);
        }
    }
}
