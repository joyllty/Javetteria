package model;

import java.util.ArrayList;
import java.util.List;


public class Estoque{

    private static List<Ingrediente> itens = new ArrayList<>();

    public static void inicializarEstoque() {
        adicionar(new Ingrediente(1, "Café", 20, "1Kg"));
        adicionar(new Ingrediente(2, "Matchá", 10, "1Kg"));
        adicionar(new Ingrediente(3, "Leite", 48, "1L"));
        adicionar(new Ingrediente(4, "Leite Zero Lactose", 26, "1L"));
        adicionar(new Ingrediente(5, "Leite Vegetal", 10, "1L"));
        adicionar(new Ingrediente(6, "Xarope de Limão",20, "700ml"));
        adicionar(new Ingrediente(7, "Xarope de Morango",23, "700ml"));
        adicionar(new Ingrediente(8, "Xarope de Pêssego",25, "700ml"));
        adicionar(new Ingrediente(9, "Xarope de Baunilha",25, "700ml"));
        adicionar(new Ingrediente(10, "Xarope de Cranberry",21, "700ml"));
        adicionar(new Ingrediente(11, "Calda de Caramelo",20, "1,3Kg"));
        adicionar(new Ingrediente(12, "Calda de Chocolate",20, "1,3Kg"));
        adicionar(new Ingrediente(13, "Essência de Baunilha",4, "960ml"));
        adicionar(new Ingrediente(14, "Chá Matte",2, "20un"));
        adicionar(new Ingrediente(15, "Polpa de Morango",20,"100g"));
        adicionar(new Ingrediente(16, "Polpa de Pêssego",20,"100g"));
        adicionar(new Ingrediente(17, "Laranja",52,"unidade"));
        adicionar(new Ingrediente(18, "Limão",20,"unidade"));
        adicionar(new Ingrediente(19, "Canela",1,"5Kg"));
        adicionar(new Ingrediente(20, "Açúcar",5, "10Kg"));
        adicionar(new Ingrediente(21, "Ovo",95, "unidade"));
        adicionar(new Ingrediente(22, "Chocolate ao Leite",10, "1Kg"));
        adicionar(new Ingrediente(23, "Chocolate Branco",7, "1Kg"));
        adicionar(new Ingrediente(24, "Chocolate Meio Amargo",7, "1Kg"));
        adicionar(new Ingrediente(25, "Leite Condensado",40, "395g"));
        adicionar(new Ingrediente(26, "Manteiga",10, "5Kg"));
        adicionar(new Ingrediente(27, "Sprite",30,"300mL"));
        adicionar(new Ingrediente(28, "Coca-Cola",45,"300mL"));
        adicionar(new Ingrediente(29, "Água sem gás",50,"520ml"));
        adicionar(new Ingrediente(30, "Água com gás",34,"520ml"));
        adicionar(new Ingrediente(31, "Vodka",2,"1L"));
        adicionar(new Ingrediente(32, "Whisky",2,"750ml"));
        adicionar(new Ingrediente(33, "Soju Tradicional",3,"360ml"));
        adicionar(new Ingrediente(34, "Soju de Yakult",5,"360ml"));
        adicionar(new Ingrediente(35, "Licor de Café",2,"720ml"));
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
            if (i.getId() == id) {
                i.setQuantidade(novaQuantidade);
                return;
            }
        }
    }

    public static List<Ingrediente> getIngredientes() {
        return itens;
    }

}