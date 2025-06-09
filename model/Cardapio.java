package model;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {

    private List<Produto> produtos;

    public Cardapio(){
        this.produtos = new ArrayList<>();
        cadastrarProdutos();
    }
public void cadastrarProdutos(){
        produtos.add(new Comidas("Pão de Queijo", 10.0f,
                "pãozinho assado, feito à base de polvilho azedo e queijo",
                "nenhum","1 UNIDADE GRANDE"));
        produtos.add(new Comidas("Empadão de Frango",12.50f,
                "Crocante por fora e molhadinho por dentro, este empadão de frango leva cebola, " +
                        "requeijão, milho verde, tomate, cheiro-verde e azeitonas no recheio.",
                "maionese extra","1 FATIA GRANDE"));
        produtos.add(new Comidas("Folhado 4 Queijos",9.50f,"folhado quentinho e macio com recheio" +
                " de queijo mussarela, parmesão, provolone e gorgonzola.", "nenhum","1 UNIDADE MÉDIA"));

        produtos.add(new Comidas("Bauru da casa",8.20f,"Pão na chapa feito com presunto," +
                " queijo e tomate em rodelas","sachê de azeite", "1 UNIDADE MÉDIA"));
        produtos.add(new Comidas("Coxinha de cheddar", 10.0f,"coxinha feita a base de aipim rechada " +
                "com frango e catupiry", "Ketchup e Maionese","1 UNIDADE GRANDE"));
        produtos.add(new Comidas("Empadão de Palmito[VEG]",11.50f,"Feito com uma massa crocante e recheado com palmito" +
                " picado, cebola, alho e temperos a gosto","Ketchup e Maionese","1 FATIA MÉDIA"));
        produtos.add(new Comidas("Corn Dog", 12.50f,"De massa leve e crocante envolvendo salsichas e queijo derretido, " +
                "esse lanche é uma verdadeira explosão de sabores.","Ketchup,Maionese e Mostarda", "1 UNIDADE GRANDE"));
        
}
    public List<Produto> getProdutos() {
        return produtos;
    }

}

