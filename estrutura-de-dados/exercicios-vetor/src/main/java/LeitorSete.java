package src.main.java;

import java.util.Scanner;

public class LeitorSete {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int[] vetor1 = new int[7];

        for(int i = 0; i < 7;i++){
            System.out.println("Digite um número:");
            vetor1[i] = scanner.nextInt();
        }

        for(int i = vetor1.length-1; i >= 0; i--){
            System.out.println(vetor1[i]);
        }



    }

}
