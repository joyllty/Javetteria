package model;

import java.util.ArrayList;
import java.util.List;


public class Estoque{

    private static List<Ingrediente> itens = new ArrayList<>();

    public static void inicializarEstoque() {
        adicionar(new Ingrediente(1, "Café", 20, "1Kg"));
        adicionar(new Ingrediente(2, "Leite", 48, "1L"));
        adicionar(new Ingrediente(3, "Leite Zero Lactose", 26, "1L"));
        adicionar(new Ingrediente(4, "Leite Vegetal", 10, "1L"));
        adicionar(new Ingrediente(5, "Xarope de Limão",20, "700mL"));
        adicionar(new Ingrediente(6, "Xarope de Morango",23, "700mL"));
        adicionar(new Ingrediente(8, "Xarope de Pêssego",25, "700mL"));
        adicionar(new Ingrediente(9, "Xarope de Baunilha",25, "700mL"));
        adicionar(new Ingrediente(10, "Xarope de Cramberry",21, "700mL"));
        adicionar(new Ingrediente(11, "Calda de Caramelo",20, "1,3Kg"));
        adicionar(new Ingrediente(12, "Calda de Chocolate",20, "1,3Kg"));
        adicionar(new Ingrediente(13, "Chá Matte",2, "20un"));
        adicionar(new Ingrediente(14, "Polpa de Morango",20,"100g"));
        adicionar(new Ingrediente(15, "Polpa de Pêssego",20,"100g"));
        adicionar(new Ingrediente(16, "Laranja",52,"unidade"));
        adicionar(new Ingrediente(17, "Sprite",30,"350mL"));
        adicionar(new Ingrediente(18, "Coca-Cola",45,"350mL"));
        adicionar(new Ingrediente(19, "Guaraná",43,"350mL"));
        adicionar(new Ingrediente(20, "Monster",30,"473mL"));
        adicionar(new Ingrediente(21, "Red Bull",34,"250mL"));
        adicionar(new Ingrediente(22, "Canela",1,"5Kg"));
        adicionar(new Ingrediente(23, "Açúcar",5, "10Kg"));
        adicionar(new Ingrediente(24, "Ovo",95, "unidade"));
        adicionar(new Ingrediente(25, "Chocolate",10, "1Kg"));
    }

    public static void adicionar(Ingrediente ingrediente) {
        itens.add(ingrediente);
    }

    public static Ingrediente getItem(int id){
        for (Ingrediente i : itens){
            if(i.getId() == id) return i;
        }
        return null;
    }

    public static boolean remover(int id) {
        Ingrediente item = getItem(id);
        return itens.remove(item);
    }

    public static void atualizarQuantidade(int id, int novaQuantidade) {
        for (Ingrediente i : itens) {
            if (i.getId() == id) { //busca do ingrediente
                i.setQuantidade(novaQuantidade);
                return;
            }
        }
    }

    public static List<Ingrediente> getIngredientes() {
        return itens;
    }

}
