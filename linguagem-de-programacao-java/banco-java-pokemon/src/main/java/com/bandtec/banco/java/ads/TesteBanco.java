package com.bandtec.banco.java.ads;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Don616
 */
public class TesteBanco {

    public static void main(String[] args) {
        //Esse objeto guarda as cofiguração do banco de dados
        Connetion config = new Connetion();

        JdbcTemplate template = new JdbcTemplate(config.getDataSource());

        template.execute("DROP TABLE IF EXISTS pokemon");

        String criacaoTabelaPokemon = "CREATE TABLE pokemon("
                + "id INT PRIMARY KEY AUTO_INCREMENT,"
                + "nome VARCHAR(255),"
                + "tipo VARCHAR(255)"
                + ")";

        template.execute(criacaoTabelaPokemon);

        String cadastroPKM = "INSERT INTO pokemon"
                + "(nome, tipo)VALUES "
                + "('Pikachu','Eletrico'),"
                + "('SNORLAX','COMUM'),"
                + "('SLOWBRO','ÁGUA'),"
                + "('CHARMANDER','FOGO'),"
                + "('Articuno','Gelo')";

        template.execute(cadastroPKM);

        List<Pokemon> listaPokemon1 = template.query("select * from pokemon", new BeanPropertyRowMapper<>(Pokemon.class));
        List<Pokemon> mostrarFogo = template.query("SELECT NOME FROM POKEMON WHERE TIPO = 'FOGO'", new BeanPropertyRowMapper<>(Pokemon.class));
        //System.out.println(listaPokemon1);
        //System.out.println(mostrarFogo);

        for (Pokemon item : listaPokemon1) {
            System.out.println(item);
        }
        //System.out.println("Mostrando fogo");
        for (Pokemon item : mostrarFogo) {
            System.out.println(item);
        }

        //System.out.println(mostrarFogo);
    }
}
