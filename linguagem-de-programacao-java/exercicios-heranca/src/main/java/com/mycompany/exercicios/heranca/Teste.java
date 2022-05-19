/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exercicios.heranca;

/**
 *
 * @author Vericoders
 */
public class Teste {
    
    public static void main(String[] args) {
        
        Consultoria matrix = new Consultoria("Matrix", 20);
        Desenvolvedor joao = new Desenvolvedor("João", 160, 1.00);
        Desenvolvedor julia = new Desenvolvedor("Júlia", 32, 1000.00);
        Desenvolvedor don = new Desenvolvedor("Don", 90, 55.00);
        
        matrix.contratar(don);
        matrix.contratar(julia);
        matrix.contratar(joao);
        
        System.out.println(matrix);
        
    }
    
}
