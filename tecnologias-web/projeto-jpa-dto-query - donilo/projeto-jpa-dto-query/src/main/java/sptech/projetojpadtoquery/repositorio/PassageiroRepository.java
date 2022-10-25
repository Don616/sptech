package sptech.projetojpadtoquery.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import sptech.projetojpadtoquery.dominio.Motorista;
import sptech.projetojpadtoquery.dominio.Passageiro;
import sptech.projetojpadtoquery.requisicao.DesativaPassageiroRequest;
import sptech.projetojpadtoquery.resposta.PassageiroSimplesResponse;

import java.util.List;

public interface PassageiroRepository extends JpaRepository<Passageiro, Integer> {

    @Query("select new sptech.projetojpadtoquery.resposta.PassageiroSimplesResponse(p.id,p.nome) from Passageiro p")
    List<PassageiroSimplesResponse> getPassageirosSimples();

    /*
    @Modifying
    @Query("update new sptech.projetojpadtoquery.dominio.Passageiro from Passageiro p"+
    "set p.suspenso=true where p.id =?1")
    Boolean desativaPassageiro(int idPassageiro);
    */

}
