import Controller.LoginController;
import Controller.UsuarioController;
import Model.Cliente;
import Model.Funcionario;
import Model.Gerente;
import Model.Pessoa;
import View.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Gerente> gerentes = new ArrayList<>();

        UsuarioController usuarioController = new UsuarioController(clientes, funcionarios, gerentes);
        Menu menu = new Menu(usuarioController);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Javetteria ===");
            System.out.println("[1] Cadastrar");
            System.out.println("[2] Login");
            System.out.println("[3] Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    menu.exibirCadastro();
                    break;

                case "2":
                    System.out.print("Login: ");
                    String login = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    LoginController loginController = new LoginController(clientes, funcionarios, gerentes);
                    Pessoa pessoaLogada = loginController.autenticar(login, senha);

                    if (pessoaLogada != null) {
                        System.out.println("\nLogin bem-sucedido!");
                        menu.exibirMenu(pessoaLogada);
                    } else {
                        System.out.println("Login inválido.");
                    }
                    break;

                case "3":
                    System.out.println("Saindo do sistema...");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
