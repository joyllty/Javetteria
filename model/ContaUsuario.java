package model;

public interface ContaUsuario {
    Pessoa login(String usuario, String senha);

    void alterarSenha(String novaSenha);
}

