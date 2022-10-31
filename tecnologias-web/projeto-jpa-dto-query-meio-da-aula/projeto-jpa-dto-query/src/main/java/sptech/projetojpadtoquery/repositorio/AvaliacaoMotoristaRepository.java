package sptech.projetojpadtoquery.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.projetojpadtoquery.dominio.AvaliacaoMotorista;
import sptech.projetojpadtoquery.resposta.ResumoAvaliacoesMotoristaResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AvaliacaoMotoristaRepository extends JpaRepository<AvaliacaoMotorista, Integer> {

    /*
Aqui temos uma JPQL com 1 parâmetro
No JPQL os parâmetros começam de 1
No exemplo abaixo, o ?1 será substituído por 'idMotorista'

Não é necessário usar aspas nos parâmetros
     */
    @Query("select avg(am.nota) from AvaliacaoMotorista am where am.motorista.id = ?1")
    // @Query("SELECT AVG(am.nota) FROM AvaliacaoMotorista am WHERE am.motorista.id = ?1")
    Optional<Double> getMediaAvaliacoes(int idMotorista);

    @Query("select avg(am.nota) from AvaliacaoMotorista am where " +
            " am.motorista.id = ?1 and am.dataHoraAvaliacao >= ?2 ")
    Optional<Double> getMediaAvaliacoes(
            int idMotorista, LocalDateTime aPartirDe);

    @Query("select new " +
    " sptech.projetojpadtoquery.resposta.ResumoAvaliacoesMotoristaResponse(am.motorista.nome, avg(am.nota), count(am.id)) " +
    " from AvaliacaoMotorista am where am.motorista.id = ?1 " +
    " group by am.motorista.id")
    Optional<ResumoAvaliacoesMotoristaResponse>
                getResumoAvaliacoesMotorista(int idMotorista);

    @Query("select new " +
    " sptech.projetojpadtoquery.resposta.ResumoAvaliacoesMotoristaResponse(am.motorista.nome, avg(am.nota), count(am.id)) " +
    " from AvaliacaoMotorista am where am.motorista.id = ?1 and am.dataHoraAvaliacao >= ?2 " +
    " group by am.motorista.id")
    Optional<ResumoAvaliacoesMotoristaResponse> getResumoAvaliacoesMotorista(int idMotorista, LocalDateTime aPartirDe);

    List<AvaliacaoMotorista> findByMotoristaId(int idMotorista);

    List<AvaliacaoMotorista> findByPassageiroId(int idMotorista);

}
