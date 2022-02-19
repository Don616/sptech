/*

Crie uma classe Java chamada “Elevador” que:

    Seja executável.
    Solicite ao usuário o limite de peso de um elevador (número real).
    Solicite ao usuário o limite de pessoas em um elevador (número inteiro).
    Solicite ao usuário o peso da 1ª pessoa que entrou no elevador (número real).
    Solicite ao usuário o peso da 2ª pessoa que entrou no elevador (número real).
    Solicite ao usuário o peso da 3ª pessoa que entrou no elevador (número real). 

Ao final, exiba uma frase assim: 

"Entraram 3 pessoas no elevador, no qual cabem X pessoas.

O peso total no elevador é de Y, sendo que ele suporta Z".

(onde X é o 2º valor lido no programa, Z o 1º e Y é a soma dos pesos das 3 pessoas)

*/

import java.util.Scanner;

public class Elevador {
    
    public static void main(String[] args){

        Scanner leitorDouble = new Scanner(System.in);
        Scanner leitorInt = new Scanner(System.in);

        System.out.println("Digite o limite de peso do elevador: ");
        Double limitePesoElevador = leitorDouble.nextDouble();
        System.out.println("Digite o limite de pessoas em um elevador: ");
        Integer limitePessoasElevador = leitorInt.nextInt();
        System.out.println("Qual o peso da 1ª pessoa que entrou no elevador?");
        Double pesoPrimeiraPessoa = leitorDouble.nextDouble();
        System.out.println("Qual o peso da 2ª pessoa que entrou no elevador?");
        Double pesoSegundaPessoa = leitorDouble.nextDouble();
        System.out.println("Qual o peso da 3ª pessoa que entrou no elevador?");
        Double pesoTerceiraPessoa = leitorDouble.nextDouble();

        Double somaPesoPessoas = pesoPrimeiraPessoa + pesoSegundaPessoa + pesoTerceiraPessoa;

        System.out.println(String.format(
            "Entraram 3 pessoas no elevador, no qual cabem %d pessoas.",
            limitePessoasElevador
        ));
        System.out.println(String.format(
            "O peso total no elevador é de %.2f, sendo que ele suporta %.2f",
            somaPesoPessoas,limitePesoElevador
        ));

        leitorDouble.close();
        leitorInt.close();
    }

}
