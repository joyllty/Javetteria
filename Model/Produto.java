public abstract class  Produto {

    private String nome;
    private double preco;
    private String descricao;

    public Produto(String nome,double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

   public abstract String descricaoDetalhada(); //cada produto precisa ter sua propria descrição detalhada

}
