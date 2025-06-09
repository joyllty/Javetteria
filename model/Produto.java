package model;

import java.util.List;

public abstract class  Produto {

    private String nome;
    private float preco;
    private String descricao;
    protected CategoriaProduto categoria;


    public Produto(CategoriaProduto categoria,String nome,float preco, String descricao) {
        this.categoria = categoria;
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

    public CategoriaProduto getCategoria() { // Getter na classe mãe
        return categoria;
    }
   public abstract String descricaoDetalhada(); //cada produto precisa ter sua propria descrição detalhada

}
