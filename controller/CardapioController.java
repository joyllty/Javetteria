package controller;

import model.Cardapio; // Importa a classe Cardapio (o Model)
import model.Produto; // Importa a classe Produto
//import model.CategoriaProduto; comentei pq aqui é exclusivo de busca
import java.util.List;
//import java.util.stream.Collectors; // mesma coisa aqui

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

    /* Metodo para buscar produtos por categoria (funcionalidade futura)
    public List<Produto> buscarPorCategoria(CategoriaProduto categoria) {
        // Usa Stream API para filtrar os produtos pela categoria desejada
        return cardapio.getProdutos().stream()
                .filter(produto -> produto.getCategoria() == categoria)
                .collect(Collectors.toList());
    }

    Metodo para buscar produtos por nome (funcionalidade futura que ainda to terminando)
   public List<Produto> buscarPorNome(String nomeBusca) {
        String nomeBuscaLowerCase = nomeBusca.toLowerCase(); // Para busca sem distinção de maiúsculas/minúsculas
        return cardapio.getProdutos().stream()
                .filter(produto -> produto.getNome().toLowerCase().contains(nomeBuscaLowerCase))
                .collect(Collectors.toList());
    }*/

}