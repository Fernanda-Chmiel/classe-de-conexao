package br.com.DTO;

public class UsuarioDTO {
    
    private int id_usuario;
    private String nome_Usuario, login_Usuario, senha_Usuario;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_Usuario() {
        return nome_Usuario;
    }

    public void setNome_Usuario(String nome_Usuario) {
        this.nome_Usuario = nome_Usuario;
    }

    public String getLogin_Usuario() {
        return login_Usuario;
    }

    public void setLogin_Usuario(String login_Usuario) {
        this.login_Usuario = login_Usuario;
    }

    public String getSenha_Usuario() {
        return senha_Usuario;
    }

    public void setSenha_Usuario(String senha_Usuario) {
        this.senha_Usuario = senha_Usuario;
    }
    
    
    
}
