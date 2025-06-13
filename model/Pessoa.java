package model;

public abstract class Pessoa {

    private String nome;
    private String login;
    private String cpf;
    private String senha;

    public Pessoa(String nome, String senha, String login, String cpf) {
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) { //
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() { //
        return senha;
    }

    public abstract String getTipoPessoa();
}
