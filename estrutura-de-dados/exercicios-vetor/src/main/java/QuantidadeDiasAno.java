package src.main.java;

import java.util.Scanner;

public class QuantidadeDiasAno {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        

        Integer[] diaMesN = {31,28,31,30,31,30,31,31,30,31,30,31};
        Integer[] diaMesB = {31,29,31,30,31,30,31,31,30,31,30,31};

        System.out.println("Digite um dia do mês");
        Integer dia = leitor.nextInt();
        System.out.println("Digite um mês do ano (número)");
        Integer mes = leitor.nextInt();
        System.out.println("O ano é bissexto? (true/false)");
        Boolean isBissexto = leitor.nextBoolean();

        Integer dias = 0;

        if(isBissexto){

            for(int i = mes; i > 0;i--){

                if(i == mes){
                    dias += dia;
                } else{
                    dias += diaMesB[i-1];
                }

            }

        }else{

            for(int i = mes; i > 0;i--){

                if(i == mes){
                    dias += dia;
                } else{
                    dias += diaMesN[i-1];
                }

            }

        }

        System.out.println(dias);






    }

}
