/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bandtec.heranca.aluno;

/**
 *
 * @author Don616
 */
public class AlunoPos extends Aluno{
    
    private Double notaAc1;
    private Double notaAc2;
    private Double notaAc3;
    private Double notaMonografia;

    public Double getNotaAc1() {
        return notaAc1;
    }

    public void setNotaAc1(Double notaAc1) {
        this.notaAc1 = notaAc1;
    }

    public Double getNotaAc2() {
        return notaAc2;
    }

    public void setNotaAc2(Double notaAc2) {
        this.notaAc2 = notaAc2;
    }

    public Double getNotaAc3() {
        return notaAc3;
    }

    public void setNotaAc3(Double notaAc3) {
        this.notaAc3 = notaAc3;
    }

    public Double getNotaMonografia() {
        return notaMonografia;
    }

    public void setNotaMonografia(Double notaMonografia) {
        this.notaMonografia = notaMonografia;
    }

    @Override
    public Double calcularMedia() {
        return ((((this.notaAc1 + this.notaAc2 + this.notaAc3)/3)* 0.4)+ (this.notaMonografia * 0.6));
    }
    
    
    
    
}
