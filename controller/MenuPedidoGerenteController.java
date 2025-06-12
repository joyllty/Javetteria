package controller;

import model.Pedido;
import model.ItemPedido;
import utils.Cores;
import utils.InputHelper;
import view.MenuPedido;
import java.util.List;

public class MenuPedidoGerenteController {
    private final PedidoController pedidoController;
    private final PagamentoController pagamentoController;
    private final MenuPedido view;

    public MenuPedidoGerenteController(PedidoController pedidoController, PagamentoController pagamentoController) {
        this.pedidoController = pedidoController;
        this.pagamentoController = pagamentoController;
        this.view = new MenuPedido();
    }

    public void registrarPedido(String usuario) {
        Pedido pedido = pedidoController.criarPedido(usuario);
        boolean continuar = true;
        while (continuar) {
            boolean produtoValido = false;
            while (!produtoValido) {
                view.exibirPrompt("\nNome do produto: ");
                String nomeProduto = InputHelper.lerString();
                view.exibirPrompt("Quantidade: ");
                int quantidade = InputHelper.lerInt();
                try {
                    ItemPedido item = pedidoController.criarItemPedido(nomeProduto, quantidade);
                    pedidoController.adicionarItem(pedido, item);
                    view.exibirMensagem("Item adicionado ao pedido!", Cores.CREME);
                    produtoValido = true;
                } catch (IllegalArgumentException e) {
                    view.exibirMensagem("\nProduto não encontrado: " + nomeProduto, Cores.BROWN);
                }
            }
            view.exibirPrompt("\nDeseja adicionar mais um item? (1 - Sim / 2 - Não): ");
            int opcao = InputHelper.lerInt();
            continuar = opcao == 1;
        }
        view.exibirMensagem("\nPedido registrado com sucesso!", Cores.CREME);
    }

    public void listarPedidosPendentes() {
        List<Pedido> pendentes = pedidoController.listarPedidosPendentesGlobal();
        if (pendentes.isEmpty()) {
            view.exibirMensagem("Não há pedidos pendentes.", Cores.BROWN);
            return;
        }
        view.exibirMensagem("\nPedidos pendentes:", Cores.LAVENDER);
        view.exibirListaPedidos(pendentes);
    }

    public void removerPedido() {
        List<Pedido> pendentes = pedidoController.listarPedidosPendentesGlobal();
        if (pendentes.isEmpty()) {
            view.exibirMensagem("Não há pedidos pendentes para remover.", Cores.BROWN);
            return;
        }
        view.exibirListaPedidos(pendentes);
        view.exibirPrompt("\n>> Digite o número do pedido que deseja remover: ");
        int numero = InputHelper.lerInt();
        if (pedidoController.removerPedido(numero)) {
            view.exibirMensagem("Pedido removido com sucesso!", Cores.CREME);
            pedidoController.salvarPedidos();
        } else {
            view.exibirMensagem("Número de pedido inválido ou já pago.", Cores.BROWN);
        }
    }

    public void pagamentoPedido() {
        List<Pedido> pendentes = pedidoController.listarPedidosPendentesGlobal();
        if (pendentes.isEmpty()) {
            view.exibirMensagem("Não há pedidos pendentes para pagamento.", Cores.BROWN);
            return;
        }
        view.exibirListaPedidos(pendentes);
        view.exibirPrompt("\n>> Digite o número do pedido que deseja pagar: ");
        int numero = InputHelper.lerInt();
        Pedido pedido = pedidoController.buscarPedido(numero);
        if (pedido == null || pedido.isPago()) {
            view.exibirMensagem("Número de pedido inválido!", Cores.BROWN);
            return;
        }
        view.exibirFormasPagamento();
        int forma = InputHelper.lerInt();
        String dados = "";
        switch (forma) {
            case 1 -> {
                view.exibirPrompt("Número do cartão: ");
                dados = InputHelper.lerString();
            }
            case 2 -> {
                view.exibirPrompt("Chave PIX: ");
                dados = InputHelper.lerString();
            }
            case 3 -> {
                view.exibirPrompt("Valor recebido: ");
                dados = String.valueOf(InputHelper.lerFloat());
            }
            default -> {
                view.exibirMensagem("Opção inválida!", Cores.BROWN);
                return;
            }
        }
        if (pagamentoController.processarPagamentoCompleto(pedido, forma, dados)) {
            view.exibirMensagem("Pagamento realizado com sucesso!", Cores.LAVENDER);
            String infoPagamento = pagamentoController.obterInformacoesPagamento(pedido.getFormaPagamento(), (float) pedido.getValorTotal());
            view.exibirInformacoesPagamento(infoPagamento);
            pedidoController.salvarPedidos();
        } else {
            view.exibirMensagem("Falha no pagamento.", Cores.BROWN);
        }
    }

    public void listarTodosPedidos() {
        List<Pedido> todos = pedidoController.listarPedidos();
        if (todos.isEmpty()) {
            view.exibirMensagem("Nenhum pedido registrado.", Cores.BROWN);
            return;
        }
        view.exibirMensagem("\nHistórico completo de pedidos:", Cores.LAVENDER);
        view.exibirListaPedidos(todos);
    }
} 