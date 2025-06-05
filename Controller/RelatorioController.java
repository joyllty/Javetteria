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

    public void gerarRelatorioVendas() {
        List<Pedido> pedidos = pedidoController.listarPedidos();
        gerarRelatorioVendas(pedidos);
    }

    public void gerarRelatorioVendas(List<Pedido> pedidos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_RELATORIO))) {
            writer.println("=== RELATÓRIO DE VENDAS ===");
            
            for (Pedido pedido : pedidos) {
                // Só inclui pedidos que têm itens e pagamento processado
                if (pedido.getItens().size() > 0 && pedido.getFormaPagamento() != null) {
                    writer.println(pedido.resumoPedido());
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao gerar relatório: " + e.getMessage());
        }
    }
} 