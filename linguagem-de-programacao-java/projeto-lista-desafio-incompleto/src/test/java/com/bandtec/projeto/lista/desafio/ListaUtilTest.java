
package com.bandtec.projeto.lista.desafio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaUtilTest {

    @Test
    public void testAddQuandoAcionadoComValorPositivosENegativosAumentaTamanhoDaLista() {
        System.out.println("ADD COM VALOR VÁLIDO:");
        ListaUtil instance = new ListaUtil();
        instance.add(1);
        instance.add(21);
        instance.add(-21);
        Integer valorRetornado = instance.count();
        assertEquals(3, valorRetornado);
    }
    
    @Test
    public void testAddQuandoAcionadoComArgumentoNuloNaoAlteraTamanhoDaLista() {
        System.out.println("ADD COM VALOR INVÁLIDO:");
        Integer valor = null;
        ListaUtil instance = new ListaUtil();
        instance.add(valor);
        Integer valorRetornado = instance.count();
        assertEquals(0, valorRetornado);
    }

    @Test
    public void testRemoveQuandoAcionadoComArgumentoNuloNaoAlteraTamanhoDaLista() {
        System.out.println("REMOVE COM VALOR INVÁLIDO");
        ListaUtil instance = new ListaUtil();
        instance.add(10);
        instance.add(30);
        instance.add(40);
        assertEquals(3, instance.count());
        instance.remove(null);
        assertEquals(3, instance.count());
    }
    
    @Test
    public void testRemoveQuandoAcionadoComArgumento10DiminuiTamanhoDaLista() {
        System.out.println("REMOVE COM VALOR VÁLIDO");
        ListaUtil instance = new ListaUtil();
        instance.add(10);
        instance.add(30);
        instance.add(40);
        assertEquals(3, instance.count());
        instance.remove(10);
        assertEquals(2, instance.count());
    }
    
    @Test
    public void testRemoveQuandoAcionadoComArgumento101NaoDiminuiTamanhoDaLista() {
        System.out.println("REMOVE COM VALOR INEXISTENTE");
        ListaUtil instance = new ListaUtil();
        instance.add(10);
        instance.add(30);
        instance.add(40);
        assertEquals(3, instance.count());
        instance.remove(101);
        assertEquals(3, instance.count());
    }
    
    @Test
    public void testCountQuandoAcionadoEListaEstaVaziaRetorna0() {
        System.out.println("TESTE COUNT: LISTA VAZIA");
        ListaUtil instance = new ListaUtil();
        Integer result = instance.count();
        assertEquals(0, result);
    }
    
    @Test
    public void testCountQuandoAcionadoEListaPossui3IndicesPreenchidosRetorna3() {
        System.out.println("TESTE COUNT: 3 NUMEROS");
        ListaUtil instance = new ListaUtil();
        instance.add(1);
        instance.add(2);
        instance.add(3);
        Integer result = instance.count();
        assertEquals(3, result);
    }

    
    @Test
    public void testCountParesQuandoAcionadoEListaPossui6ParesRetorna6() {
        System.out.println("TESTE COUNT PARES: 6 NUMEROS");
        ListaUtil instance = new ListaUtil();
        instance.add(2);
        instance.add(4);
        instance.add(6);
        instance.add(12);
        instance.add(24);
        instance.add(32);
        instance.add(101);
        instance.add(-1);
        Integer result = instance.countPares();
        assertEquals(6, result);
    }
    
    @Test
    public void testCountParesQuandoAcionadoEListaEstaVaziaRetorna0() {
        System.out.println("TESTE COUNT PARES: LISTA VAZIA");
        ListaUtil instance = new ListaUtil();
        Integer result = instance.countPares();
        assertEquals(0, result);
    }

    @Test
    public void testCountImparesQuandoAcionadoEListaEstaVaziaRetorna0() {
        System.out.println("TESTE COUNT IMPARES: LISTA VAZIA");
        ListaUtil instance = new ListaUtil();
        Integer result = instance.countImpares();
        assertEquals(0, result);
    }
    
    @Test
    public void testCountImparesQuandoAcionadoEListaPossui3ImparesRetorna3() {
        System.out.println("TESTE COUNT IMPARES: 3 NUMEROS");
        ListaUtil instance = new ListaUtil();
        instance.add(3);
        instance.add(9);
        instance.add(131);
        instance.add(32);
        instance.add(40);
        Integer result = instance.countImpares();
        assertEquals(3, result);
    }

    @Test
    public void testSomarQuandoAcionadoDeveRetornar42() {
        System.out.println("TESTE SOMAR: 42");
        ListaUtil instance = new ListaUtil();
        instance.add(30);
        instance.add(10);
        instance.add(2);
        Integer result = instance.somar();
        assertEquals(42, result);
    }

        @Test
    public void testSomarQuandoAcionadoEListaEstavaziaDeveRetornar0() {
        System.out.println("TESTE SOMAR: LISTA VAZIA");
        ListaUtil instance = new ListaUtil();
        Integer result = instance.somar();
        assertEquals(0, result);
    }
    
    @Test
    public void testGetMaiorQuandoAcionadoEListaEstaVaziaDeveRetornar0() {
        System.out.println("TESTE GETMAIOR: LISTA VAZIA");
        ListaUtil instance = new ListaUtil();
        Integer result = instance.getMaior();
        assertEquals(0, result);
    }
    
    @Test
    public void testGetMaiorQuandoAcionadoDeveRetornar42() {
        System.out.println("TESTE GETMAIOR: 42");
        ListaUtil instance = new ListaUtil();
        instance.add(-5);
        instance.add(11);
        instance.add(37);
        instance.add(42);
        instance.add(16);
        Integer result = instance.getMaior();
        assertEquals(42, result);
    }

    @Test
    public void testGetMenorQuandoAcionadoEListaEstaVaziaDeveRetornar0() {
        System.out.println("TESTE GETMENOR: LISTA VAZIA");
        ListaUtil instance = new ListaUtil();
        Integer result = instance.getMenor();
        assertEquals(0, result);
    }

    @Test
    public void testGetMenorQuandoAcionadoDeveRetornar10Negativo() {
        System.out.println("TESTE GETMENOR: COM -10");
        ListaUtil instance = new ListaUtil();
        
        instance.add(12);
        instance.add(2);
        instance.add(101);
        instance.add(-10);
        instance.add(-2);
        instance.add(5);
        instance.add(32);
        Integer result = instance.getMenor();
        assertEquals(-10, result);
    }
    
    @Test
    public void testHasDuplicidadeQuandoAcionadoEListaPossuiDuplicidadeDeveRetornarTrue() {
        System.out.println("TESTE HASDUPLICIDADE: COM DUPLICIDADE");
        ListaUtil instance = new ListaUtil();
        
        instance.add(13);
        instance.add(10);
        instance.add(42);
        instance.add(18);
        instance.add(32);
        instance.add(42);
        instance.add(102);

        assertTrue(instance.hasDuplicidade());
    }
    
    @Test
    public void testHasDuplicidadeQuandoAcionadoEListaNaoPossuiDuplicidadeDeveRetornarFalse() {
        System.out.println("TESTE HASDUPLICIDADE: SEM DUPLICIDADE");
        ListaUtil instance = new ListaUtil();
        
        instance.add(42);
        instance.add(10);
        instance.add(18);
        instance.add(32);
        instance.add(65);
        instance.add(51);
        
        assertFalse(instance.hasDuplicidade());
    }
    
    @Test
    public void testHasDuplicidadeQuandoAcionadoEListaEstaVaziaDeveRetornarFalse() {
        System.out.println("TESTE HASDUPLICIDADE: LISTA VAZIA");
        ListaUtil instance = new ListaUtil();
        assertFalse(instance.hasDuplicidade());
    }
}
