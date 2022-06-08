package br.com.sptech.totemsistem;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ValidacaoLogin {

    Connection configAZURE = new Connection("azure");
    JdbcTemplate templateAZURE = new JdbcTemplate(configAZURE.getDataSource());
    

    public Boolean validarLogin(String email, String senha) {
        Boolean resposta = false;
        List<Usuario> listarUsuario;
        listarUsuario = templateAZURE.query("select * from tb_usuario where email = ? and  senha = ?",
                new BeanPropertyRowMapper<>(Usuario.class), email, senha);

        if (!listarUsuario.isEmpty()) {
            resposta = true;
        }

        return resposta;
    }

    public Boolean existeHostname() {
        
        Boolean resposta = false;
        
        Totem totem = new Totem();
        List<Totem> queryTotem;
        queryTotem = templateAZURE.query("select hostname from tb_totem where hostname = ?",
                new BeanPropertyRowMapper<>(Totem.class), totem.getHostname());

        if (!queryTotem.isEmpty()) {
            resposta = true;
        }

        return resposta;

    }
    
 
}