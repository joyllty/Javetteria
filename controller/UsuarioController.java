package controller;

//arquivos
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//---


import model.*;

import java.util.ArrayList;

public class UsuarioController {

    private ArrayList<Cliente> clientes;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Gerente> gerentes;

    public UsuarioController(ArrayList<Cliente> clientes, ArrayList<Funcionario> funcionarios, ArrayList<Gerente> gerentes) {
        this.clientes = clientes;
        this.funcionarios = funcionarios;
        this.gerentes = gerentes;
        carregarDadosDosArquivos();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

    // --------- CLIENTES ---------
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        salvarEmArquivo("data" + File.separator + "clientes.txt", cliente);

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
            salvarListaClientes();
            return true;
        }
        return false;
    }

    public boolean atualizarCliente(String login, String novoNome, String novoCpf, String novaRua, String novoNumero, String novoBairro, String novaCidade) { // <--- NOVOS PARÂMETROS AQUI
        Cliente cliente = buscarClientePorLogin(login);
        if (cliente != null) {
            cliente.setNome(novoNome);
            cliente.setCpf(novoCpf);


            if (cliente.getEndereco() == null) {
                cliente.setEndereco(new Endereco());
            }

            // 2
            cliente.getEndereco().setRua(novaRua);
            cliente.getEndereco().setNumero(novoNumero);
            cliente.getEndereco().setBairro(novoBairro);
            cliente.getEndereco().setCidade(novaCidade);

            // 3
            //
            salvarListaClientes();

            return true;
        }
        return false;
    }

    // --------- FUNCIONÁRIOS ---------
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        salvarEmArquivo("data/funcionarios.txt", funcionario);

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
            salvarListaFuncionarios(); // atualiza o arquivo
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
        salvarEmArquivo("data/gerentes.txt", gerente);

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
            salvarListaGerentes(); // atualiza o arquivo
            return true;
        }
        return false;
    }

    public boolean atualizarGerente(String login, String novoNome, String novoCpf, String novoTurno) {
        Gerente gerente = buscarGerentePorLogin(login);
        if (gerente != null) {
            gerente.setNome(novoNome);
            gerente.setCpf(novoCpf);
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
            salvarListaClientes();
            return true;
        }

        Funcionario funcionario = buscarFuncionarioPorLogin(login);
        if (funcionario != null) {
            funcionario.setSenha(novaSenha);
            salvarListaFuncionarios();
            return true;
        }

        Gerente gerente = buscarGerentePorLogin(login);
        if (gerente != null) {
            gerente.setSenha(novaSenha);
            salvarListaGerentes();
            return true;
        }

        return false; // usuário não encontrado
    }




    //----------ARQUIVOS--------

    //CARREGAMENTO DE ARQUIVOS

    private void carregarDadosDosArquivos() {
        carregarClientes("data" + File.separator + "clientes.txt"); //
        carregarFuncionarios("data" + File.separator + "funcionarios.txt"); //
        carregarGerentes("data" + File.separator + "gerentes.txt"); //
    }

    private void carregarClientes(String nomeArquivo) {
        File file = new File(nomeArquivo); //
        if (!file.exists()) { //
            System.out.println("Arquivo de clientes não encontrado, criando um novo: " + nomeArquivo); //
            try { //
                file.getParentFile().mkdirs(); //
                file.createNewFile(); //
            } catch (IOException e) { //
                System.out.println("Erro ao criar arquivo de clientes: " + e.getMessage()); //
            }
            return; //
        }

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) { //
            String linha; //
            while ((linha = br.readLine()) != null) { //
                String[] dados = linha.split(";"); //
                if (dados.length >= 4) { // Certifica-se de que há dados suficientes para cliente base
                    String login = dados[0]; //
                    String senha = dados[1]; //
                    String tipoPessoa = dados[2]; //
                    String nome = dados[3]; //
                    String cpf = dados[4]; //


                    if ("Cliente".equals(tipoPessoa)) { //
                        Cliente cliente = new Cliente(nome, login, cpf, senha); //
                        if (dados.length >= 9) { // Verifica se há dados de endereço
                            Endereco endereco = new Endereco(); //
                            endereco.setRua(dados[5]); //
                            endereco.setNumero(dados[6]); //
                            endereco.setBairro(dados[7]); //
                            endereco.setCidade(dados[8]); //
                            cliente.setEndereco(endereco); //
                        }
                        clientes.add(cliente); //
                    }
                }
            }
        } catch (IOException e) { //
            System.out.println("Erro ao carregar clientes do arquivo: " + e.getMessage()); //
        }
    }

    private void carregarFuncionarios(String nomeArquivo) {
        File file = new File(nomeArquivo); //
        if (!file.exists()) { //
            System.out.println("Arquivo de funcionários não encontrado, criando um novo: " + nomeArquivo); //
            try { //
                file.getParentFile().mkdirs(); //
                file.createNewFile(); //
            } catch (IOException e) { //
                System.out.println("Erro ao criar arquivo de funcionários: " + e.getMessage()); //
            }
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 6) { // login;senha;tipoPessoa;nome;cpf;cargo;turno
                    String login = dados[0];
                    String senha = dados[1];
                    String tipoPessoa = dados[2];
                    String nome = dados[3];
                    String cpf = dados[4];
                    String cargo = dados[5];
                    String turno = dados[6];


                    if ("Funcionário".equals(tipoPessoa)) {
                        funcionarios.add(new Funcionario(nome, login, cpf, cargo, turno, senha));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar funcionários do arquivo: " + e.getMessage());
        }
    }

    private void carregarGerentes(String nomeArquivo) {
        File file = new File(nomeArquivo);
        if (!file.exists()) {
            System.out.println("Arquivo de gerentes não encontrado, criando um novo: " + nomeArquivo);
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro ao criar arquivo de gerentes: " + e.getMessage());
            }
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 5) { // login;senha;tipoPessoa;nome;cpf;cargo;turno
                    String login = dados[0];
                    String senha = dados[1];
                    String tipoPessoa = dados[2];
                    String nome = dados[3];
                    String cpf = dados[4];
                    String turno = dados[5];


                    if ("Gerente".equals(tipoPessoa)) {
                        gerentes.add(new Gerente(nome, login, cpf, turno, senha));
                    }
                }
            }
        } catch (IOException e) { //
            System.out.println("Erro ao carregar gerentes do arquivo: " + e.getMessage()); //
        }
    }
    // SALVAR OS ARQUIVOOOOOS

    private void salvarEmArquivo(String nomeArquivo, Pessoa pessoa) {
        try (FileWriter fw = new FileWriter(nomeArquivo, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            String linha = pessoa.getLogin() + ";" + pessoa.getSenha() + ";" + pessoa.getTipoPessoa();

            if (pessoa instanceof Cliente) { //
                Cliente cliente = (Cliente) pessoa; //
                linha += ";" + cliente.getNome() + ";" + cliente.getCpf(); //
                if (cliente.getEndereco() != null) { //
                    linha += ";" + cliente.getEndereco().getRua() + ";" + cliente.getEndereco().getNumero() + ";" + //
                            cliente.getEndereco().getBairro() + ";" + cliente.getEndereco().getCidade(); //
                } else { //
                    linha += ";;;;"; //
                }
            } else if (pessoa instanceof Funcionario) { //
                Funcionario funcionario = (Funcionario) pessoa; //
                linha += ";" + funcionario.getNome() + ";" + funcionario.getCpf() + ";" + funcionario.getCargo() + ";" + funcionario.getTurno(); //
            } else if (pessoa instanceof Gerente) { //
                Gerente gerente = (Gerente) pessoa; //
                linha += ";" + gerente.getNome() + ";" + gerente.getCpf() + ";" + gerente.getTurno(); //
            }
            bw.write(linha);
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo " + nomeArquivo);
            e.printStackTrace();
        }
    }


    private void salvarListaClientes() {
        try (FileWriter fw = new FileWriter("data/clientes.txt", false);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (Cliente c : clientes) {
                String linha = c.getLogin() + ";" + c.getSenha() + ";" + c.getTipoPessoa() + ";" + c.getNome() + ";" + c.getCpf(); //

                if (c.getEndereco() != null) {
                    linha += ";" + c.getEndereco().getRua() + ";" + c.getEndereco().getNumero() + ";" +
                            c.getEndereco().getBairro() + ";" + c.getEndereco().getCidade();
                } else {
                    linha += ";;;;";
                }

                bw.write(linha);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao salvar lista de clientes.");
            e.printStackTrace();
        }
    }

    private void salvarListaFuncionarios() {
        try (FileWriter fw = new FileWriter("data/funcionarios.txt", false);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (Funcionario f : funcionarios) {
                String linha = f.getLogin() + ";" + f.getSenha() + ";" + f.getTipoPessoa() + ";" + f.getNome() + ";" + f.getCpf() + ";" + f.getCargo() + ";" + f.getTurno(); //
                bw.write(linha);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao salvar lista de funcionários.");
            e.printStackTrace();
        }
    }

    private void salvarListaGerentes() {
        try (FileWriter fw = new FileWriter("data/gerentes.txt", false);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (Gerente g : gerentes) {
                String linha = g.getLogin() + ";" + g.getSenha() + ";" + g.getTipoPessoa() + ";" + g.getNome() + ";" + g.getCpf() + ";" + g.getTurno(); //
                bw.write(linha);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao salvar lista de gerentes.");
            e.printStackTrace();
        }
    }

}

