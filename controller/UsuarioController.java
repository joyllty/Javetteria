package controller;

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

    public boolean atualizarCliente(String login, String novoNome, String novoCpf, String novaRua, String novoNumero, String novoBairro, String novaCidade) {
        Cliente cliente = buscarClientePorLogin(login);
        if (cliente != null) {
            cliente.setNome(novoNome);
            cliente.setCpf(novoCpf);

            if (cliente.getEndereco() == null) {
                cliente.setEndereco(new Endereco());
            }

            cliente.getEndereco().setRua(novaRua);
            cliente.getEndereco().setNumero(novoNumero);
            cliente.getEndereco().setBairro(novoBairro);
            cliente.getEndereco().setCidade(novaCidade);

            salvarListaClientes();

            return true;
        }
        return false;
    }

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
            salvarListaFuncionarios();
            return true;
        }
        return false;
    }

    public void adicionarGerente(Gerente gerente) {
        gerentes.add(gerente);
        salvarEmArquivo("data/gerentes.txt", gerente);
    }

    public Gerente buscarGerentePorLogin(String login) {
        for (Gerente g : gerentes) {
            if (g.getLogin().equals(login)) {
                return g;
            }
        }
        return null;
    }

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

        return false;
    }

    public void carregarDadosDosArquivos() {
        carregarClientes("data" + File.separator + "clientes.txt");
        carregarFuncionarios("data" + File.separator + "funcionarios.txt");
        carregarGerentes("data" + File.separator + "gerentes.txt");
    }

    private void carregarClientes(String nomeArquivo) {
        File file = new File(nomeArquivo);
        if (!file.exists()) {
            System.out.println("\nArquivo de clientes não encontrado, criando um novo: " + nomeArquivo);
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("\nErro ao criar arquivo de clientes: " + e.getMessage());
            }
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 4) {
                    String login = dados[0];
                    String senha = dados[1];
                    String tipoPessoa = dados[2];
                    String nome = dados[3];
                    String cpf = dados[4];

                    if ("Cliente".equals(tipoPessoa)) {
                        Cliente cliente = new Cliente(nome, senha, login, cpf);
                        if (dados.length >= 9) {
                            Endereco endereco = new Endereco();
                            endereco.setRua(dados[5]);
                            endereco.setNumero(dados[6]);
                            endereco.setBairro(dados[7]);
                            endereco.setCidade(dados[8]);
                            cliente.setEndereco(endereco);
                        }
                        clientes.add(cliente);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo de clientes: " + e.getMessage());
        }
    }

    private void carregarFuncionarios(String nomeArquivo) {
        File file = new File(nomeArquivo);
        if (!file.exists()) {
            System.out.println("Arquivo de funcionários não encontrado, criando um novo: " + nomeArquivo);
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro ao criar arquivo de funcionários: " + e.getMessage());
            }
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 7) {
                    String login = dados[0];
                    String senha = dados[1];
                    String tipoPessoa = dados[2];
                    String nome = dados[3];
                    String cpf = dados[4];
                    String cargo = dados[5];
                    String turno = dados[6];

                    if ("Funcionario".equals(tipoPessoa)) {
                        Funcionario funcionario = new Funcionario(nome, senha, login, cpf, cargo, turno);
                        funcionarios.add(funcionario);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo de funcionários: " + e.getMessage());
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
                if (dados.length >= 6) {
                    String login = dados[0];
                    String senha = dados[1];
                    String tipoPessoa = dados[2];
                    String nome = dados[3];
                    String cpf = dados[4];
                    String turno = dados[5];

                    if ("Gerente".equals(tipoPessoa)) {
                        Gerente gerente = new Gerente(nome, senha, login, cpf, turno);
                        gerentes.add(gerente);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo de gerentes: " + e.getMessage());
        }
    }

    private void salvarEmArquivo(String nomeArquivo, Pessoa pessoa) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            String linha = pessoa.getLogin() + ";" +
                    pessoa.getSenha() + ";" +
                    pessoa.getTipoPessoa() + ";" +
                    pessoa.getNome() + ";" +
                    pessoa.getCpf();

            if (pessoa instanceof Cliente) {
                Cliente cliente = (Cliente) pessoa;
                if (cliente.getEndereco() != null) {
                    linha += ";" + cliente.getEndereco().getRua() + ";" +
                            cliente.getEndereco().getNumero() + ";" +
                            cliente.getEndereco().getBairro() + ";" +
                            cliente.getEndereco().getCidade();
                }
            } else if (pessoa instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) pessoa;
                linha += ";" + funcionario.getCargo() + ";" + funcionario.getTurno();
            } else if (pessoa instanceof Gerente) {
                Gerente gerente = (Gerente) pessoa;
                linha += ";" + gerente.getTurno();
            }

            writer.write(linha);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar em arquivo: " + e.getMessage());
        }
    }

    private void salvarListaClientes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data" + File.separator + "clientes.txt"))) {
            for (Cliente cliente : clientes) {
                String linha = cliente.getLogin() + ";" +
                        cliente.getSenha() + ";" +
                        cliente.getTipoPessoa() + ";" +
                        cliente.getNome() + ";" +
                        cliente.getCpf();

                if (cliente.getEndereco() != null) {
                    linha += ";" + cliente.getEndereco().getRua() + ";" +
                            cliente.getEndereco().getNumero() + ";" +
                            cliente.getEndereco().getBairro() + ";" +
                            cliente.getEndereco().getCidade();
                }

                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar lista de clientes: " + e.getMessage());
        }
    }

    private void salvarListaFuncionarios() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data" + File.separator + "funcionarios.txt"))) {
            for (Funcionario funcionario : funcionarios) {
                String linha = funcionario.getLogin() + ";" +
                        funcionario.getSenha() + ";" +
                        funcionario.getTipoPessoa() + ";" +
                        funcionario.getNome() + ";" +
                        funcionario.getCpf() + ";" +
                        funcionario.getCargo() + ";" +
                        funcionario.getTurno();

                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar lista de funcionários: " + e.getMessage());
        }
    }

    private void salvarListaGerentes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data" + File.separator + "gerentes.txt"))) {
            for (Gerente gerente : gerentes) {
                String linha = gerente.getLogin() + ";" +
                        gerente.getSenha() + ";" +
                        gerente.getTipoPessoa() + ";" +
                        gerente.getNome() + ";" +
                        gerente.getCpf() + ";" +
                        gerente.getTurno();

                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar lista de gerentes: " + e.getMessage());
        }
    }
}

