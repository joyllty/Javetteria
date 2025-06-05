package Controller;

import Model.*;
import java.io.*;
import java.util.List;

public class RelatorioController {
    private static final String ARQUIVO_RELATORIO = "data/relatorios.txt";
    private final PedidoController pedidoController;

    public RelatorioController(PedidoController pedidoController) {
        this.pedidoController = pedidoController;
    }

    // Gera relatório usando lista de pedidos do controller
    public void gerarRelatorioVendas() {
        List<Pedido> pedidos = pedidoController.listarPedidos();
        gerarRelatorioVendas(pedidos);
    }

    // Gera relatório com números sequenciais para pedidos válidos
    public void gerarRelatorioVendas(List<Pedido> pedidos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_RELATORIO))) {
            writer.println("=== RELATÓRIO DE VENDAS ===");
            
            int numeroSequencial = 1;
            for (Pedido pedido : pedidos) {
                // Só inclui pedidos que têm itens e pagamento processado
                if (pedido.getItens().size() > 0 && pedido.getFormaPagamento() != null) {
                    String resumo = pedido.resumoPedido();
                    // Substitui o número do pedido pelo número sequencial
                    resumo = resumo.replaceFirst("Pedido #\\d+", "Pedido #" + numeroSequencial);
                    writer.println(resumo);
                    numeroSequencial++;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao gerar relatório: " + e.getMessage());
        }
    }
} 