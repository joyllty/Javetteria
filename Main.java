

import model.Cardapio;
import controller.CardapioController;
import view.CardapioView;

public class Main {
    public static void main(String[] args) {

        Cardapio cardapioModel = new Cardapio();
        CardapioController cardapioController = new CardapioController(cardapioModel);
        CardapioView cardapioView = new CardapioView(cardapioController);

        cardapioView.iniciar();
    }
}