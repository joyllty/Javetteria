package Model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numeroPedido;
    private List<ItemPedido> itens;
    private Pagamento formaPagamento;
    private static int contadorPedidos = 1;
    private String usuario; // Criada temporariamente até a logica do modulo de clientes e func estar finalizada.

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
        return pagamento.processarPagamento(0f);
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
        int quantidadeItens = itens.size();
        return "Pedido #" + numeroPedido + " | Usuário: " + usuario + " | Quantidade de itens: " + quantidadeItens;
    }
}
