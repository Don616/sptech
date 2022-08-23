package sptech.projeto02;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Cantores {

    private  Integer id;
    private String nome;
    private String categoria;
    private Double cache;
    private Boolean constaNoSpotfy;
    @JsonIgnore
    private String senha;

    public String getSenha() {
        return senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public Double getCache() {
        return cache;
    }

    public Boolean getConstaNoSpotfy() {
        return constaNoSpotfy;
    }
}
