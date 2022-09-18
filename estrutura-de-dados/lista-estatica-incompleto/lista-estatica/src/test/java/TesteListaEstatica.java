import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TesteListaEstatica {

  @Test
  public void criarListaAlteraTamanhoVetor() {
    ListaEstatica listaEstatica = new ListaEstatica(3);
    assertEquals(3, listaEstatica.getVetor().length);
  }

  @Test
  public void criarListaInicializaNumeroElemento() {
    ListaEstatica listaEstatica = new ListaEstatica(3);
    assertEquals(0, listaEstatica.getNroElem());
  }

  @Test
  public void adicionaAlteraVetor() {
    ListaEstatica listaEstatica = new ListaEstatica(3);

    listaEstatica.adiciona(1);
    listaEstatica.adiciona(4);

    assertEquals(4, listaEstatica.getVetor()[1]);
  }

  @Test
  public void adicionaAlteraNumeroElementos() {
    ListaEstatica listaEstatica = new ListaEstatica(3);

    assertEquals(0, listaEstatica.getNroElem());

    listaEstatica.adiciona(1);
    assertEquals(1, listaEstatica.getNroElem());

    listaEstatica.adiciona(4);
    assertEquals(2, listaEstatica.getNroElem());
    assertEquals(4, listaEstatica.getVetor()[1]);
  }

  @Test
  public void adicionaValidaListaCheia() {
    ListaEstatica listaEstatica = new ListaEstatica(3);
    listaEstatica.adiciona(1);
    listaEstatica.adiciona(2);
    listaEstatica.adiciona(3);
    assertThrows(IllegalStateException.class, () -> listaEstatica.adiciona(4));
  }

  @Test
  public void buscaQuandoNaoEntrado() {
    ListaEstatica listaEstatica = new ListaEstatica(3);
    listaEstatica.adiciona(10);
    listaEstatica.adiciona(20);
    listaEstatica.adiciona(30);
    assertEquals(-1, listaEstatica.busca(35));

  }

  @Test
  public void buscaQuandoNumeroValido() {
    ListaEstatica listaEstatica = new ListaEstatica(3);
    listaEstatica.adiciona(10);
    listaEstatica.adiciona(20);
    listaEstatica.adiciona(30);
    assertEquals(2, listaEstatica.busca(30));
  }

  @Test
  public void removePeloIndiceQuandoIndiceInvalido() {
    ListaEstatica listaEstatica = new ListaEstatica(3);
    listaEstatica.adiciona(10);
    listaEstatica.adiciona(20);
    listaEstatica.adiciona(30);
    assertFalse(listaEstatica.removePeloIndice(3));
    assertFalse(listaEstatica.removePeloIndice(-3));
  }

  @Test
  public void removePeloIndiceQuandoIndiceValido() {
    ListaEstatica listaEstatica = new ListaEstatica(3);
    listaEstatica.adiciona(10);
    listaEstatica.adiciona(20);
    listaEstatica.adiciona(30);
    assertTrue(listaEstatica.removePeloIndice(2));
  }

  @Test
  public void removePeloIndiceAlteraNumeroElemento() {
    ListaEstatica listaEstatica = new ListaEstatica(3);
    listaEstatica.adiciona(10);
    listaEstatica.adiciona(20);
    listaEstatica.adiciona(30);
    listaEstatica.removePeloIndice(2);

    assertEquals(2, listaEstatica.getNroElem());
  }

  @Test
  public void removePeloIndiceAlteraVetor() {
    ListaEstatica listaEstatica = new ListaEstatica(3);
    listaEstatica.adiciona(10);
    listaEstatica.adiciona(20);
    listaEstatica.adiciona(30);
    listaEstatica.removePeloIndice(0);

    assertEquals(20, listaEstatica.getVetor()[0]);
  }

  @Test
  public void removeElementoQuandoElementoInvalido() {
    ListaEstatica listaEstatica = new ListaEstatica(3);
    listaEstatica.adiciona(10);
    listaEstatica.adiciona(20);
    listaEstatica.adiciona(30);
    assertFalse(listaEstatica.removeElemento(3));
    assertFalse(listaEstatica.removeElemento(-3));
  }

  @Test
  public void removeElementoQuandoElementoValido() {
    ListaEstatica listaEstatica = new ListaEstatica(3);
    listaEstatica.adiciona(10);
    listaEstatica.adiciona(20);
    listaEstatica.adiciona(30);
    assertTrue(listaEstatica.removeElemento(10));
  }

  @Test
  public void removeElementoAlteraNumeroElemento() {
    ListaEstatica listaEstatica = new ListaEstatica(3);
    listaEstatica.adiciona(10);
    listaEstatica.adiciona(20);
    listaEstatica.adiciona(30);
    listaEstatica.removeElemento(10);

    assertEquals(2, listaEstatica.getNroElem());
  }

  @Test
  public void removeElementoAlteraVetor() {
    ListaEstatica listaEstatica = new ListaEstatica(3);
    listaEstatica.adiciona(10);
    listaEstatica.adiciona(20);
    listaEstatica.adiciona(30);
    listaEstatica.removeElemento(10);

    assertEquals(20, listaEstatica.getVetor()[0]);
  }

}
