/*

Crie uma classe Java chamada “Calculadora” que: 

    Seja executável (possui o método main).
    Solicite um número para o usuário(número real).
    Solicite outro número para o usuário(número real).
    Calcule e exiba a soma dos dois números digitados.
    Calcule e exiba a subtração do primeiro número pelo segundo.
    Calcule e exiba a multiplicação do primeiro número pelo segundo.
    Calcule e exiba a divisão do primeiro número pelo segundo. 

Exemplo:  

Digite um número:

10

Digite outro número:

4

Resultado da soma:

14.0

Resultado da subtração:

6.0

Resultado da multiplicação:

40.0

Resultado da divisão:

2.5

*/

import java.util.Scanner;

public class Calculadora {
    
    public static void main(String[] args){

        Scanner leitorDouble = new Scanner(System.in);

        System.out.println("Digite um número inteiro: ");
        Double num1 = leitorDouble.nextDouble();
        System.out.println("Digite outro número inteiro: ");
        Double num2 = leitorDouble.nextDouble();

        System.out.println(String.format("A soma dos números é: %.0f",(num1 + num2)));
        System.out.println(String.format("A subtração dos números é: %.0f",(num1 - num2)));
        System.out.println(String.format("A multiplicação dos números é: %.0f",(num1 * num2)));
        System.out.println(String.format("A divisão dos números é: %.1f",(num1 / num2)));

        leitorDouble.close();


    }

}
