package Model;

import java.util.List;

public class Relatorio {
    public static String gerarRelatorioPedidos(List<Pedido> pedidos) {
        String relatorio = "=== RELATÓRIO DE VENDAS ===\n";
        for (Pedido pedido : pedidos) {
            relatorio = relatorio + pedido.resumoPedido() + "\n";
        }
        relatorio = relatorio + "Total de pedidos: " + pedidos.size() + "\n";
        return relatorio;
    }
}