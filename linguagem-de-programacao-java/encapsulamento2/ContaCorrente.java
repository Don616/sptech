
package br.com.sptech.projeto.encapsulamento1;

/**
 *
 * @author Don616
 */
public class ContaCorrente {
    
    private String nomeTitular = "Nenhum nome definido";
    private Double saldo = 0.0;

    public ContaCorrente(String nomeTitular) {
        
        this.setNomeTitular(nomeTitular);
        
    }

    public ContaCorrente(String nomeTitular, Double saldo) {
        
        this.setNomeTitular(nomeTitular);
        this.setSaldo(saldo);
        
    }
       

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    
    
    
}
