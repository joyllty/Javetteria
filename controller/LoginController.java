package controller;
import model.*;

import java.util.ArrayList;

public class LoginController {
    private ArrayList<Cliente> clientes;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Gerente> gerentes;

    public LoginController(ArrayList<Cliente> clientes, ArrayList<Funcionario> funcionarios, ArrayList<Gerente> gerentes){
        this.clientes = clientes;
        this.funcionarios = funcionarios;
        this.gerentes = gerentes;
    }

    public Pessoa autenticar(String login, String senha) {
        for (Cliente c : clientes) {
            Pessoa p = c.login(login, senha);
            if (p != null) return p;
        }

        for (Funcionario f : funcionarios) {
            Pessoa p = f.login(login, senha);
            if (p != null) return p;
        }

        for (Gerente g : gerentes) {
            Pessoa p = g.login(login, senha);
            if (p != null) return p;
        }

        return null;
    }
}
