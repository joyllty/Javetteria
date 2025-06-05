// CLASSE DE TESTES
package Controller;

import Model.*;
import java.io.File;
import java.util.List;

public class TestController {
    private final PedidoController pedidoController;
    private final PagamentoController pagamentoController;
    private final RelatorioController relatorioController;

    public TestController() {
        this.pedidoController = new PedidoController();
        this.pagamentoController = new PagamentoController();
        this.relatorioController = new RelatorioController(pedidoController);
    }

    public void testarCriarPedido() {
        System.out.println("\n=== Testando Criação de Pedido ===");
        Pedido pedido = pedidoController.criarPedido("teste_usuario");
        System.out.println("Pedido criado: " + pedido.resumoPedido());
        
        // Teste de busca do pedido criado
        Pedido pedidoEncontrado = pedidoController.buscarPedido(pedido.getNumeroPedido());
        System.out.println("Pedido encontrado: " + (pedidoEncontrado != null ? "Sucesso" : "Falha"));
    }

    public void testarOperacoesPedido() {
        System.out.println("\n=== Testando Operações de Pedido ===");
        Pedido pedido = pedidoController.criarPedido("usuario_teste_operacoes");
        
        // Teste de adicionar item
        Cafe cafe = new Cafe("Café Expresso", 5.0f, "Café expresso tradicional");
        ItemPedido item1 = new ItemPedido(cafe, 2);
        pedidoController.adicionarItem(pedido, item1);
        System.out.println("Item adicionado: " + pedido.resumoPedido());
        
        // Teste de remover item
        pedidoController.removerItem(pedido, item1);
        System.out.println("Item removido: " + pedido.resumoPedido());
    }

    public void testarListarPedidos() {
        System.out.println("\n=== Testando Listagem de Pedidos ===");
        System.out.println("Pedidos carregados do arquivo:");
        List<Pedido> pedidos = pedidoController.listarPedidos();
        for (Pedido pedido : pedidos) {
            System.out.println(pedido.resumoPedido());
        }
        System.out.println("Total de pedidos: " + pedidos.size());
    }

    public void testarPagamento() {
        System.out.println("\n=== Testando Pagamento ===");
        
        // Teste de pagamento com cartão
        Pedido pedidoCartao = pedidoController.criarPedido("usuario_teste_cartao");
        Cafe cafeCartao = new Cafe("Café Expresso", 5.0f, "Café expresso tradicional");
        ItemPedido itemCartao = new ItemPedido(cafeCartao, 1);
        pedidoController.adicionarItem(pedidoCartao, itemCartao);
        
        Pagamento pagamentoCartao = pagamentoController.criarPagamentoCartao("1234567890123456");
        boolean sucessoCartao = pedidoController.processarPagamento(pedidoCartao, pagamentoCartao);
        System.out.println("Pagamento com cartão: " + (sucessoCartao ? "Sucesso" : "Falha"));

        // Teste de pagamento com PIX
        Pedido pedidoPix = pedidoController.criarPedido("usuario_teste_pix");
        Cafe cafePix = new Cafe("Café Expresso", 5.0f, "Café expresso tradicional");
        ItemPedido itemPix = new ItemPedido(cafePix, 1);
        pedidoController.adicionarItem(pedidoPix, itemPix);
        
        Pagamento pagamentoPix = pagamentoController.criarPagamentoPix("chave.pix@teste.com");
        boolean sucessoPix = pedidoController.processarPagamento(pedidoPix, pagamentoPix);
        System.out.println("Pagamento com PIX: " + (sucessoPix ? "Sucesso" : "Falha"));
        
        // Teste de pagamento em dinheiro
        Pedido pedidoDinheiro = pedidoController.criarPedido("usuario_teste_dinheiro");
        Cafe cafeDinheiro = new Cafe("Café Expresso", 5.0f, "Café expresso tradicional");
        ItemPedido itemDinheiro = new ItemPedido(cafeDinheiro, 1);
        pedidoController.adicionarItem(pedidoDinheiro, itemDinheiro);
        
        // Teste com valor suficiente
        Pagamento pagamentoDinheiro = pagamentoController.criarPagamentoDinheiro(10.0f);
        boolean sucessoDinheiro = pedidoController.processarPagamento(pedidoDinheiro, pagamentoDinheiro);
        System.out.println("Pagamento em dinheiro (valor suficiente): " + (sucessoDinheiro ? "Sucesso" : "Falha"));
        if (sucessoDinheiro) {
            System.out.println("Troco: R$ " + ((PagamentoDinheiro)pagamentoDinheiro).getTroco());
        }
        
        // Teste com valor insuficiente
        Pedido pedidoDinheiroInsuficiente = pedidoController.criarPedido("usuario_teste_dinheiro_insuficiente");
        pedidoController.adicionarItem(pedidoDinheiroInsuficiente, itemDinheiro);
        Pagamento pagamentoDinheiroInsuficiente = pagamentoController.criarPagamentoDinheiro(3.0f);
        boolean sucessoDinheiroInsuficiente = pedidoController.processarPagamento(pedidoDinheiroInsuficiente, pagamentoDinheiroInsuficiente);
        System.out.println("Pagamento em dinheiro (valor insuficiente): " + (sucessoDinheiroInsuficiente ? "Sucesso" : "Falha"));
        
        // Teste de pagamento inválido
        try {
            Pedido pedidoInvalido = pedidoController.criarPedido("usuario_teste_invalido");
            boolean sucessoInvalido = pedidoController.processarPagamento(pedidoInvalido, null);
            System.out.println("Pagamento inválido: " + (sucessoInvalido ? "Sucesso" : "Falha"));
        } catch (NullPointerException e) {
            System.out.println("Pagamento inválido: Falha (NullPointerException esperada)");
        }
    }

    public void testarRelatorio() {
        System.out.println("\n=== Testando Geração de Relatório ===");
        relatorioController.gerarRelatorioVendas();
        
        // Verificar se o arquivo de relatório foi criado
        File arquivoRelatorio = new File("Data/relatorios.txt");
        System.out.println("Arquivo de relatório criado: " + arquivoRelatorio.exists());
    }

    public void testarBuscaPedido() {
        System.out.println("\n=== Testando Busca de Pedido ===");
        
        // Teste de busca de pedido existente
        Pedido pedido = pedidoController.criarPedido("usuario_teste_busca");
        Pedido pedidoEncontrado = pedidoController.buscarPedido(pedido.getNumeroPedido());
        System.out.println("Busca de pedido existente: " + (pedidoEncontrado != null ? "Sucesso" : "Falha"));
        
        // Teste de busca de pedido inexistente
        Pedido pedidoInexistente = pedidoController.buscarPedido(999999);
        System.out.println("Busca de pedido inexistente: " + (pedidoInexistente == null ? "Sucesso" : "Falha"));
    }

    public void executarTodosTestes() {
        testarCriarPedido();
        testarOperacoesPedido();
        testarListarPedidos();
        testarPagamento();
        testarRelatorio();
        testarBuscaPedido();
    }
} 