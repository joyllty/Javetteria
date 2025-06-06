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

    // Adiciona item ao pedido e atualiza o total
    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    // Remove item do pedido e atualiza o total
    public void removerItem(ItemPedido item) {
        itens.remove(item);
    }

    // Processa pagamento e armazena forma de pagamento se sucesso
    public boolean processarPagamento(Pagamento pagamento) {
        this.formaPagamento = pagamento;
        return pagamento.processarPagamento(getValorTotal());
    }

    // Calcula valor total do pedido somando subtotal de cada item
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

    // Retorna cópia da lista para evitar modificações externas
    public List<ItemPedido> getItens() {
        return new ArrayList<>(itens);
    }

    public Pagamento getFormaPagamento() {
        return formaPagamento;
    }

    public String getUsuario() {
        return usuario;
    }

    // Gera resumo formatado do pedido com número, usuário, itens e total
    public String resumoPedido() {
        StringBuilder resumo = new StringBuilder();
        String status = formaPagamento != null ? "[PAGO]" : "[PENDENTE]";
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
