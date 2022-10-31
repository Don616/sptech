package sptech.projetojpadtoquery.requisicao;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class NovaAvaliacaoRequest {

    @Min(1)
    private int idPassageiro;
    @Min(1)
    private int idMotorista;

    @Min(1)
    @Max(5)
    private int nota;

    public int getIdPassageiro() {
        return idPassageiro;
    }

    public int getIdMotorista() {
        return idMotorista;
    }

    public int getNota() {
        return nota;
    }
}
