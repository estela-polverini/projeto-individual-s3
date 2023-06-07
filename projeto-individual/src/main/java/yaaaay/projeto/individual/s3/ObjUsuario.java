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
    private Integer idFuncionario;
    private Integer idEmpresa;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private Integer computadorAtual;

    public ObjUsuario(Integer idFuncionario, Integer idEmpresa, String nome, String sobrenome, String email, String senha) {
        this.idFuncionario = idFuncionario;
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }
    
    public ObjUsuario() {

    }


    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
    

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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

    public Integer getComputadorAtual() {
        return computadorAtual;
    }

    public void setComputadorAtual(Integer computadorAtual) {
        this.computadorAtual = computadorAtual;
    }

    @Override
    public String toString() {
        return String.format("\nUsuario"
                + "\nidFuncionario: %d"
                + "\nidEmpresa: %d"
                + "\nFuncionário: %s %s"
                + "\nEmail: %s"
                + "\nSenha: %s"
                + "\nComputador sendo usado: %d",idFuncionario, idEmpresa, nome, sobrenome, email, senha, computadorAtual);
    }
}
