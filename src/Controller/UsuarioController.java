package Controller;

import Model.Cliente;
import Model.Funcionario;
import Model.Gerente;

import java.util.ArrayList;

public class UsuarioController {

    private ArrayList<Cliente> clientes;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Gerente> gerentes;

    public UsuarioController(ArrayList<Cliente> clientes, ArrayList<Funcionario> funcionarios, ArrayList<Gerente> gerentes) {
        this.clientes = clientes;
        this.funcionarios = funcionarios;
        this.gerentes = gerentes;
    }

    // --------- CLIENTES ---------
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public ArrayList<Cliente> listarClientes() {
        return clientes;
    }

    public Cliente buscarClientePorLogin(String login) {
        for (Cliente c : clientes) {
            if (c.getLogin().equals(login)) {
                return c;
            }
        }
        return null;
    }

    public boolean removerCliente(String login) {
        Cliente c = buscarClientePorLogin(login);
        if (c != null) {
            clientes.remove(c);
            return true;
        }
        return false;
    }

    public boolean atualizarCliente(String login, String novoNome, String novoCpf) {
        Cliente cliente = buscarClientePorLogin(login);
        if (cliente != null) {
            cliente.setNome(novoNome);
            cliente.setCpf(novoCpf);
            return true;
        }
        return false;
    }

    // --------- FUNCIONÁRIOS ---------
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public ArrayList<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    public Funcionario buscarFuncionarioPorLogin(String login) {
        for (Funcionario f : funcionarios) {
            if (f.getLogin().equals(login)) {
                return f;
            }
        }
        return null;
    }

    public boolean removerFuncionario(String login) {
        Funcionario f = buscarFuncionarioPorLogin(login);
        if (f != null) {
            funcionarios.remove(f);
            return true;
        }
        return false;
    }

    public boolean atualizarFuncionario(String login, String novoNome, String novoCpf, String novoCargo, String novoTurno) {
        Funcionario funcionario = buscarFuncionarioPorLogin(login);
        if (funcionario != null) {
            funcionario.setNome(novoNome);
            funcionario.setCpf(novoCpf);
            funcionario.setCargo(novoCargo);
            funcionario.setTurno(novoTurno);
            return true;
        }
        return false;
    }

    // --------- GERENTES ---------
    public void adicionarGerente(Gerente gerente) {
        gerentes.add(gerente);
    }

    public ArrayList<Gerente> listarGerentes() {
        return gerentes;
    }

    public Gerente buscarGerentePorLogin(String login) {
        for (Gerente g : gerentes) {
            if (g.getLogin().equals(login)) {
                return g;
            }
        }
        return null;
    }

    public boolean removerGerente(String login) {
        Gerente g = buscarGerentePorLogin(login);
        if (g != null) {
            gerentes.remove(g);
            return true;
        }
        return false;
    }

    public boolean atualizarGerente(String login, String novoNome, String novoCpf, String novoCargo, String novoTurno) {
        Gerente gerente = buscarGerentePorLogin(login);
        if (gerente != null) {
            gerente.setNome(novoNome);
            gerente.setCpf(novoCpf);
            gerente.setCargo(novoCargo);
            gerente.setTurno(novoTurno);
            return true;
        }
        return false;
    }

    // --------- ALTERAR SENHA (Clientes, Funcionários e Gerentes) ---------
    public boolean alterarSenha(String login, String novaSenha) {
        Cliente cliente = buscarClientePorLogin(login);
        if (cliente != null) {
            cliente.setSenha(novaSenha);
            return true;
        }

        Funcionario funcionario = buscarFuncionarioPorLogin(login);
        if (funcionario != null) {
            funcionario.setSenha(novaSenha);
            return true;
        }

        Gerente gerente = buscarGerentePorLogin(login);
        if (gerente != null) {
            gerente.setSenha(novaSenha);
            return true;
        }

        return false; // usuário não encontrado
    }

}
