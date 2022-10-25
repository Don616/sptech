package sptech.projetojpadtoquery.resposta;

public class MotoristaSimplesResponse {

    private Integer id;
    private String nome;

    public MotoristaSimplesResponse(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
