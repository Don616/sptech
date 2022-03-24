package br.com.sptech.projeto.encapsulamento1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        //Inicializando valores no construtor
        Aluno aluno1 = new Aluno("123","Giuliana","ADS");

//        aluno1.ra = "#123";
//        aluno1.nome = "Huk";
//        aluno1.curso = "ADS";
//        aluno1.nota1 = 10.0;
//        aluno1.nota2 = 100.0;        

          //Inicializando valores dos atributos de maneira não prática
//        aluno1.setRa("#123");
//        aluno1.setNome("Giuliana");
//        aluno1.setCurso("ADS");
//        aluno1.setNota1(10.0);
//        aluno1.setNota2(8.0);
       
        // Exibindo objeto com toString()
        System.out.println(aluno1);
        
        //Exibindo objeto sem toString (não prático)
//        System.out.println(String.format("RA: %s",aluno1.getRa()));
//        System.out.println(String.format("NOME: %s",aluno1.getNome()));
//        System.out.println(String.format("CURSO: %s", aluno1.getCurso()));
//        System.out.println(String.format("NOTA 1: %.1f", aluno1.getNota1()));
//        System.out.println(String.format("NOTA 2: %.1f", aluno1.getNota2()));
//        System.out.println(String.format("MÉDIA: %.1f", aluno1.getMedia()));
    }
}
