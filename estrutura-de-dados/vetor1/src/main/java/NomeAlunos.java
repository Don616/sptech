package src.main.java;

import java.util.Arrays;
import java.util.Scanner;

public class NomeAlunos {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        Integer indiceT1 = 0;
        Integer indiceT2 = 0;

        String[] vetorT1 = new String[10];
        String[] vetorT2 = new String[10];

        for(int i = 0; i < 10;i++){

            System.out.println(i+" Escreva um nome:");
            String nome = leitor.nextLine();
            System.out.println(i+" Escreva uma turma:");
            String turma = leitor.nextLine();

            while(!turma.equalsIgnoreCase("T1")&&!turma.equalsIgnoreCase("T2")){
                System.out.println(i+" Somente T1 ou T2:");
                turma = leitor.nextLine();
            }

            if(turma.equals("T1")){
                vetorT1[indiceT1++] = nome;
            } else {
                vetorT2[indiceT2++] = nome;
            }

        }

        String[] t1 = new String[indiceT1];
        String[] t2 = new String[indiceT2];

        for(int i = 0; i< indiceT1; i++){
            t1[i] = vetorT1[indiceT1];
        }
        for(int i = 0; i< indiceT2; i++){
            t2[i] = vetorT2[indiceT2];
        }

        System.out.println(Arrays.toString(t1));
        System.out.println(Arrays.toString(t2));

    }

}
