package sptech.projetojpadtoquery.resposta;

/*
Esta é uma classe que pode ser usada como
uma DTO
 */
public class MotoristaSimplesResponse {

    private int id;
    private String nome;

    // apenas construtor e getters
    public MotoristaSimplesResponse(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
