package model;

import java.util.List;

public abstract class  Produto {

    private String nome;
    private float preco;
    private String descricao;

    private List<CategoriaProduto> produtos;

    public Produto(String nome,float preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

   public abstract String descricaoDetalhada(); //cada produto precisa ter sua propria descrição detalhada

}
