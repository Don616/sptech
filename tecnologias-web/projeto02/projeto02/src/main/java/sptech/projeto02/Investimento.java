package sptech.projeto02;

import java.util.UUID;

public class Investimento {

    private UUID id = UUID.randomUUID();
    private Double minimo;
    private Double jurosAnuais;
    private String nome;
    private Boolean aberto;


    public UUID getId() {
        return id;
    }

    public Double getMinimo() {
        return minimo;
    }

    public Double getJurosAnuais() {
        return jurosAnuais;
    }

    public String getNome() {
        return nome;
    }

    public Boolean getAberto() {
        return aberto;
    }
}
