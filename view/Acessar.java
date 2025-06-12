package view;

import model.*;
import controller.UsuarioController;
import controller.LoginController;
import utils.Cores;
import utils.InputHelper;

import java.util.ArrayList;

public class Acessar {

    private static UsuarioController usuarioController;
    private static LoginController loginController;

    public Acessar(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
        this.loginController = new LoginController(
                usuarioController.getClientes(),
                usuarioController.getFuncionarios(),
                usuarioController.getGerentes()
        );
    }

    private static String pedirInput(String prompt) {
        System.out.print(prompt);
        return InputHelper.lerString();
    }

    public static void realizarLogin() {
        System.out.println("\n==========" + (Cores.LAVENDER +  " LOGIN " + Cores.RESET) + Cores.CREME +  "==========");

        System.out.print((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Login: ");
        String login = InputHelper.lerString();
        System.out.print((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Senha: ");
        String senha = InputHelper.lerString();

        Pessoa pessoaLogada = loginController.autenticar(login, senha);

        if (pessoaLogada != null) {
            System.out.println("\nLogin bem-sucedido!");
            System.out.println("===========================");
            exibirMenu(pessoaLogada);
        } else {
            System.out.println("\nLogin inválido.");
            System.out.println("===========================");
        }
    }

    public static void exibirCadastro(int tipo) {
        if (tipo == 0) {
            System.out.println("Voltando ao menu principal.");
            return;
        }
        System.out.println("\n============" + (Cores.LAVENDER +  " CADASTRO " + Cores.RESET) + Cores.CREME +  "============");

        String nome = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Nome: ");
        String login = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Login: ");
        String cpf = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " CPF: ");
        String senha = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Senha: ");

        switch (tipo) {
            case 1:
                cadastrarCliente(nome, login, cpf, senha);
                break;
            case 2:
                cadastrarFuncionario(nome, login, cpf, senha);
                break;
            case 3:
                cadastrarGerente(nome, login, cpf, senha);
                break;
            default:
                System.out.println("\nTipo inválido.");
        }
    }

    private static void cadastrarCliente(String nome, String login, String cpf, String senha) {
        Cliente novoCliente = new Cliente(nome, login, cpf, senha);

        System.out.println("\nEndereço");
        String rua = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Rua: ");
        String numero = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Número: ");
        String bairro = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Bairro: ");
        String cidade = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Cidade: ");

        Endereco novoEndereco = new Endereco();
        novoEndereco.setRua(rua);
        novoEndereco.setNumero(numero);
        novoEndereco.setBairro(bairro);
        novoEndereco.setCidade(cidade);

        novoCliente.setEndereco(novoEndereco);

        usuarioController.adicionarCliente(novoCliente);
        System.out.println("\nCliente cadastrado com sucesso!");
        System.out.println("================================");
    }

    private static void cadastrarFuncionario(String nome, String login, String cpf, String senha) {
        String cargo = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Cargo: ");
        String turno = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Turno: ");
        Funcionario novoFuncionario = new Funcionario(nome, login, cpf, cargo, turno, senha);
        usuarioController.adicionarFuncionario(novoFuncionario);
        System.out.println("\nFuncionário cadastrado com sucesso!");
        System.out.println("==================================");
    }

    private static void cadastrarGerente(String nome, String login, String cpf, String senha) {
        String turnoGerente = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Turno: ");
        Gerente novoGerente = new Gerente(nome, login, cpf, turnoGerente, senha);
        usuarioController.adicionarGerente(novoGerente);
        System.out.println("\nGerente cadastrado com sucesso!");
        System.out.println("================================");
    }

    public static void exibirMenu(Pessoa pessoaLogada) {
        String tipo = pessoaLogada.getTipoPessoa();

        switch (tipo) {
            case "Cliente":
                MenuCliente.menuCliente((Cliente) pessoaLogada);
                break;
            case "Funcionário":
                MenuFuncionario.menuFuncionario((Funcionario) pessoaLogada);
                break;
            case "Gerente":
                MenuGerente.menuGerente((Gerente) pessoaLogada);
                break;
            default:
                System.out.println("\nTipo de usuário desconhecido.");
        }
    }

    public static void verDadosCliente(Cliente cliente) {
        System.out.println("\n==========" + (Cores.LAVENDER +  " MEUS DADOS " + Cores.RESET) + Cores.CREME +  "==========");
        System.out.println((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Nome: " + cliente.getNome());
        System.out.println((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " CPF: " + cliente.getCpf());
        if (cliente.getEndereco() != null && cliente.getEndereco().getRua() != null && !cliente.getEndereco().getRua().isEmpty()) {
            System.out.println((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Endereço: " + cliente.getEndereco().getRua() + ", " +
                    cliente.getEndereco().getNumero() + " - " + cliente.getEndereco().getBairro() +
                    ", " + cliente.getEndereco().getCidade());
            System.out.println("================================");
        } else {
            System.out.println((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + "\nEndereço: Não cadastrado.");
            System.out.println("================================");
        }
    }

    public static void alterarEnderecoCliente(Cliente cliente) {
        System.out.println("\n=======" + (Cores.LAVENDER +  " ALTERAR ENDEREÇO " + Cores.RESET) + Cores.CREME +  "=======");
        String novaRua = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Rua:");
        String novoNumero = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Número:");
        String novoBairro = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Bairro:");
        String novaCidade = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Cidade:");

        usuarioController.atualizarCliente(
                cliente.getLogin(),
                cliente.getNome(),
                cliente.getCpf(),
                novaRua,
                novoNumero,
                novoBairro,
                novaCidade
        );
        System.out.println("\nEndereço atualizado com sucesso!");
        System.out.println("================================");
    }

    public static void menuFuncionario(Funcionario funcionario) {
        System.out.println("\n======" + (Cores.LAVENDER +  " DADOS FUNCIONÁRIO " + Cores.RESET) + Cores.CREME +  "======");
        System.out.println((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Nome: " + funcionario.getNome());
        System.out.println((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Cargo: " + funcionario.getCargo());
        System.out.println((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Turno: " + funcionario.getTurno());
        InputHelper.lerString();
        System.out.println("================================");
    }

    public static void listarFuncionariosGerente() {
        System.out.println("\n======" + (Cores.LAVENDER +  " LISTA FUNCIONÁRIOS " + Cores.RESET) + Cores.CREME +  "======");
        for (Funcionario f : usuarioController.listarFuncionarios()) {
            System.out.println("Nome: " + f.getNome() + " | Cargo: " + f.getCargo() + " | Login: " + f.getLogin());
        }
    }

    public static void listarClientesGerente() {
        System.out.println("\n======" + (Cores.LAVENDER +  " LISTA CLIENTES " + Cores.RESET) + Cores.CREME +  "======");
        for (Cliente c : usuarioController.listarClientes()) {
            System.out.println("Nome: " + c.getNome() + " | CPF: " + c.getCpf() + " | Login: " + c.getLogin());
            if (c.getEndereco() != null) {
                System.out.println("  Endereço: " + c.getEndereco().getRua() + ", " +
                        c.getEndereco().getNumero() + " - " + c.getEndereco().getBairro() +
                        ", " + c.getEndereco().getCidade());
            }
        }
    }

    public static void cadastrarNovoFuncionarioGerente() {
        System.out.println("\n=====" + (Cores.LAVENDER +  " CADASTRAR FUNCIONÁRIO " + Cores.RESET) + Cores.CREME +  "=====");
        String nome = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Nome: ");
        String login = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Login: ");
        String cpf = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " CPF: ");
        String cargo = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Cargo: ");
        String turno = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Turno: ");
        String senha = pedirInput((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Senha: ");
        usuarioController.adicionarFuncionario(new Funcionario(nome, login, cpf, cargo, turno, senha));
        System.out.println("\nFuncionário cadastrado com sucesso!");
        System.out.println("==============================");
    }

    public static void removerFuncionarioGerente() {
        System.out.println("\n==========" + (Cores.LAVENDER +  " REMOVER FUNCIONÁRIO " + Cores.RESET) + Cores.CREME +
                "==========");
        System.out.print((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Login do funcionário a remover: ");
        String loginRemover = InputHelper.lerString();
        if (usuarioController.removerFuncionario(loginRemover)) {
            System.out.println("\nFuncionário removido com sucesso.");
            System.out.println("===================================");
        } else {
            System.out.println("\nFuncionário não encontrado.");
            System.out.println("===================================");
        }
    }

    public static void alterarSenhaUsuarioGerente() {
        System.out.println("\n=====" + (Cores.LAVENDER +  " ALTERAR SENHA " + Cores.RESET) + Cores.CREME +  "=====");
        System.out.print((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Login do usuário: ");
        String loginAlt = InputHelper.lerString();
        System.out.print((Cores.LAVENDER + "\n>>" + Cores.RESET) + Cores.CREME + " Nova senha: ");
        String novaSenha = InputHelper.lerString();

        if (usuarioController.alterarSenha(loginAlt, novaSenha)) {
            System.out.println("\nSenha alterada.");
        }
    }
}
