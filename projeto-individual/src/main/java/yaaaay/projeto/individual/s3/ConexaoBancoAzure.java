/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yaaaay.projeto.individual.s3;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author teteg
 */
public class ConexaoBancoAzure {
    private JdbcTemplate connection;
   public void ConexaoBanco() {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

//     dataSource​.setUrl("jdbc:h2:file:/banco_teste");
//jdbc:sqlserver://hemeratech.database.windows.net:1433;database=hemeratech;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;

        dataSource.setUrl("jdbc:sqlserver://hemeratech.database.windows.net:1433;database=hemeratech;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;");
    //("jdbc:mysql://localhost:3306/teste123")

        dataSource.setUsername("hemeratech");

        dataSource.setPassword("#Gfgrupo7");  

    this.connection = new JdbcTemplate(dataSource);

}

    public JdbcTemplate getConnection() {

        return connection;

    }
}
