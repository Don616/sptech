package sptech.projetojpa02.dominio;

import net.bytebuddy.implementation.bind.annotation.Empty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity // do pacote javax.persistence
public class AnimalEstimacao {

    @Id // do pacote javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank  // do pacote javax.validation
    @Length(min = 3, max = 20)
    private String nome;

    // @Past
    @PastOrPresent
    @NotNull  // do pacote javax.validation
    private LocalDate dataNascimento;

    // @PositiveOrZero
    @Positive
    @Max(60)
    private Double peso;

    private boolean castrado;

    @CPF
    @Size(max = 11) // caso seja obrigatório mandar só os números
    private String cpfDono;

    @Email
    private String emailDono;

    @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})"
            , message = "Informe um telefone válido com ou sem DDD")
    private String telefoneDono; // (XX)XXXX-XXXXX // REGEX
    // https://medium.com/@igorrozani/criando-uma-express%C3%A3o-regular-para-telefone-fef7a8f98828

    /*
    @NotNull
    @Size(min = 1, max = 10)
    private List<String> palavrasChave;
     */

    public String getTelefoneDono() {
        return telefoneDono;
    }

    public void setTelefoneDono(String telefoneDono) {
        this.telefoneDono = telefoneDono;
    }

    public String getEmailDono() {
        return emailDono;
    }

    public void setEmailDono(String emailDono) {
        this.emailDono = emailDono;
    }

    public String getCpfDono() {
        return cpfDono;
    }

    public void setCpfDono(String cpfDono) {
        this.cpfDono = cpfDono;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }
}
