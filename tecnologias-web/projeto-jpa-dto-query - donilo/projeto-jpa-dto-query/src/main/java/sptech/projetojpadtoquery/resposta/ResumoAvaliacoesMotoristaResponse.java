package sptech.projetojpadtoquery.resposta;

public class ResumoAvaliacoesMotoristaResponse {

    private String nome;

    private Double media;

    private Long avaliacoes;

    public ResumoAvaliacoesMotoristaResponse(String nome, Double media, Long avaliacoes) {
        this.nome = nome;
        this.media = media;
        this.avaliacoes = avaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public Double getMedia() {
        return media;
    }

    public Long getAvaliacoes() {
        return avaliacoes;
    }
}
