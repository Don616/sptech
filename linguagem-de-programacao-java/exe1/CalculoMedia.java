/*

Crie uma classe Java chamada "CalculoMedia" que:

    Seja executável
    Solicite o nome e duas notas ao usuário.
    As notas são números reais.
    Calcule a média entre as notas (Dica: é da mesma forma como se faz em JavaScript)
    Exiba uma frase como esta: "Olá, NOME. Sua média foi de MEDIA"
    Use Interpolação com 1 casa decimal para a média.

*/

import java.util.Scanner;

public class CalculoMedia{

    public static void main(String[] args){


        Scanner leitorDouble = new Scanner(System.in);
        Scanner leitorStr = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = leitorStr.nextLine();
        System.out.println("Digite uma nota: ");
        Double nota1 = leitorDouble.nextDouble();
        System.out.println("Digite outra nota: ");
        Double nota2 = leitorDouble.nextDouble();

        Double mediaNotas = (nota1 + nota2) / 2;

        System.out.println(String.format(
            "Olá, %s. Sua média foi de %.1f",nome,mediaNotas
        ));

        leitorDouble.close();
        leitorStr.close();

    }

}