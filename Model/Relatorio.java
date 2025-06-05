//Essa classe vai ser usada para gerar relatorio de venda e relatorio de estoque. //Arthur

package Model;

import java.util.List;

//Não implementada, estou testando metodos diferentes para criar o relatorio.
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