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
                "nenhum","1 unidade (grande)"));
        produtos.add(new Comidas("Empadão de Frango",12.50f,
                "Crocante por fora e molhadinho por dentro, este empadão de frango leva cebola, " +
                        "requeijão, milho verde, tomate, cheiro-verde e azeitonas no recheio.",
                "maionese extra","1 fatia (grande)"));
        produtos.add(new Comidas("Folhado 4 Queijos",9.50f,"folhado quentinho e macio com recheio" +
                " de queijo mussarela, parmesão, provolone e gorgonzola.", "nenhum","1 unidade (médio)"));

}
    public Cardapio(List<Produto> produtos) {
        this.produtos = produtos;
    }

}

