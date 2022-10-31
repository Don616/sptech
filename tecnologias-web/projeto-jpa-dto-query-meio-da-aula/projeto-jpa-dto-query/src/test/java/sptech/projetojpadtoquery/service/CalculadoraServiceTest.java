package sptech.projetojpadtoquery.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {

    CalculadoraService service = new CalculadoraService();

    @Test
    @DisplayName("calcularPrecoCorrida() deve Calcular Corretamente")
    void calcularPrecoCorrida_deveCalcularCorretamente() {

        double resultado1 = service.calcularPrecoCorrida(2.0);
        double resultado2 = service.calcularPrecoCorrida(3.0);

        assertEquals(24.0,resultado1);
        assertEquals(36.0,resultado2);
    }

    @Test
    @DisplayName("calcularPrecoCorrida() deve lançar exceção p/ km errada")
    void calcularPrecoCorrida_deveLancarExcecaoParaKmErrada(){

        assertThrows(ResponseStatusException.class,
                ()->service.calcularPrecoCorrida(-3.5));
        assertThrows(ResponseStatusException.class,
                ()->service.calcularPrecoCorrida(null));
    }

    @Test
    @DisplayName("calcularPrecoCorrida() deve lançar exceção p/ km errada")
    void calcularPrecoCorrida_kmInvalidoDetalhes() {

        ResponseStatusException excecao =
                assertThrows(ResponseStatusException.class,
                () -> service.calcularPrecoCorrida(-3.5));

        assertEquals("Distancia deve ser >=0",excecao.getReason());
        assertEquals(400,excecao.getRawStatusCode());

        ResponseStatusException excecao2 =
                assertThrows(ResponseStatusException.class,
                        () -> service.calcularPrecoCorrida(null));

        assertEquals("Distancia não deve ser null",excecao2.getReason());
        assertEquals(400,excecao2.getRawStatusCode());

    }

    @Test
    @DisplayName("Calculadora Service anotada com @Service")
    void testarAnotacaoDeArrobaService(){
        Class classe = service.getClass();
        assertTrue(classe.isAnnotationPresent(Service.class),"A anotação" +
                "@Service não foi encontrada");
    }
}