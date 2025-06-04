package controller;
import java.util.List;
import model.Estoque;
import model.Ingrediente;


public class EstoqueController {
    public static List<Ingrediente> listarItens() {

        return Estoque.getIngredientes();
    }

    public static void adicionarItem(int id, String nome, int quantidade, String unidade) {
        Estoque.adicionar(new Ingrediente(id, nome, quantidade, unidade));
    }

    public static boolean removerItem(int id){
        return Estoque.remover(id);
    }

    public static void atualizarItem(int id, int quantidade){
        Estoque.atualizarQuantidade(id, quantidade);
    }

}
