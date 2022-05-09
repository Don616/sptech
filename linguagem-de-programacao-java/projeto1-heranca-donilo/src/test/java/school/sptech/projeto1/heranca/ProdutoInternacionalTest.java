package school.sptech.projeto1.heranca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoInternacionalTest {

    @Test
    void getPrecoQuandoAcionadoEProdutoPossuiValor499999DeveRetornar799998() {
        ProdutoInternacional prdInternacional = new ProdutoInternacional(
                1, "Playstation 5", "videogame", 4_999.99);
        Double precoCorretoComTaxa = 7_999.9839999999995;
        assertEquals(precoCorretoComTaxa, prdInternacional.getPreco());
    }

    @Test
    void getPrecoQuandoAcionadoEProdutoPossuiValor0DeveRetornar0() {
        ProdutoInternacional prdInternacional = new ProdutoInternacional(
                1, "Playstation 5", "videogame", 0.0);
        Double precoCorretoComTaxa = 0.0;
        assertEquals(precoCorretoComTaxa, prdInternacional.getPreco());
    }

    @Test
    public void getIdQuandoAcionadoDeveRetornarOValorDoId() {
        ProdutoInternacional prdInternacional = new ProdutoInternacional(
                1, "Playstation 5", "videogame", 4_999.99
        );

        assertEquals(1, prdInternacional.getId());
    }

    @Test
    public void getNomeQuandoAcionadoDeveRetornarOValorDoNome() {
        ProdutoInternacional prdInternacional = new ProdutoInternacional(
                1, "Playstation 5", "videogame", 4_999.99
        );

        assertEquals("Playstation 5", prdInternacional.getNome());
    }

    @Test
    public void getCategoriaQuandoAcionadoDeveRetornarOValorDaCategoria() {
        ProdutoInternacional prdInternacional = new ProdutoInternacional(
                1, "Playstation 5", "videogame", 4_999.99
        );

        assertEquals("videogame", prdInternacional.getCategoria());
    }

    @Test
    public void getPrecoQuandoAcionadoDeveRetornarOValorDoPreco() {
        ProdutoInternacional prdInternacional = new ProdutoInternacional(
                1, "Playstation 5", "videogame", 4_999.99
        );

        assertEquals(7_999.9839999999995, prdInternacional.getPreco());
    }
    
    @Test
    public void objetoProdutoInternacionalDeveSerHerdeiraDeProduto() {
        ProdutoInternacional prdInternacional = new ProdutoInternacional(
                1, "Playstation 5", "videogame", 4_999.99
        );

        assertInstanceOf(Produto.class, prdInternacional);
    }
}
