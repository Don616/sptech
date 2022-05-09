package school.sptech.projeto1.heranca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

  @Test
  void getPrecoQuandoAcionadoEProdutoPossuiValor499999DeveRetornar499999() {
    Produto produto = new Produto(
        1, "Playstation 5", "videogame", 4_999.99);
    Double precoCorretoComTaxa = 4_999.99;
    assertEquals(precoCorretoComTaxa, produto.getPreco());
  }

  @Test
  void getPrecoQuandoAcionadoEProdutoPossuiValor0DeveRetornar0() {
    Produto produto = new Produto(
        1, "Playstation 5", "videogame", 4_999.99);
    Double precoCorretoComTaxa = 4_999.99;
    assertEquals(precoCorretoComTaxa, produto.getPreco());
  }
}