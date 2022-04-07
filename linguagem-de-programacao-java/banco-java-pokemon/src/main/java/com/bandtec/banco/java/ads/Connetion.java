package com.bandtec.banco.java.ads;

import org.apache.commons.dbcp2.BasicDataSource;

public class Connetion {

    private BasicDataSource dataSource;

    public Connetion() {
        dataSource = new BasicDataSource();
        dataSource​.setDriverClassName("org.h2.Driver");
        dataSource​.setUrl("jdbc:h2:file:./meu_banco");
        dataSource​.setUsername("sa");
        dataSource​.setPassword("");
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
}
