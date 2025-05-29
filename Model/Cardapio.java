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
        produtos.add(new Bebidas("Espresso Doppio",9.90f,"Espresso com leite e um toque de avelã," +
                " finalizado com chantilly e calda de chocolate.","pequeno","demasiado quente"));

}
    public Cardapio(List<Produto> produtos) {
        this.produtos = produtos;
    }

}

