package src.main.java;

public class Professor implements IEducador {

    private Integer quantAulasSemana;
    private Double valorHoraAula;
    private String nome;

    public Professor(Integer quantAulasSemana, Double valorHoraAula, String nome) {
        this.quantAulasSemana = quantAulasSemana;
        this.valorHoraAula = valorHoraAula;
        this.nome = nome;
    }

    @Override
    public Double getValorBonus() {
        return (quantAulasSemana * valorHoraAula) * 4.5 * 0.15;
    }

    public Integer getQuantAulasSemana() {
        return quantAulasSemana;
    }

    public void setQuantAulasSemana(Integer quantAulasSemana) {
        this.quantAulasSemana = quantAulasSemana;
    }

    public Double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(Double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "quantAulasSemana=" + quantAulasSemana +
                ", valorHoraAula=" + valorHoraAula +
                ", nome='" + nome + '\'' +
                '}';
    }
}
