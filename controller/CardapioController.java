package controller;
import model.Cardapio;
import model.Produto;
import view.CardapioView;

import java.util.List;

//Aqui estarão as classes que recebem as ações do usuário

public class CardapioController {
    private Cardapio cardapio;


    public CardapioController(){
       this.cardapio = new Cardapio();
    } // construtor
    public List<Produto> listarProdutos(){
        return cardapio.getProdutos();
        //metodo para retornar todos os produtos
    }
//metodos como exibircardapiocompleto
    // buscarporcategoria
    //buscarpornome

}
