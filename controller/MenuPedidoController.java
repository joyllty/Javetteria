package controller;

import model.Pedido;
import model.ItemPedido;
import view.MenuPedido;
import utils.InputHelper;
import java.util.List;

public class MenuPedidoController {
    private final PedidoController pedidoController;
    private final PagamentoController pagamentoController;
    private final MenuPedido view;

    public MenuPedidoController(PedidoController pedidoController, PagamentoController pagamentoController) {
        this.pedidoController = pedidoController;
        this.pagamentoController = pagamentoController;
        this.view = new MenuPedido();
    }

    public void iniciar(String usuario) {
        int op;
        do {
            view.exibirMenu();
            op = InputHelper.lerInt();

            switch (op) {
                case 1 -> registrarPedido(usuario);
                case 2 -> acompanharPedidos(usuario);
                case 3 -> removerPedido(usuario);
                case 4 -> pagamentoPedido(usuario);
                case 5 -> view.exibirMensagem("\nVoltando...", MenuPedido.LAVENDER);
                default -> view.exibirMensagem("\nOpção inválida!", MenuPedido.BROWN);
            }
        } while (op != 5);
    }

    private void registrarPedido(String usuario) {
        Pedido pedido = pedidoController.criarPedido(usuario);
        boolean continuar = true;
        
        while (continuar) {
            boolean produtoValido = false;
            String nomeProduto = "";
            int quantidade = 0;
            
            while (!produtoValido) {
                view.exibirPrompt("\nNome do produto: ");
                nomeProduto = InputHelper.lerString();
                try {
                    view.exibirPrompt("Quantidade: ");
                    quantidade = InputHelper.lerInt();
                    
                    ItemPedido item = pedidoController.criarItemPedido(nomeProduto, quantidade);
                    pedidoController.adicionarItem(pedido, item);
                    view.exibirMensagem("Item adicionado ao pedido!", MenuPedido.CREME);
                    produtoValido = true;
                } catch (IllegalArgumentException e) {
                    view.exibirMensagem("\nProduto não encontrado: " + nomeProduto, MenuPedido.BROWN);
                    view.exibirMensagem("Por favor, verifique o nome do produto e tente novamente.", MenuPedido.BROWN);
                }
            }
            
            view.exibirPrompt("\nDeseja adicionar mais um item? (1 - Sim / 2 - Não): ");
            int opcao = InputHelper.lerInt();
            continuar = (opcao == 1);
        }
        
        view.exibirMensagem("\nPedido registrado com sucesso!", MenuPedido.CREME);
    }

    private void acompanharPedidos(String usuario) {
        List<Pedido> pedidos = pedidoController.listarPedidosUsuario(usuario);
        view.exibirMensagem("\nSeus pedidos:", MenuPedido.LAVENDER);
        
        if (pedidos.isEmpty()) {
            view.exibirMensagem("Você ainda não fez nenhum pedido.", MenuPedido.BROWN);
            return;
        }
        
        view.exibirListaPedidos(pedidos);
    }

    private void removerPedido(String usuario) {
        List<Pedido> pedidosPendentes = pedidoController.listarPedidosPendentes(usuario);
        
        if (pedidosPendentes.isEmpty()) {
            view.exibirMensagem("Você não tem pedidos pendentes para remover.", MenuPedido.BROWN);
            return;
        }
        
        view.exibirMensagem("\nSeus pedidos pendentes:", MenuPedido.LAVENDER);
        view.exibirListaPedidos(pedidosPendentes);
        
        view.exibirPrompt("\n>> Digite o número do pedido que deseja remover (ex: 28): ");
        int numeroPedido = InputHelper.lerInt();
        
        if (pedidoController.removerPedido(numeroPedido)) {
            view.exibirMensagem("Pedido removido com sucesso!", MenuPedido.CREME);
        } else {
            view.exibirMensagem("Número de pedido inválido!", MenuPedido.BROWN);
        }
    }

    private void pagamentoPedido(String usuario) {
        List<Pedido> pedidosPendentes = pedidoController.listarPedidosPendentes(usuario);
        
        if (pedidosPendentes.isEmpty()) {
            view.exibirMensagem("Você não tem pedidos pendentes para pagar.", MenuPedido.BROWN);
            return;
        }
        
        view.exibirMensagem("\nSeus pedidos pendentes:", MenuPedido.LAVENDER);
        view.exibirListaPedidos(pedidosPendentes);
        
        view.exibirPrompt("\n>> Digite o número do pedido que deseja pagar (ex: 28): ");
        int numeroPedido = InputHelper.lerInt();
        
        Pedido pedidoPagar = pedidoController.buscarPedido(numeroPedido);
        if (pedidoPagar == null || !pedidoPagar.getUsuario().equals(usuario) || pedidoPagar.isPago()) {
            view.exibirMensagem("Número de pedido inválido!", MenuPedido.BROWN);
            return;
        }
        
        view.exibirFormasPagamento();
        int formaPagamento = InputHelper.lerInt();
        
        String dadosPagamento = "";
        switch (formaPagamento) {
            case 1 -> {
                view.exibirPrompt("Número do cartão: ");
                dadosPagamento = InputHelper.lerString();
            }
            case 2 -> {
                view.exibirPrompt("Chave PIX: ");
                dadosPagamento = InputHelper.lerString();
            }
            case 3 -> {
                view.exibirPrompt("Valor recebido: ");
                dadosPagamento = String.valueOf(InputHelper.lerFloat());
            }
            default -> {
                view.exibirMensagem("Opção inválida!", MenuPedido.BROWN);
                return;
            }
        }
        
        if (pagamentoController.processarPagamentoCompleto(pedidoPagar, formaPagamento, dadosPagamento)) {
            view.exibirMensagem("Pagamento realizado com sucesso!", MenuPedido.LAVENDER);
            String infoPagamento = pagamentoController.obterInformacoesPagamento(
                pedidoPagar.getFormaPagamento(), 
                (float)pedidoPagar.getValorTotal()
            );
            view.exibirInformacoesPagamento(infoPagamento);
            pedidoController.salvarPedidos();
        } else {
            view.exibirMensagem("Falha no pagamento.", MenuPedido.BROWN);
        }
    }

    public void exibirPedidos(String usuario) {
        List<Pedido> pedidos = pedidoController.listarPedidosUsuario(usuario);
        if (pedidos.isEmpty()) {
            view.exibirMensagem("Você ainda não fez nenhum pedido.", MenuPedido.BROWN);
            return;
        }
        view.exibirListaPedidos(pedidos);
    }

    public void solicitarDadosPedido() {
        view.exibirPrompt("Nome do produto: ");
        String nomeProduto = InputHelper.lerString();
        view.exibirPrompt("Quantidade: ");
        int quantidade = InputHelper.lerInt();
        // Process data...
    }
} 