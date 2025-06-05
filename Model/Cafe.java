package Model;

// ATENÇÃO: Classe criada para testes. Implementação concreta de Produto para testes do sistema
public class Cafe extends Produto {
    public Cafe(String nome, float preco, String descricao) {
        super(nome, preco, descricao);
    }

    @Override
    public String descricaoDetalhada() {
        return "Café: " + getNome() + "\n" +
               "Preço: R$ " + getPreco() + "\n" +
               "Descrição: " + getDescricao();
    }
} 