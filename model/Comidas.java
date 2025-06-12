package model;

public class Comidas extends Produto{

    private String acompanhamentos;
    private String porcao;

    public Comidas(  CategoriaProduto categoria,String nome, float preco, String descricao,String acompanhamentos, String porcao){
        super(categoria,nome,preco,descricao);
        this.acompanhamentos = acompanhamentos;
        this.porcao = porcao;

    }

    public String getAcompanhamentos() {
        return acompanhamentos;
    }

    public String getPorcao() {
        return porcao;
    }
    @Override
    public String descricaoDetalhada(){
        return  "Categoria >> " + getCategoria().name() + "\n"+
                "Nome >> " + getNome() + "\n"
                + "Preço >> R$ " + getPreco() + "\n"
                + "Descrição >> " + getDescricao() + "\n"
                + "Acompanhamentos >> " + acompanhamentos + "\n"
                + "Porção >> " + porcao + "\n";
    }
}
