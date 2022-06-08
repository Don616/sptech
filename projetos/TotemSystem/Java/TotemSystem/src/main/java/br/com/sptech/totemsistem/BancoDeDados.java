package br.com.sptech.totemsistem;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TotemSystem
 */
public class BancoDeDados {
    
    Sistema sistema = new Sistema();
    
    public String getDriver(String local) {
        
        String driver = "Local inválido";
        
        if (local.equals("mysql")) {
            return driver = "com.mysql.cj.jdbc.Driver";
        } else {
            return driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        }
    }

    public String getURL(String local) {

        String url = "Local inválido";

        if (local.equals("mysql")) {
            return url = "jdbc:mysql://127.0.0.1:3306/totemsystem?useTimezone=true&serverTimezone=UTC";
            //return url = "jdbc:mysql://mysql-totem:3306/totemsystem?useTimezone=true&serverTimezone=UTC";
        } else if (local.equals("azure")) {
            return url = "jdbc:sqlserver://totemsystem.database.windows.net:1433;"
                    + "database=TotemSystem;user=svr-totemsystem@totemsystem;"
                    + "password={your_password_here};"
                    + "encrypt=true;trustServerCertificate=false;"
                    + "hostNameInCertificate=*.database.windows.net;"
                    + "loginTimeout=30";
        } else {
            return url;
        }
    }

    public String getLogin(String local) {

        String login = "Local inválido";

        if (local.equals("mysql")) {
            return login = "root";
        } else if (local.equals("azure")) {
            return login = "svr-totemsystem";
        } else {
            return login;
        }
    }

    public String getSenha(String local) {

        String senha = "Local inválido";

        if (local.equals("mysql")) {
            return senha = "root";
        } else if (local.equals("azure")) {
            return senha = "2ads#grupo9";
        } else {
            return senha;
        }
    }

    public Integer getIdEstacao(String nomeEstacao, String local) throws SQLException, ClassNotFoundException, IOException {
        
        Class.forName(this.getDriver(local)); /* Aqui registra */
        Connection conexão = DriverManager.getConnection(this.getURL(local), this.getLogin(local), this.getSenha(local));
        

        Integer id = 0;

        PreparedStatement pesquisa = conexão.prepareStatement(String.format
            ("select id_estacao from tb_estacao where nome_estacao = '%s'", nomeEstacao));
        ResultSet resultado = pesquisa.executeQuery();

        while (resultado.next()) {
            try {
                id = Integer.valueOf(resultado.getString("id_estacao"));
            } catch (Exception e) {
                System.out.println("ID está null");
                sistema.logErro("---> ID da estação não encontrado");
            }

        }

        return id;

    }

    public Boolean existeEstacao(String nomeEstacao, String local) throws SQLException, ClassNotFoundException {
        Class.forName(this.getDriver(local)); /* Aqui registra */
        Connection conexão = DriverManager.getConnection(this.getURL(local), this.getLogin(local), this.getSenha(local));

        PreparedStatement pesquisa = conexão.prepareStatement(String.format
        ("select nome_estacao from tb_estacao where nome_estacao = '%s'", nomeEstacao));
        ResultSet resultado = pesquisa.executeQuery();

        if (resultado.next()) {
            return true;
        } else {
            return false;
        }

    }

    public Boolean validarLogin(String email, String senha, String local) throws SQLException, ClassNotFoundException {
        
        Class.forName(this.getDriver(local)); /* Aqui registra */
        Connection conexão = DriverManager.getConnection(this.getURL(local), this.getLogin(local), this.getSenha(local));
        PreparedStatement pesquisa = conexão.prepareStatement
        (String.format("select * from tb_usuario where email = '%s' and  senha = '%s'", email, senha));
        ResultSet resultado = pesquisa.executeQuery();

        if (resultado.next()) {
            return true;
        } else {
            return false;
        }

    }

    public Boolean existeHostname(String local) throws SQLException, ClassNotFoundException {


        Totem totem = new Totem();
        Class.forName(this.getDriver(local)); /* Aqui registra */         
        Connection conexão = DriverManager.getConnection(this.getURL(local), this.getLogin(local), this.getSenha(local));
        PreparedStatement pesquisa = conexão.prepareStatement
        (String.format("select hostname from tb_totem where hostname = '%s'", totem.getHostname()));
        ResultSet resultado = pesquisa.executeQuery();

        if (resultado.next()) {
            return true;
        } else {
            return false;
        }
    }
    
        

}
