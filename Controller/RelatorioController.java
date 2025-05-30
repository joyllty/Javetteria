package Controller;

import Model.*;
import java.io.*;
import java.util.List;

public class RelatorioController {
    private static final String ARQUIVO_RELATORIOS = "Data/relatorios.txt";
    private final PedidoController pedidoController;

    public RelatorioController(PedidoController pedidoController) {
        this.pedidoController = pedidoController;
    }

    public void gerarRelatorioVendas() {
        List<Pedido> pedidos = pedidoController.listarPedidos();
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_RELATORIOS, true))) {
            writer.println("=== RELATÓRIO DE VENDAS ===");
            for (Pedido pedido : pedidos) {
                writer.println(pedido.toString());
            }
            writer.println();
        } catch (IOException e) {
            System.err.println("Erro ao gerar relatório: " + e.getMessage());
        }
    }
} 