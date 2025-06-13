import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import controller.*;
import model.*;
import view.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Gerente> gerentes = new ArrayList<>();

        UsuarioController usuarioController = new UsuarioController(clientes, funcionarios, gerentes);
        Acessar acessar = new Acessar(usuarioController);

        Cardapio cardapioModel = new Cardapio();

        CardapioController cardapioController = new CardapioController(cardapioModel);

        CardapioView cardapioView = new CardapioView(cardapioController);

        model.Estoque.inicializarEstoque();

        view.MenuInterativo.arteInicial();

        view.MenuInterativo.menuPrincipal();

    }

}