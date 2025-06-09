package model;
public class Bebidas extends Produto {

    private String tamanho;
    private String temperatura;

    public Bebidas(String nome,float preco, String descricao,
                   String tamanho,String temperatura) {
        super(nome,preco,descricao);
        this.tamanho = tamanho;
        this.temperatura = temperatura;

    }

    @Override
    public String descricaoDetalhada(){

     return  "Nome da Bebida >> " + getNome() + "\n"
             + "Preço >> R$ " + getPreco() + "\n"
             + "Descrição >> " + getDescricao() + "\n"
             + "Tamanho >> " + tamanho + "\n"
             + "Temperatura >> " + temperatura + "\n";
    }
}
