package model;

public class Gerente extends Pessoa implements ContaUsuario{

    private String turno;


    public Gerente(String nome, String login, String cpf, String turno, String senha){
        super(nome, login, cpf, senha);
        this.turno = turno;
    }

    //sets

    public void setTurno(String turno) {
        this.turno = turno;
    }

    //gets

    public String getTurno() {
        return turno;
    }

    @Override
    public String getTipoPessoa(){
        return "Gerente";
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
