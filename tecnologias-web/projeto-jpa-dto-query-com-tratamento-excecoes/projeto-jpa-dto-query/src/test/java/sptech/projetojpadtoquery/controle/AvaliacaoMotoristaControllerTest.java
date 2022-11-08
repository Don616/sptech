package sptech.projetojpadtoquery.controle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import sptech.projetojpadtoquery.repositorio.AvaliacaoMotoristaRepository;

import java.time.LocalDateTime;
import java.util.Optional;


@SpringBootTest
class AvaliacaoMotoristaControllerTest {

    @Autowired
    private AvaliacaoMotoristaController avaliacaoMotoristaController;

    @MockBean
    private AvaliacaoMotoristaRepository avaliacaoMotoristaRepository;

    @Test
    @DisplayName("Verifica média de avaliação presente")
    void mediaAvaliacaoExiste(){

        when(avaliacaoMotoristaRepository.getMediaAvaliacoes(anyInt()))
                .thenReturn(Optional.of(25.0));

        ResponseEntity<Double> teste = avaliacaoMotoristaController
                .getMediaAvaliacoes(1);

        assertEquals(200,teste.getStatusCodeValue());
        assertNotNull(teste.getBody());

    }

    @Test
    @DisplayName("Verifica média de avaliação não presente")
    void mediaAvaliacaoNaoExiste(){

        when(avaliacaoMotoristaRepository.getMediaAvaliacoes(anyInt()))
                .thenReturn(Optional.empty());

        ResponseEntity<Double> teste = avaliacaoMotoristaController
                .getMediaAvaliacoes(1);

        assertEquals(404,teste.getStatusCodeValue());
        assertNull(teste.getBody());

    }

    @Test
    @DisplayName("Teste de nota recente")
    void mediaAvaliacaoRecenteExiste(){
        LocalDateTime ha6Meses = LocalDateTime.now().minusMonths(6);
        when(avaliacaoMotoristaRepository.getMediaAvaliacoes(anyInt(),ha6Meses));


    }
}