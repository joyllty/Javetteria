package View;

import Model.*;
import Controller.UsuarioController;
import Controller.LoginController;

import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private UsuarioController usuarioController;

    public Menu(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }



    public void exibirCadastro() {
        System.out.println("\n=== Cadastro de Usuário ===");
        System.out.println("[1] Cliente");
        System.out.println("[2] Funcionário");
        System.out.println("[3] Gerente");
        System.out.print("Escolha o tipo de usuário: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        switch (tipo) {
            case 1: // Cliente
                Cliente novoCliente = new Cliente(nome, login, cpf, senha);
                usuarioController.adicionarCliente(novoCliente);
                System.out.println("Cliente cadastrado com sucesso!");
                break;

            case 2: // Funcionário
                System.out.print("Cargo: ");
                String cargo = scanner.nextLine();
                System.out.print("Turno: ");
                String turno = scanner.nextLine();
                Funcionario novoFuncionario = new Funcionario(nome, login, cpf, cargo, turno, senha);
                usuarioController.adicionarFuncionario(novoFuncionario);
                System.out.println("Funcionário cadastrado com sucesso!");
                break;

            case 3: // Gerente
                System.out.print("Cargo: ");
                String cargoGerente = scanner.nextLine();
                System.out.print("Turno: ");
                String turnoGerente = scanner.nextLine();
                Gerente novoGerente = new Gerente(nome, login, cpf, cargoGerente, turnoGerente, senha);
                usuarioController.adicionarGerente(novoGerente);
                System.out.println("Gerente cadastrado com sucesso!");
                break;

            default:
                System.out.println("Tipo inválido.");
        }
    }


    public void exibirMenu(Pessoa pessoaLogada) {
        String tipo = pessoaLogada.getTipoPessoa();

        switch (tipo) {
            case "Cliente":
                menuCliente((Cliente) pessoaLogada);
                break;
            case "Funcionário":
                menuFuncionario((Funcionario) pessoaLogada);
                break;
            case "Gerente":
                menuGerente((Gerente) pessoaLogada);
                break;
            default:
                System.out.println("Tipo de usuário desconhecido.");
        }
    }

    private void menuCliente(Cliente cliente) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== Menu Cliente ===");
            System.out.println("1. Ver meus dados");
            System.out.println("2. Alterar endereço");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("CPF: " + cliente.getCpf());
                    System.out.println("Endereço: " + cliente.getEndereco().getRua() + ", " +
                            cliente.getEndereco().getNumero() + " - " + cliente.getEndereco().getBairro() +
                            ", " + cliente.getEndereco().getCidade());
                    break;
                case 2:
                    System.out.println("Nova rua:");
                    cliente.getEndereco().setRua(scanner.nextLine());
                    System.out.println("Novo número:");
                    cliente.getEndereco().setNumero(scanner.nextLine());
                    System.out.println("Novo bairro:");
                    cliente.getEndereco().setBairro(scanner.nextLine());
                    System.out.println("Nova cidade:");
                    cliente.getEndereco().setCidade(scanner.nextLine());
                    System.out.println("Endereço atualizado com sucesso!");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void menuFuncionario(Funcionario funcionario) {
        System.out.println("\n=== Menu Funcionário ===");
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Cargo: " + funcionario.getCargo());
        System.out.println("Turno: " + funcionario.getTurno());
    }

    private void menuGerente(Gerente gerente) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== Menu Gerente ===");
            System.out.println("1. Listar Funcionários");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Cadastrar novo Funcionário");
            System.out.println("4. Remover Funcionário");
            System.out.println("5. Alterar senha de usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Corrigido: chamar listarFuncionarios() ao invés de getFuncionarios()
                    for (Funcionario f : usuarioController.listarFuncionarios()) {
                        System.out.println("Nome: " + f.getNome() + " | Cargo: " + f.getCargo() + " | Login: " + f.getLogin());
                    }
                    break;
                case 2:
                    // Corrigido: chamar listarClientes() ao invés de getClientes()
                    for (Cliente c : usuarioController.listarClientes()) {
                        System.out.println("Nome: " + c.getNome() + " | CPF: " + c.getCpf() + " | Login: " + c.getLogin());
                    }
                    break;
                case 3:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Login: ");
                    String login = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();
                    System.out.print("Turno: ");
                    String turno = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();
                    usuarioController.adicionarFuncionario(new Funcionario(nome, login, cpf, cargo, turno, senha));
                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;
                case 4:
                    System.out.print("Login do funcionário a remover: ");
                    String loginRemover = scanner.nextLine();
                    if (usuarioController.removerFuncionario(loginRemover)) {
                        System.out.println("Removido com sucesso.");
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Login do usuário: ");
                    String loginAlt = scanner.nextLine();
                    System.out.print("Nova senha: ");
                    String novaSenha = scanner.nextLine();
                    // Corrigido: chamar alterarSenha (que deve existir no UsuarioController)
                    if (usuarioController.alterarSenha(loginAlt, novaSenha)) {
                        System.out.println("Senha alterada.");
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

}
