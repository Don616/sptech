package school.sptech.projeto1.heranca;

public class ProdutoInternacional extends Produto {

    public ProdutoInternacional(Integer id, String nome, String categoria, Double preco) {
        super(id, nome, categoria, preco);
    }

    @Override
    public Double getPreco() {

        Double acrescimo = super.getPreco() * 0.6;
        Double precoInternacional = super.getPreco() + acrescimo;
        return precoInternacional;
    }

    /*
        Essa classe deve ser herdeira de produto;
        O método "getPreco" (getter padrão) deverá ser sobreescrito e possuir um acréscimo de 
        60%;
    */   
        
    
}
