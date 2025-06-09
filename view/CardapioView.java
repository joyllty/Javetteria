package view;
import controller.CardapioController;

import java.util.Scanner;

public class CardapioView {

    Scanner input = new Scanner(System.in);

    public int exibirCardapio(){
        System.out.println("======================");
        System.out.println("= 1 - Ver cardápio");
        System.out.println("= 2 - Buscar");
        System.out.println("= 3 - Voltar");
        return input.nextInt();
    }

}

