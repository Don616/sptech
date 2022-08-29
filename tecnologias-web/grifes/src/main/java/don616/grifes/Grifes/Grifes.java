package don616.grifes.Grifes;

public class Grifes {

    private String nome;
    private Integer anoCriacao;
    private Double valorAcaoBolsa;
    private String chaveAcesso;

    public Grifes(String nome, Integer anoCriacao, Double valorAcaoBolsa, String chaveAcesso) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.valorAcaoBolsa = valorAcaoBolsa;
        this.chaveAcesso = chaveAcesso;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoCriacao() {
        return anoCriacao;
    }

    public Double getValorAcaoBolsa() {
        return valorAcaoBolsa;
    }

}
