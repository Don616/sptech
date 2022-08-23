package src.main.java;

import java.util.Scanner;

public class ExemploVetor {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        int[] vetor1 = new int[20];

        int[] vetor2 = {100,200,300,400,500};

        String[] vetor3 = new String[4];

        String[] vetor4 = {"Domingo","Segunda","Terça","Quarta","Quinta","SEXTOU","Sábado"};

        //for(int i = 0; i < vetor1.length; i++){
        //    vetor1[i] = i * 10;
        //}

        //exibeVetor(vetor1);
        //exibeVetor(vetor2);


        for(int i = 0; i < vetor3.length; i++){
            System.out.println("Digite o valor de ["+i+"]");
            vetor3[i] = leitor.nextLine();
        }


        exibeVetor(vetor3);





    }





    public static void exibeVetor(int[] v){

        for(int i = 0; i < v.length; i++){
            System.out.printf("v[%d] %d%n", i, v[i]);
        }

    }

    public static void exibeVetor(String[] v){

        for(int i = 0; i < v.length; i++){
            System.out.printf("v[%d] %s%n", i, v[i]);
        }

    }

}
