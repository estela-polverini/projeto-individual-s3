/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yaaaay.projeto.individual.s3;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class ConexaoBancoLocal {
         private JdbcTemplate connection;

    public ConexaoBancoLocal() {

        BasicDataSource dataSource = new BasicDataSource();

        
        dataSource​.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource​.setUrl("jdbc:mysql://35.171.157.68:3306/hemera");
        //dataSource​.setUrl("jdbc:mysql://3.83.86.248:3306/hemeratech?serverTimezone=America/Sao_Paulo");

        dataSource​.setUsername("root");
        dataSource​.setPassword("hemeratech");

        this.connection = new JdbcTemplate(dataSource);

    }

    public JdbcTemplate getConnection() {

        return connection;

    }
}
