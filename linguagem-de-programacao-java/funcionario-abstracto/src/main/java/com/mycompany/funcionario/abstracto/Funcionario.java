package com.mycompany.funcionario.abstracto;

/**
 *
 * @author Don616
 */
public abstract class Funcionario {

    private String cpf;
    private String nome;

    public Funcionario(String cpf, String nome) {

        this.cpf = cpf;
        this.nome = nome;

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    

    public abstract Double calcSalario();

    @Override
    public String toString() {
        return String.format("\n"
        + "Nome: %s\n"
        + "CPF: %s\n",
                this.getNome(),
                this.getCpf());
    }
    
    

}