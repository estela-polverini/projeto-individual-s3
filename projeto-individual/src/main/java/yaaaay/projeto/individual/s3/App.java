/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yaaaay.projeto.individual.s3;


import com.github.britooo.looca.api.core.Looca;

import java.util.*;

import org.springframework.jdbc.core.JdbcTemplate;
/**
 *
 * @author teteg
 */
public class App {
    public static void main(String[] args) {
        ConexaoBancoLocal conexaoBanco = new ConexaoBancoLocal();
        JdbcTemplate jdbc =  conexaoBanco.getConnection();
        Scanner leitor01 = new Scanner(System.in);

        Looca looca = new Looca();
        
        Runnable deletarTabela = () -> {
            jdbc.execute("DROP TABLE IF EXISTS Computador_EGP;");
        };
        deletarTabela.run();
        
        Runnable criarTabela = () -> {
            jdbc.execute("""
                         CREATE TABLE Computador_EGP (
                             idComputador INT AUTO_INCREMENT,
                             sistema_operacional VARCHAR(45),
                             modelo VARCHAR(45),
                             total_armazenamento VARCHAR(45),
                             PRIMARY KEY (idComputador)
                         );""");
        };
        criarTabela.run();
        
        System.out.println("Bem vindo ao Sistema Hemera Tech!");
        
        jdbc.update("INSERT INTO Computador_EGP(sistema_operacional, modelo, total_armazenamento) VALUES (?, ?, ?)",
                            looca.getSistema().getSistemaOperacional(), 
                            looca.getSistema().getFabricante(),
                            looca.getGrupoDeDiscos().getTamanhoTotal());
        
        System.out.println("Sua maquina foi cadastrada com sucesso");
        
        System.out.println("""
                           Para prosseguir, digite seu email cadastrado:""");
        String email = leitor01.nextLine();
        
        System.out.println("Agora insira sua senha:");
        String senha = leitor01.nextLine();
        
        
        
        
    }
}
