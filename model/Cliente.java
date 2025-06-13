package model;

public class Cliente extends Pessoa implements ContaUsuario{

    private Endereco endereco;

    public Cliente(String nome, String login, String cpf, String senha){
        super(nome, login, cpf, senha);
        this.endereco = new Endereco(); // pra inicializar vazio

    }

    public Endereco getEndereco(){
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    @Override
    public String getTipoPessoa(){
        return "Cliente";
    }

    @Override
    public Pessoa login(String usuario, String senha){
        if (this.getLogin().equals(usuario) && this.getSenha().equals(senha)) {
            return this;
        }
    return null;
    }

    @Override
    public void alterarSenha(String novaSenha) {
        this.setSenha(novaSenha);
    }


}
