package Model;

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
        produtos.add(new Comidas("Empadão de Frango",12.50f))

}
    public Cardapio(List<Produto> produtos) {
        this.produtos = produtos;
    }

}

