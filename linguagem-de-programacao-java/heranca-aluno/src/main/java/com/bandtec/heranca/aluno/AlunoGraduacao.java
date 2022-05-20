package com.bandtec.heranca.aluno;

//A classe AlunoGraduacao herda o que existe
//na classe Aluno
public class AlunoGraduacao extends Aluno{
    private Double notaContinuada;
    private Double notaIntegrada;

    public AlunoGraduacao(Double notaContinuada, 
                            Double notaIntegrada,
                            Integer ra,
                            String nome) {
        super(ra, nome);
        this.notaContinuada = notaContinuada;
        this.notaIntegrada = notaIntegrada;
    }
    
       public AlunoGraduacao(Double notaContinuada, 
                            Double notaIntegrada,
                            Integer ra,
                            String nome,
                            String email) {
        super(ra, nome, email);
        this.notaContinuada = notaContinuada;
        this.notaIntegrada = notaIntegrada;
    }

    public Double getNotaContinuada() {
        return notaContinuada;
    }

    public void setNotaContinuada(Double notaContinuada) {
        this.notaContinuada = notaContinuada;
    }

    public Double getNotaIntegrada() {
        return notaIntegrada;
    }

    public void setNotaIntegrada(Double notaIntegrada) {
        this.notaIntegrada = notaIntegrada;
    }
    
    public Double calcularMedia(){
        return (this.notaContinuada + this.notaIntegrada) / 2;
    }

    @Override
    public String toString() {
        return String.format("Aluno Graduação: "
                + "\n%s"
                + "\nNota Continuada: %.2f"
                + "\nNota Integrada: %.2f",
                super.toString(),
                this.notaContinuada,
                this.notaIntegrada);
 
    }
    
    
    
}
