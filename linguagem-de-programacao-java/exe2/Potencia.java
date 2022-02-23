/*

Elaborar um programa em Java que apresente como resultado o valor de uma potência de uma base qualquer elevada a um expoente qualquer, ou seja, de BE, em que B é o valor da base e E o valor do expoente.

Considere apenas a entrada de valores inteiros e positivos.

Por exemplo: B = 2 e E = 5.

O programa deverá calcular e exibir o valor de 2 elevado a 5 = 32. (Não é para usar métodos que calculam a potência diretamente).

*/

import java.util.Scanner;
public class Potencia {
    
    public static void main(String[] args){

        Scanner leitorInt = new Scanner(System.in);

        System.out.println("Digite o valor da base: ");
        Integer base = leitorInt.nextInt();
        System.out.println("Digite o valor do expoente: ");
        Integer expoente = leitorInt.nextInt();
        System.out.println("------------------------------");
    

        Integer resultado = 1;
        for(int i = expoente; i >= 1; i--){

            System.out.println(resultado * base);
            
            resultado = resultado * base;

        }

        System.out.println(String.format(
            "\nO resultado do cálculo é: %d",resultado    
        ));
    }


}
