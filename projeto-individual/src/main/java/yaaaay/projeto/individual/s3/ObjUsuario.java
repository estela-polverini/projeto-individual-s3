/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yaaaay.projeto.individual.s3;

/**
 *
 * @author teteg
 */
public class ObjUsuario {
    private String email;
    private String senha;

    public ObjUsuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public ObjUsuario() {
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
