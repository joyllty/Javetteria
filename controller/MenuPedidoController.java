package controller;

import model.Pedido;
import model.ItemPedido;
import view.MenuPedido;
import utils.InputHelper;
import utils.Cores;
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
                case 0-> view.exibirMensagem("\nVoltando...", Cores.LAVENDER);
                default -> view.exibirMensagem("\nOpção inválida!", Cores.BROWN);
            }
        } while (op != 0);
    }

    public void registrarPedido(String usuario) {
        Pedido pedido = pedidoController.criarPedido(usuario);
        boolean continuar = true;
        
        while (continuar) {
            boolean produtoValido = false;
            String nomeProduto = "";
            int quantidade = 0;
            
            while (!produtoValido) {
                view.exibirPrompt("\n=========" + (Cores.LAVENDER +  " REGISTRAR PEDIDO " + Cores.RESET) + Cores.CREME
                        +  "=========\n");
                view.exibirPrompt(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + " Nome do produto: ");
                nomeProduto = InputHelper.lerString();
                try {
                    view.exibirPrompt(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + " Quantidade: ");
                    quantidade = InputHelper.lerInt();
                    
                    ItemPedido item = pedidoController.criarItemPedido(nomeProduto, quantidade);
                    pedidoController.adicionarItem(pedido, item);
                    view.exibirMensagem("\nItem adicionado ao pedido!", Cores.CREME);
                    produtoValido = true;
                } catch (IllegalArgumentException e) {
                    view.exibirMensagem("\nProduto não encontrado: " + nomeProduto, Cores.BROWN);
                    view.exibirMensagem("Por favor, verifique o nome do produto e tente novamente.", Cores.BROWN);
                }
            }
            
            view.exibirPrompt("\n\nDeseja adicionar mais um item? \n(1 - Sim / 2 - Não): ");
            int opcao = InputHelper.lerInt();
            continuar = (opcao == 1);
        }
        
        view.exibirMensagem("\nPedido registrado com sucesso!", Cores.CREME);
        view.exibirPrompt("====================================\n");
    }

    private void acompanharPedidos(String usuario) {
        List<Pedido> pedidos = pedidoController.listarPedidosUsuario(usuario);
        view.exibirMensagem("\nSeus pedidos:", Cores.LAVENDER);
        
        if (pedidos.isEmpty()) {
            view.exibirMensagem("Você ainda não fez nenhum pedido.", Cores.BROWN);
            return;
        }
        
        view.exibirListaPedidos(pedidos);
    }

    private void removerPedido(String usuario) {
        List<Pedido> pedidosPendentes = pedidoController.listarPedidosPendentes(usuario);
        
        if (pedidosPendentes.isEmpty()) {
            view.exibirMensagem("\nVocê não tem pedidos pendentes para remover.", Cores.BROWN);
            return;
        }
        
        view.exibirMensagem("\nSeus pedidos pendentes:", Cores.LAVENDER);
        view.exibirListaPedidos(pedidosPendentes);
        
        view.exibirPrompt(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + " Digite o número do pedido que deseja " +
                "remover (ex: 28): ");
        int numeroPedido = InputHelper.lerInt();
        
        if (pedidoController.removerPedido(numeroPedido)) {
            view.exibirMensagem("\nPedido removido com sucesso!", Cores.CREME);
        } else {
            view.exibirMensagem("\nNúmero de pedido inválido!", Cores.BROWN);
        }
    }

    private void pagamentoPedido(String usuario) {
        List<Pedido> pedidosPendentes = pedidoController.listarPedidosPendentes(usuario);
        
        if (pedidosPendentes.isEmpty()) {
            view.exibirMensagem("\nVocê não tem pedidos pendentes para pagar.", Cores.BROWN);
            return;
        }
        
        view.exibirMensagem("\nSeus pedidos pendentes:", Cores.LAVENDER);
        view.exibirListaPedidos(pedidosPendentes);
        
        view.exibirPrompt(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + " Digite o número do pedido que deseja " +
                "pagar (ex: 28): ");
        int numeroPedido = InputHelper.lerInt();
        
        Pedido pedidoPagar = pedidoController.buscarPedido(numeroPedido);
        if (pedidoPagar == null || !pedidoPagar.getUsuario().equals(usuario) || pedidoPagar.isPago()) {
            view.exibirMensagem("\nNúmero de pedido inválido!", Cores.BROWN);
            return;
        }
        
        view.exibirFormasPagamento();
        int formaPagamento = InputHelper.lerInt();
        
        String dadosPagamento = "";
        switch (formaPagamento) {
            case 1 -> {
                view.exibirPrompt(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + " Número do cartão: ");
                dadosPagamento = InputHelper.lerString();
            }
            case 2 -> {
                view.exibirPrompt(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + " Chave PIX: ");
                dadosPagamento = InputHelper.lerString();
            }
            case 3 -> {
                view.exibirPrompt(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + " Valor recebido: ");
                dadosPagamento = String.valueOf(InputHelper.lerFloat());
            }
            default -> {
                view.exibirMensagem("\nOpção inválida!", Cores.BROWN);
                return;
            }
        }
        
        if (pagamentoController.processarPagamentoCompleto(pedidoPagar, formaPagamento, dadosPagamento)) {
            view.exibirMensagem("\nPagamento realizado com sucesso!", Cores.LAVENDER);
            String infoPagamento = pagamentoController.obterInformacoesPagamento(
                pedidoPagar.getFormaPagamento(), 
                (float)pedidoPagar.getValorTotal()
            );
            view.exibirInformacoesPagamento(infoPagamento);
            pedidoController.salvarPedidos();
        } else {
            view.exibirMensagem("\nFalha no pagamento.", Cores.BROWN);
        }
    }


    public void listarPedidosPendentesGlobal() {
        List<Pedido> pendentes = pedidoController.listarPedidosPendentesGlobal();
        if (pendentes.isEmpty()) {
            view.exibirMensagem("\nNão há pedidos pendentes.", Cores.BROWN);
            return;
        }
        view.exibirMensagem("\nPedidos pendentes:", Cores.LAVENDER);
        view.exibirListaPedidos(pendentes);
    }

    public void removerPedidoGlobal() {
        List<Pedido> pendentes = pedidoController.listarPedidosPendentesGlobal();
        if (pendentes.isEmpty()) {
            view.exibirMensagem("\nNão há pedidos pendentes para remover.", Cores.BROWN);
            return;
        }
        view.exibirListaPedidos(pendentes);
        view.exibirPrompt(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + " Digite o número do pedido que deseja " +
                "remover: ");
        int numero = InputHelper.lerInt();
        if (pedidoController.removerPedido(numero)) {
            view.exibirMensagem("\nPedido removido com sucesso!", Cores.CREME);
            pedidoController.salvarPedidos();
        } else {
            view.exibirMensagem("\nNúmero de pedido inválido ou já pago.", Cores.BROWN);
        }
    }

    public void pagamentoPedidoGlobal() {
        List<Pedido> pendentes = pedidoController.listarPedidosPendentesGlobal();
        if (pendentes.isEmpty()) {
            view.exibirMensagem("\nNão há pedidos pendentes para pagamento.", Cores.BROWN);
            return;
        }
        view.exibirListaPedidos(pendentes);
        view.exibirPrompt(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + " Digite o número do pedido que deseja " +
                "pagar: ");
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
                view.exibirPrompt(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + " Número do cartão: ");
                dados = InputHelper.lerString();
            }
            case 2 -> {
                view.exibirPrompt(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + " Chave PIX: ");
                dados = InputHelper.lerString();
            }
            case 3 -> {
                view.exibirPrompt(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + " Valor recebido: ");
                dados = String.valueOf(InputHelper.lerFloat());
            }
            default -> {
                view.exibirMensagem("\nOpção inválida!", Cores.BROWN);
                return;
            }
        }
        if (pagamentoController.processarPagamentoCompleto(pedido, forma, dados)) {
            view.exibirMensagem("\nPagamento realizado com sucesso!", Cores.LAVENDER);
            String infoPagamento = pagamentoController.obterInformacoesPagamento(pedido.getFormaPagamento(), (float) pedido.getValorTotal());
            view.exibirInformacoesPagamento(infoPagamento);
            pedidoController.salvarPedidos();
        } else {
            view.exibirMensagem("\nFalha no pagamento.", Cores.BROWN);
        }
    }

    public void listarTodosPedidos() {
        List<Pedido> todos = pedidoController.listarPedidos();
        if (todos.isEmpty()) {
            view.exibirMensagem("\nNenhum pedido registrado.", Cores.BROWN);
            return;
        }
        view.exibirMensagem("\nHistórico completo de pedidos:", Cores.LAVENDER);
        view.exibirListaPedidos(todos);
    }
} 