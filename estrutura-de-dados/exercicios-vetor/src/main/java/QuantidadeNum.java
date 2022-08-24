package src.main.java;

import java.util.Scanner;

public class QuantidadeNum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] valores = new int[10];

        for(int i = 0; i < valores.length; i++){

            System.out.println("Digita um numero: ");
            valores[i] = scanner.nextInt();

        }

        System.out.println("Agora digita outro numero:");
        Integer outroNumero = scanner.nextInt();

        Integer quantidade = 0;
        for(int i = 0; i < valores.length; i++){

            if(outroNumero == valores[i]){
                quantidade++;
            }



        }
        System.out.printf("O numero %d aparece %d vezes no vetor.%n", outroNumero, quantidade);
    }





}
