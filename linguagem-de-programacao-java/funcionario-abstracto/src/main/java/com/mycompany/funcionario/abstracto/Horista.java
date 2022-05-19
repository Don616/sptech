
package com.mycompany.funcionario.abstracto;

/**
 *
 * @author Don616
 */
public class Horista extends Funcionario{

    private Integer qtdHora;
    private Double valorHora;

    public Horista(Integer qtdHora, Double valorHora, String cpf, String nome) {
        super(cpf, nome);
        this.qtdHora = qtdHora;
        this.valorHora = valorHora;
    }
    
    
    
    @Override
    public Double calcSalario() {
        return this.qtdHora * this.valorHora;
    }

    public Integer getQtdHora() {
        return qtdHora;
    }

    public void setQtdHora(Integer qtdHora) {
        this.qtdHora = qtdHora;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }
    

    @Override
    public String toString() {
        return String.format("\n"
        + "Horas trabalhadas: %d\n"
        + "Valor das horas: %.2f\n",
        this.getQtdHora(),
        this.getValorHora());
    }
    
        
    
}
