import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TesteListaEstaticaGenerica {
    @Test
    public void criarListaAlteraTamanhoVetor() {
      ListaObj lista = new ListaObj(3);
      assertEquals(3, lista.getVetor().length);
    }

    @Test
    public void criarListaInicializaTamanho() {
      ListaObj lista = new ListaObj(3);
      assertEquals(0, lista.getTamanho());
    }

    @Test
    public void adicionaAlteraVetor() {
      ListaObj lista = new ListaObj(3);

      lista.adiciona(1);
      lista.adiciona("A");
      lista.adiciona(false);

      assertEquals("A", lista.getVetor()[1]);
    }

    @Test
    public void adicionaAlteraTamanho() {
      ListaObj lista = new ListaObj(3);

      assertEquals(0, lista.getTamanho());

      lista.adiciona(1);

      assertEquals(1, lista.getTamanho());

      lista.adiciona("A");

      assertEquals(2, lista.getTamanho());
    }

    @Test
    public void adicionaValidaListaCheia() {
      ListaObj lista = new ListaObj(3);
      lista.adiciona("A");
      lista.adiciona(2);
      lista.adiciona(false);
      assertThrows(IllegalStateException.class, () -> lista.adiciona(4));
    }

    @Test
    public void buscaQuandoNaoEntrado() {
      ListaObj lista = new ListaObj(3);
      lista.adiciona("A");
      lista.adiciona(2);
      lista.adiciona(false);
      assertEquals(-1, lista.busca(35));

    }

    @Test
    public void buscaQuandoElementoValido() {
      ListaObj lista = new ListaObj(3);
      lista.adiciona(1);
      lista.adiciona("A");
      lista.adiciona(false);
      assertEquals(1, lista.busca("A"));
    }

    @Test
    public void removePeloIndiceQuandoIndiceInvalido() {
      ListaObj lista = new ListaObj(3);
      lista.adiciona(1);
      lista.adiciona("A");
      assertFalse(lista.removePeloIndice(3));
      assertFalse(lista.removePeloIndice(-3));
    }

    @Test
    public void removePeloIndiceQuandoListaCheia() {
    ListaObj lista = new ListaObj(3);
    lista.adiciona(1);
    lista.adiciona("A");
    lista.adiciona(false);
    assertTrue(lista.removePeloIndice(1));
  }

    @Test
    public void removePeloIndiceQuandoIndiceValido() {
      ListaObj lista = new ListaObj(3);
      lista.adiciona(1);
      lista.adiciona("A");
      assertTrue(lista.removePeloIndice(1));
    }

    @Test
    public void removePeloIndiceAlteraTamanho() {
      ListaObj lista = new ListaObj(3);
      lista.adiciona(1);
      lista.adiciona("A");
      lista.removePeloIndice(1);

      assertEquals(1, lista.getTamanho());
    }

    @Test
    public void removePeloIndiceAlteraVetor() {
      ListaObj lista = new ListaObj(3);
      lista.adiciona(1);
      lista.adiciona("A");
      lista.removePeloIndice(0);

      assertEquals("A", lista.getVetor()[0]);
    }

    @Test
    public void removeElementoQuandoElementoInvalido() {
      ListaObj lista = new ListaObj(3);
      lista.adiciona(1);
      lista.adiciona("A");
      assertFalse(lista.removeElemento(3));
      assertFalse(lista.removeElemento("C"));
    }

    @Test
    public void removeElementoQuandoElementoListaCheia() {
      ListaObj lista = new ListaObj(3);
      lista.adiciona(1);
      lista.adiciona("A");
      lista.adiciona(false);
      assertTrue(lista.removeElemento("A"));
    }

    @Test
    public void removeElementoQuandoElementoValido() {
      ListaObj lista = new ListaObj(3);
      lista.adiciona(1);
      lista.adiciona("A");
      assertTrue(lista.removeElemento("A"));
    }

    @Test
    public void removeElementoAlteraTamanho() {
      ListaObj lista = new ListaObj(3);
      lista.adiciona(1);
      lista.adiciona("A");
      lista.removeElemento("A");

      assertEquals(1, lista.getTamanho());
    }

    @Test
    public void removeElementoAlteraVetor() {
      ListaObj lista = new ListaObj(3);
      lista.adiciona(1);
      lista.adiciona("A");
      lista.removeElemento(1);

      assertEquals("A", lista.getVetor()[0]);
    }

    @Test
    public void getTamanho() {
    ListaObj lista = new ListaObj(3);
    lista.adiciona("A");
    lista.adiciona("B");

    assertEquals(2, lista.getTamanho());
  }

    @Test
    public void getTamanhoQuandoListaCheia() {
    ListaObj lista = new ListaObj(3);
    lista.adiciona(1);
    lista.adiciona("A");
    lista.adiciona(false);

    assertEquals(3, lista.getTamanho());
  }

    @Test
    public void getTamanhoQuandoListaVazia() {
    ListaObj lista = new ListaObj(3);
    assertEquals(0, lista.getTamanho());
  }

    @Test
    public void getElemento() {
      ListaObj lista = new ListaObj(3);
      lista.adiciona("A");
      lista.adiciona(1);

      assertEquals("A", lista.getElemento(0));
    }

    @Test
    public void getElementoQuandoListaCheia() {
      ListaObj lista = new ListaObj(3);
      lista.adiciona("A");
      lista.adiciona(1);
      lista.adiciona(false);

      assertEquals("A", lista.getElemento(0));
    }

    @Test
    public void getElementoQuandoListaVazia() {
      ListaObj lista = new ListaObj(3);
      assertEquals(null, lista.getElemento(0));
    }

    @Test
    public void getElementoQuandoIndiceMenorQueZero() {
      ListaObj lista = new ListaObj(3);
      lista.adiciona("A");
      lista.adiciona(1);
      assertEquals(null, lista.getElemento(-2));
    }

    @Test
    public void getElementoQuandoIndiceMaiorQueTamanho() {
    ListaObj lista = new ListaObj(3);
    lista.adiciona("A");
    lista.adiciona(1);
    assertEquals(null, lista.getElemento(2));
  }
}
