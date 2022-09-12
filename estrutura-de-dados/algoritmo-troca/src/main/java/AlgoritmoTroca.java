package src.main.java;

import java.util.Arrays;

public class AlgoritmoTroca {

    public static void main(String[] args) {

        Integer troca = 0;


        Integer[] vetor = {3,5,6,7,3,4,5,12,1,3,5};

        for(int i = 0; i< vetor.length-1;i++){

            for(int j = i+1; j < vetor.length;j++){

                if(vetor[j] < vetor[i]){

                    Integer aux = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                    troca++;

                }


            }

        }

        Arrays.stream(vetor).forEach(e -> System.out.println(e));
        System.out.println("Troca: "+troca);
    }




}
