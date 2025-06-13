package controller;

import model.Cardapio;
import model.Produto;
import model.CategoriaProduto;
import java.util.List;
import java.util.stream.Collectors;

public class CardapioController {

    private Cardapio cardapio;

    public CardapioController(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public List<Produto> getTodosOsProdutos() {
        return cardapio.getProdutos();
    }

    public List<Produto> buscarPorCategoria(CategoriaProduto categoria) {
        return cardapio.getProdutos().stream()
                .filter(produto -> produto.getCategoria() == categoria)
                .collect(Collectors.toList());
    }
}