package model;

public class ItemPedido {
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Calcula subtotal multiplicando preço do produto pela quantidade
    public float getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    // Formata item para exibição com nome, quantidade e subtotal
    public String formatarItem() {
        return String.format("%s x%d - R$ %.2f", 
            produto.getNome(), 
            quantidade, 
            getSubtotal());
    }
}