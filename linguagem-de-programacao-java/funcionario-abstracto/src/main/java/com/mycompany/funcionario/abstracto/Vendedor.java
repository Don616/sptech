/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionario.abstracto;

/**
 *
 * @author Don616
 */
public class Vendedor extends Funcionario{
    
    private Double vendas;
    private Double taxas;

    public Vendedor(Double vendas, Double taxas, String cpf, String nome) {
        super(cpf, nome);
        this.vendas = vendas;
        this.taxas = taxas;
    }

    public Double getVendas() {
        return vendas;
    }

    public void setVendas(Double vendas) {
        this.vendas = vendas;
    }

    public Double getTaxas() {
        return taxas;
    }

    public void setTaxas(Double taxas) {
        this.taxas = taxas;
    }
    
    

    @Override
    public Double calcSalario() {
        return this.vendas * this.taxas;
    }

    @Override
    public String toString() {
        return String.format("\n"
        + "Nº de Vendas: %.2f\n"
        + "Quantidade da taxa: %.2f\n",
        this.getVendas(),
        this.getTaxas());
    }
    
    
    
}
