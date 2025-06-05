package Model;

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

    public float getSubtotal() {
        return produto.getPreco() * quantidade;
    }


    //TODO: SIMPLICAR E ACHAR OUTRO METODO SEM TOSTRING //arthur
    @Override
    public String toString() {
        return String.format("%s x%d - R$ %.2f", 
            produto.getNome(), 
            quantidade, 
            getSubtotal());
    }
}