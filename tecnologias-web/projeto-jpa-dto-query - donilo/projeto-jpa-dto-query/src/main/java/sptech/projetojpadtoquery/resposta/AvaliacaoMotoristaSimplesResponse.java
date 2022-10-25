package sptech.projetojpadtoquery.resposta;

import org.hibernate.annotations.CreationTimestamp;
import sptech.projetojpadtoquery.dominio.Motorista;
import sptech.projetojpadtoquery.dominio.Passageiro;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

public class AvaliacaoMotoristaSimplesResponse {

    @CreationTimestamp
    private LocalDateTime dataHoraAvaliacao;

    @Min(1)
    @Max(5)
    private Integer nota;

    private Integer idMotorista;

    private Integer idPassageiro;

    public AvaliacaoMotoristaSimplesResponse(LocalDateTime dataHoraAvaliacao, Integer nota, Integer idMotorista, Integer idPassageiro) {
        this.dataHoraAvaliacao = dataHoraAvaliacao;
        this.nota = nota;
        this.idMotorista = idMotorista;
        this.idPassageiro = idPassageiro;
    }

    public LocalDateTime getDataHoraAvaliacao() {
        return dataHoraAvaliacao;
    }

    public Integer getNota() {
        return nota;
    }

    public Integer getIdMotorista() {
        return idMotorista;
    }

    public Integer getIdPassageiro() {
        return idPassageiro;
    }
}
