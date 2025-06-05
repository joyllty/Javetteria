package Model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numeroPedido;
    private List<ItemPedido> itens;
    private Pagamento formaPagamento;
    private static int contadorPedidos = 1;
    private String usuario; //Criada temporariamente até merge com modulo de usuarios //Arthur

    public Pedido(String usuario) {
        this.numeroPedido = contadorPedidos++;
        this.itens = new ArrayList<>();
        this.usuario = usuario;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public void removerItem(ItemPedido item) {
        itens.remove(item);
    }

    public boolean processarPagamento(Pagamento pagamento) {
        this.formaPagamento = pagamento;
        return pagamento.processarPagamento(getValorTotal());
    }

    public float getValorTotal() {
        float total = 0.0f;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public List<ItemPedido> getItens() {
        return new ArrayList<>(itens);
    }

    public Pagamento getFormaPagamento() {
        return formaPagamento;
    }

    public String getUsuario() {
        return usuario;
    }

    public String resumoPedido() {
        StringBuilder resumo = new StringBuilder();
        resumo.append("Pedido #").append(numeroPedido)
              .append(" | Usuário: ").append(usuario)
              .append("\nItens:\n");
        
        for (ItemPedido item : itens) {
            resumo.append("- ").append(item.formatarItem()).append("\n");
        }
        
        resumo.append(String.format("Total: R$ %.2f", getValorTotal()));
        return resumo.toString();
    }
}
