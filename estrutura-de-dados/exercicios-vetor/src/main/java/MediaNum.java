package src.main.java;

import java.util.Scanner;

public class MediaNum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] vetor1 = new int[10];

        for(int i = 0; i < vetor1.length; i++){

            System.out.println("Digite um numero: ");
            vetor1[i] = scanner.nextInt();

        }

        int media = 0;
        for(int i = 0; i < vetor1.length; i++){
            media += vetor1[i];
        }

        System.out.println("A média é: "+media/vetor1.length);

    }

}
