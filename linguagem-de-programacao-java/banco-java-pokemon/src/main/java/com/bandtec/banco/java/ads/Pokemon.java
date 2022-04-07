
package com.bandtec.banco.java.ads;

/**
 *
 * @author Don616
 */
public class Pokemon {
    
    private Integer id;
    private String nome;
    private String tipo;

    public Pokemon(Integer id, String nome,String tipo) {
        
        this.setId(id);
        this.setNome(nome);
        this.setTipo(tipo);
    }

    public Pokemon() {
    }
    
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "\nPokemon:" + "\nId: " + id + "\nNome: " + nome + "\nTipo: " + tipo;
    }
    
    
}
