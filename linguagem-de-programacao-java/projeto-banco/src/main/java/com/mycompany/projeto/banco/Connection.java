
package com.mycompany.projeto.banco;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Don616
 */
public class Connection {
    
    private BasicDataSource dataSource;

    public Connection() {
        
        this.dataSource = new BasicDataSource();
        
        dataSource​.setDriverClassName("org.h2.Driver");
        dataSource​.setUrl("jdbc:h2:file:./meu_banco");
        dataSource​.setUsername("sa");
        dataSource​.setPassword("");
        
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
    
    
    
}
