package sptech.projetojpadtoquery.controle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import sptech.projetojpadtoquery.repositorio.PassageiroRepository;
import sptech.projetojpadtoquery.resposta.PassageiroSimplesResponse;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PassageiroControllerTest {

    @Autowired
    PassageiroController passageiroController;

    @MockBean
    PassageiroRepository passageiroRepository;

    @Test
    @DisplayName("Testar a paciencia do passageiro")
    void getSimplesCorretoTest(){
        List<PassageiroSimplesResponse> lista = List.of(
                new PassageiroSimplesResponse(1,"Julia"),
                new PassageiroSimplesResponse(2,"Carolina")
        );
        Mockito.when(passageiroRepository.getPassageirosSimples())
                .thenReturn(lista);
        ResponseEntity<List<PassageiroSimplesResponse>> teste =
                passageiroController.getSimples();
        assertEquals(200,teste.getStatusCodeValue());
    }

    @Test
    @DisplayName("Testar a paciencia do passageiro errado")
    void getSimplesErradoTest(){
        List<PassageiroSimplesResponse> lista = new ArrayList<>();
        Mockito.when(passageiroRepository.getPassageirosSimples())
                .thenReturn(lista);
        ResponseEntity<List<PassageiroSimplesResponse>> teste =
                passageiroController.getSimples();
        assertEquals(204,teste.getStatusCodeValue());
    }

}