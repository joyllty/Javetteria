package Model;

public class Funcionario extends Pessoa implements ContaUsuario{

    private String senha;
    private String cargo;
    private String turno;


    public Funcionario(String nome, String login, String cpf, String cargo, String turno, String senha){
        super(nome, login, cpf);
        this.cargo = cargo;
        this.turno = turno;
        this.senha = senha;
    }

    //sets
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    //gets
    public String getCargo() {
        return cargo;
    }

    public String getTurno() {
        return turno;
    }

    @Override
    public String getTipoPessoa(){
        return "Funcionário";
    }

    @Override
    public Pessoa login(String usuario, String senha) {
        if (this.getLogin().equals(usuario) && this.senha.equals(senha)) {
            return this;
        }
        return null;
    }

}
