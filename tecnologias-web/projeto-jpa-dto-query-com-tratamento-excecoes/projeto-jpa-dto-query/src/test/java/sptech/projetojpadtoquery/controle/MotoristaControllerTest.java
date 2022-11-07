package sptech.projetojpadtoquery.controle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import sptech.projetojpadtoquery.dominio.Motorista;
import sptech.projetojpadtoquery.repositorio.MotoristaRepository;
import sptech.projetojpadtoquery.resposta.MotoristaSimplesResponse;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MotoristaControllerTest {

    @Autowired
    private MotoristaController motoristaController;

    @MockBean
    private MotoristaRepository motoristaRepository;

    @Test
    @DisplayName("Não retorna lista de motorista e o status 204")
    void retornaComFalha(){

        when(motoristaRepository.findAll())
                .thenReturn(new ArrayList<>());
        ResponseEntity<List<Motorista>> listaMotorista = motoristaController.get();
        assertEquals(204,listaMotorista.getStatusCodeValue());
        assertNull(listaMotorista.getBody());

    }

    @Test
    @DisplayName("Retorna uma lista de motorista com status 200")
    void retornaComSucesso(){
        Motorista motorista1 = new Motorista();
        Motorista motorista2 = new Motorista();
        List novaLista = new ArrayList<>();
        novaLista.add(motorista1);
        novaLista.add(motorista2);
        when(motoristaRepository.findAll())
                .thenReturn(novaLista);
        ResponseEntity<List<Motorista>> listaMotorista = motoristaController.get();
        assertEquals(200,listaMotorista.getStatusCodeValue());
        assertTrue(listaMotorista.getBody().size()>0);
    }

    @Test
    @DisplayName("Retorna 200 do motorista simples")
    void retornaComSucessoDoSimples(){

        when(motoristaRepository.getMotoristasSimples())
                .thenReturn(List.of(
                        new MotoristaSimplesResponse(1,"Brandão"),
                        new MotoristaSimplesResponse(2,"Júlio")
                ));
        ResponseEntity<List<MotoristaSimplesResponse>> motoristaSimples = motoristaController
                .getSimples();
        assertEquals(200,motoristaSimples.getStatusCodeValue());


    }

    @Test
    @DisplayName("Retorna 204 porque está vazia")
    void retornaComFalhaDoSimples(){
        when(motoristaRepository.getMotoristasSimples())
                .thenReturn(new ArrayList<>());
        ResponseEntity<List<MotoristaSimplesResponse>> lista = motoristaController.getSimples();
        assertEquals(204,lista.getStatusCodeValue());
        assertNull(lista.getBody());
    }

}