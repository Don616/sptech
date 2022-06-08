package br.com.sptech.totemsistem;

import org.apache.commons.dbcp2.BasicDataSource;

public class Connection {

    private BasicDataSource dataSource;
    

    public Connection(String local){
        this.dataSource = new BasicDataSource();

        if (local.equals("mysql")) {
            
            
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/totemsystem?useTimezone=true&serverTimezone=UTC");
            //dataSource.setUrl("jdbc:mysql://mysql-totem:3306/totemsystem?useTimezone=true&serverTimezone=UTC");
            dataSource.setUsername("root");
            dataSource.setPassword("root");

        } else if (local.equals("azure")) {
            
            dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dataSource.setUrl("jdbc:sqlserver://totemsystem.database.windows.net"
                    + ":1433;database=TotemSystem;user=svr-totemsystem@totemsystem;"
                    + "password={your_password_here};encrypt=true;"
                    + "trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;"
                    + "loginTimeout=30");
            dataSource.setUsername("svr-totemsystem");
            dataSource.setPassword("2ads#grupo9");
        }

    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }

}
