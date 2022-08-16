package src.main.java;

public class Coordenador implements IEducador {

    private Integer quantHorasCordSemana;
    private Double valorHoraCord;
    private String nome;



    @Override
    public Double getValorBonus() {
        return (quantHorasCordSemana * valorHoraCord) * 4.5 * 0.2;
    }
}
