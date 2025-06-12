package controller;

import model.Cardapio; // Importa a classe Cardapio (o Model)
import model.Produto; // Importa a classe Produto
import model.CategoriaProduto; //exclusivo para busca
import java.util.List;
import java.util.stream.Collectors; // mesma coisa aqui

public class CardapioController {

    private Cardapio cardapio; // Referência ao objeto Cardapio

    // Construtor: o Controller recebe a instância do Cardapio

    public CardapioController(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    // Metodo que a CardapioView vai chamar para obter todos os produtos do cardápio
    public List<Produto> getTodosOsProdutos() {
        return cardapio.getProdutos(); // Bucetudo qye Delega a responsabilidade de obter a lista
    }

    public List<Produto> buscarPorCategoria(CategoriaProduto categoria) {
        // Usa Stream API para filtrar os produtos pela categoria desejada
        return cardapio.getProdutos().stream()
                .filter(produto -> produto.getCategoria() == categoria)
                .collect(Collectors.toList());
    }

}