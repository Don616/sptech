package src.main.java;

public class Coordenador implements IEducador {

    private Integer quantHorasCordSemana;
    private Double valorHoraCord;
    private String nome;

    public Coordenador(Integer quantHorasCordSemana, Double valorHoraCord, String nome) {
        this.quantHorasCordSemana = quantHorasCordSemana;
        this.valorHoraCord = valorHoraCord;
        this.nome = nome;
    }

    @Override
    public Double getValorBonus() {
        return (quantHorasCordSemana * valorHoraCord) * 4.5 * 0.2;
    }

    public Integer getQuantHorasCordSemana() {
        return quantHorasCordSemana;
    }

    public void setQuantHorasCordSemana(Integer quantHorasCordSemana) {
        this.quantHorasCordSemana = quantHorasCordSemana;
    }

    public Double getValorHoraCord() {
        return valorHoraCord;
    }

    public void setValorHoraCord(Double valorHoraCord) {
        this.valorHoraCord = valorHoraCord;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Coordenador{" +
                "quantHorasCordSemana=" + quantHorasCordSemana +
                ", valorHoraCord=" + valorHoraCord +
                ", nome='" + nome + '\'' +
                '}';
    }
}
