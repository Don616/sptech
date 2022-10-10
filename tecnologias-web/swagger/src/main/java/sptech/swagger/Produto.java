package sptech.swagger;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Produto {

    private String nome;
    private Double precoUnitario;
    private Double quantidadeEstoque;
    private Double valorEmEstoque;

    public Double getValorEmEstoque() {
        return valorEmEstoque;
    }

    public void setValorEmEstoque(Double valorEmEstoque) {
        this.valorEmEstoque = precoUnitario*quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
}
