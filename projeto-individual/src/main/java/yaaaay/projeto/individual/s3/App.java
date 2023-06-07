/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yaaaay.projeto.individual.s3;


import java.util.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
/**
 *
 * @author teteg
 */
public class App {
    public static void main(String[] args) {
        // ConexaoBancoLocal conexaoBanco = new ConexaoBancoLocal();
        // JdbcTemplate conexao =  conexaoBanco.getConnection();
        
        ConexaoBancoAzure conexaoAzure = new ConexaoBancoAzure();
        JdbcTemplate conexaosql =  conexaoAzure.getConnection();
        
        Scanner leitor = new Scanner(System.in);

        API api = new API();
        LogAcesso log = new LogAcesso();
        
        
        
        System.out.println("Seja bem vindo de volta ao sistema de monitoramento da hemera Tech");
        System.out.println("Email:");
        String emailDigitado = leitor.nextLine();
        System.out.println("Senha:");
        String senhaDigitada = leitor.nextLine();

        try {
            //SELECT PARA AUTENTICAR LOGIN
            String selectUsuario = "select idFuncionario,nome,sobrenome,email,senha,idEmpresa from Funcionario where email= ? and  senha= ?";
            ObjUsuario usuarioLogadoAzure = conexaosql.queryForObject(selectUsuario, new BeanPropertyRowMapper<>(ObjUsuario.class), emailDigitado, senhaDigitada);

            System.out.println(usuarioLogadoAzure);
            // LOGGG
            log.salvar(emailDigitado, true);

            //PUXAR SE EXISTE COMPUTADORES DA EMPRESA COM MACADDRESS 
            String selectComputador = "select idComputador, idEmpresa from Computador where idEmpresa = ? and MacAddress = ?";
            List<Computador> computadoresLogadosAzure = conexaosql.query(selectComputador, new BeanPropertyRowMapper<>(Computador.class), usuarioLogadoAzure.getIdEmpresa(), api.macAddress());
            // List<Computador> computadoresLogadosMySql = conexao.query(selectComputador, new BeanPropertyRowMapper<>(Computador.class), usuarioLogadoAzure.getIdEmpresa(), api.macAddress());
            System.out.println(computadoresLogadosAzure);

            if (computadoresLogadosAzure.isEmpty()) {
                System.out.println("vamos cadastrar esse  computador");
                // FAZER INSERT NA TABELA COMPUTADOR 
                conexaosql.update(String.format("insert into Computador (sistema_operacional, modelo, MacAddress, total_memoria, total_armazenamento, idEmpresa) values ('%s','%s','%s','%s','%s',%d)", api.sistemaOperacional(), api.modeloProcessador(), api.macAddress(), api.totalMemoria(), api.totalDisco(), usuarioLogadoAzure.getIdEmpresa()));
                //conexao.update(String.format("insert into Computador (sistema_operacional, modelo, MacAddress, total_memoria, total_armazenamento, idEmpresa) values ('%s','%s','%s','%s','%s', %d)", api.sistemaOperacional(), api.modeloProcessador(), api.macAddress(), api.totalMemoria(), api.totalDisco(), usuarioLogadoAzure.getIdEmpresa()));

                System.out.println("Cadastrei os computadores!!");

                computadoresLogadosAzure = conexaosql.query(selectComputador, new BeanPropertyRowMapper<>(Computador.class), usuarioLogadoAzure.getIdEmpresa(), api.macAddress());
                log.inserirLoginBanco(usuarioLogadoAzure, computadoresLogadosAzure.get(0));
                System.out.println(computadoresLogadosAzure);

            } else {
                System.out.println("computador já estava cadastrado");
               computadoresLogadosAzure = conexaosql.query(selectComputador, new BeanPropertyRowMapper<>(Computador.class), usuarioLogadoAzure.getIdEmpresa(), api.macAddress());

                log.inserirLoginBanco(usuarioLogadoAzure, computadoresLogadosAzure.get(0));
                System.out.println(computadoresLogadosAzure);

            }

            System.out.println("COMEÇAR A REGISTRAR DADOS A CADA X SEGUNDOS");

            Timer tempo = new Timer();
            tempo.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Computador computadorLogadoAzure = conexaosql.queryForObject(selectComputador, new BeanPropertyRowMapper<>(Computador.class), usuarioLogadoAzure.getIdEmpresa(), api.macAddress());
                    // Computador computadorLogadoMySql = conexao.queryForObject(selectComputador, new BeanPropertyRowMapper<>(Computador.class), usuarioLogadoAzure.getIdEmpresa(), api.macAddress());

                    try {
                        api.inserirDadosAzure(computadorLogadoAzure);
                        // api.inserirDadosMySql(computadorLogadoMySql);
                        System.out.println("INSERI EIN");
                    } catch (Exception e) {
                        System.out.println("Erro ao inserir dados: " + e.getMessage());
                    }
                }
            }, 0, 5000);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Usuário ou senha incorretos");
            log.salvar(emailDigitado, false);
        }

    }
}
