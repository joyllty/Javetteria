package model;

import java.util.ArrayList;
import java.util.List;

import model.StatusPedido;

public class Pedido {
    private int numeroPedido;
    private List<ItemPedido> itens;
    private Pagamento formaPagamento;
    private String usuario;

    public Pedido(String usuario, int numeroPedido) {
        this.numeroPedido = numeroPedido;
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

    public boolean isPago() {
        return formaPagamento != null;
    }

    public StatusPedido getStatus() {
        return formaPagamento != null ? StatusPedido.PAGO : StatusPedido.PENDENTE;
    }

    public String resumoPedido() {
        StringBuilder resumo = new StringBuilder();
        String status = getStatus().getTag();
        resumo.append(status)
              .append(" Pedido #").append(numeroPedido)
              .append(" | Usuário: ").append(usuario)
              .append("\nItens:\n");
        
        for (ItemPedido item : itens) {
            resumo.append("- ").append(item.formatarItem()).append("\n");
        }
        
        resumo.append(String.format("Total: R$ %.2f", getValorTotal()));
        if (formaPagamento != null) {
            resumo.append("\nForma de Pagamento: ").append(formaPagamento.getFormaPagamento());
        }
        return resumo.toString();
    }
}
