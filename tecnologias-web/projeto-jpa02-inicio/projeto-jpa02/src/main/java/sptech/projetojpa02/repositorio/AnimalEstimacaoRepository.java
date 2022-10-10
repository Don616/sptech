package sptech.projetojpa02.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.projetojpa02.dominio.AnimalEstimacao;

import java.util.List;

public interface AnimalEstimacaoRepository
                        extends JpaRepository<AnimalEstimacao, Long> {

    List<AnimalEstimacao> findByCpfDono(String cpf);
    List<AnimalEstimacao> findByCpfDonoContains(String cpf);
    List<AnimalEstimacao> findByCpfDonoContainsAndEmailDonoContains(String cpf);
    List<AnimalEstimacao> findByCpfDonoContainsAndEmailDonoContainsOrderByNome(String cpf);
    List<AnimalEstimacao> findByCpfDonoContainsAndEmailDonoContainsOrderByNomeDesc(String cpf);
}
