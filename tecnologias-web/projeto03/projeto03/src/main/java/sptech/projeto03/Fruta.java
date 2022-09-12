package sptech.projeto03;

import java.math.BigDecimal;
import java.util.UUID;

public class Fruta {

    private UUID id = UUID.randomUUID();
    private String nome;
    private Double preco;

    public Fruta() {
    }

    public Fruta(String nome, Double preco){
        this.nome = nome;
        this.preco = preco;
    }



    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }
}
