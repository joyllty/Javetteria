

import model.Cardapio;
import controller.CardapioController;
import view.CardapioView;

public class Main {
    public static void main(String[] args) {
        // Instancia o Model
        Cardapio cardapioModel = new Cardapio();

        // Instancia o Controller, passando o Model para ele
        CardapioController cardapioController = new CardapioController(cardapioModel);

        // Instancia a View, passando o Controller para ela
        CardapioView cardapioView = new CardapioView(cardapioController);

        //Inicia a interação com a View
        cardapioView.iniciar();
    }
}