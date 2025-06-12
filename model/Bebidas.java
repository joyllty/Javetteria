package model;
public class Bebidas extends Produto {

    private String tamanho;
    private String temperatura;

    public Bebidas(CategoriaProduto categoria,String nome,float preco, String descricao,
                   String tamanho,String temperatura) {
        super(categoria,nome,preco,descricao);
        this.tamanho = tamanho;
        this.temperatura = temperatura;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getTemperatura() {
        return temperatura;
    }

    @Override
    public String descricaoDetalhada(){
     return  "Categoria >> " + getCategoria().name() + "\n"+
             "Nome da Bebida >> " + getNome() + "\n"
             + "Preço >> R$ " + getPreco() + "\n"
             + "Descrição >> " + getDescricao() + "\n"
             + "Tamanho >> " + tamanho + "\n"
             + "Temperatura >> " + temperatura + "\n";
    }
}
