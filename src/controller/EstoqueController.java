package controller;
import java.util.List;
import model.Estoque;
import model.Ingrediente;
import view.EstoqueView;

//sem entrada de dados

public class EstoqueController {

    public static void adicionarItem(int id, String nome, int quantidade, String unidade) {
        Estoque.adicionar(new Ingrediente(id, nome, quantidade, unidade));
    }

    public static List<Ingrediente> listarIngredientes() {

        return Estoque.getIngredientes();
    }

}
