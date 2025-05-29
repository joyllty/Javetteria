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

        clientes.add(new Cliente("Letícia", "let", "123456789", "123"));
        funcionarios.add(new Funcionario("Carlos", "car", "987654321", "Atendente", "Noite", "123"));
        gerentes.add(new Gerente("Marina", "mar", "112233445", "Gerente Geral", "Manhã", "123"));

        UsuarioController controller = new UsuarioController(clientes, funcionarios, gerentes);
        Menu menu = new Menu(controller);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        LoginController loginController = new LoginController(clientes, funcionarios, gerentes);
        Pessoa pessoaLogada = loginController.autenticar(login, senha);

        if (pessoaLogada != null) {
            System.out.println("Login bem-sucedido!");
            menu.exibirMenu(pessoaLogada); // ← agora sim
        } else {
            System.out.println("Login inválido.");
        }
    }
}
