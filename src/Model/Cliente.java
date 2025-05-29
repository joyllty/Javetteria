package Model;

public class Cliente extends Pessoa implements ContaUsuario{

    private Endereco endereco;
    private String senha;

    public Cliente(String nome, String login, String cpf, String senha){
        super(nome, login, cpf);
        this.endereco = new Endereco(); // pra inicializar vazio
        this.senha = senha;

    }

    public Endereco getEndereco(){
        return endereco;
    }


    @Override
    public String getTipoPessoa(){
        return "Cliente";
    }

    @Override
    public Pessoa login(String usuario, String senha){
        if (this.getLogin().equals(usuario) && this.senha.equals(senha)) {
            return this;
        }
    return null;
    }

}
