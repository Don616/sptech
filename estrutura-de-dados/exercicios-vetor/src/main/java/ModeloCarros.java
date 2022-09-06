package src.main.java;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class ModeloCarros {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        Scanner leitorInt = new Scanner(System.in);
        String[] vetor = new String[5];
        Integer[] rendimento = new Integer[5];


        for(int i = 0; i <5; i++){
            System.out.println("Digite o modelo do carro, nem mais, nem menos: ");
            vetor[i] = leitor.nextLine();
            System.out.println("Digite o rendimento do carro, como inteiro: ");
            rendimento[i] = leitorInt.nextInt();
        }


        Integer maior = 0;
        Integer indice = 0;
        for(int i = 0; i < rendimento.length;i++){
            if(rendimento[i] > maior){
                maior = rendimento[i];
                indice = i;
            }
        }

        System.out.println("O carro de maior rendimento é o: "+vetor[indice]);

    }





}
