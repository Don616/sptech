package sptech.projetojpadtoquery.resposta;

public class PassageiroSimplesResponse {

    private Integer id;
    private String nome;

    public PassageiroSimplesResponse(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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
}
