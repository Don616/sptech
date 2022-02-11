package aula1;

import java.util.Scanner;

public class Condicionais {

    public static void main(String[] args) {

        Scanner scannerInt = new Scanner(System.in);
        System.out.println("Digite um número: ");
        Integer numeroDigitado = scannerInt.nextInt();

        if (numeroDigitado > 50) {

            System.out.println("É maior");

        } else if(numeroDigitado < 50){

            System.out.println("É menor");

        } else {
            System.out.println("É igual");
        }

        Integer num1 = 10;
        if(numeroDigitado.equals(num1)){ // Use sempre o .equals

            System.out.println("Os números são iguais!"); 

        }
        Boolean ligado = true;

        if(!ligado){
            System.out.println("Está Desligado!");
        } else {
            System.out.println("Está Ligado");
        }

        scannerInt.close();
    }

}
