package sptech.projetojpadtoquery.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.projetojpadtoquery.dominio.Motorista;
import sptech.projetojpadtoquery.resposta.MotoristaSimplesResponse;

import java.util.List;

public interface MotoristaRepository
        extends JpaRepository<Motorista, Integer> {

    /*
@Query -> usamos quando os DynamicFinders não são suficiente
Nela usamos consultas JPQL (padrão) ou SQL Nativo (apenas em casos extremos)
O JPQL é Orientado a Objetos, ou seja, devemos usar os nomes das classes e atributos do código Java e não das tabelas e seus campos

No exemplo abaixo, pedimos para o JPA usar como resultado da consulta
uma instância de MotoristaSimplesResponse criada a partir
dos "id" e "nome" de cada motorista encontrado

     */
    @Query("select new " +
    "sptech.projetojpadtoquery.resposta.MotoristaSimplesResponse" +
    "(m.id, m.nome) from Motorista m where m.suspenso=false")
    // @Query("select m from Motorista m")
    List<MotoristaSimplesResponse> getMotoristasSimples();


}
