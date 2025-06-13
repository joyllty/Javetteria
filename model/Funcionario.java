package model;

public class Funcionario extends Pessoa implements ContaUsuario{

    private String cargo;
    private String turno;


    public Funcionario(String nome,String senha, String login, String cpf, String cargo, String turno){
        super(nome, senha, login, cpf);
        this.cargo = cargo;
        this.turno = turno;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCargo() {
        return cargo;
    }

    public String getTurno() {
        return turno;
    }

    @Override
    public String getTipoPessoa(){
        return "Funcionario";
    }

    @Override
    public Pessoa login(String usuario, String senha) {
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
