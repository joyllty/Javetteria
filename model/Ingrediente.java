package model;

public class Ingrediente {

    private int id;
    private String nome;
    private int quantidade;
    private String unidade; //g, ml, unidades

    public Ingrediente(int id, String nome, int quantidade, String unidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /* ---------------------------------------------
    @Override
    public String toString() {
        return "ID: " + id +
                ", Nome: " + nome +
                ", Quantidade: " + quantidade + " " + unidade +
                ", Custo por unidade: R$" + custoPorUnidade;
    }

    */
}
