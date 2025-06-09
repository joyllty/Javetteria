package Model;

public abstract class Pessoa {

    private String nome;
    private String login;
    private String cpf;
    private String senha;

    public Pessoa(String nome, String login, String cpf, String senha) {
        this.nome = nome;
        this.login = login;
        this.cpf = cpf;
        this.senha = senha; //
    }

    // sets
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

    // gets
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

    // método abstrato
    public abstract String getTipoPessoa();
}
