/**
 
Crie uma classe Java chamada “Idade” que: 

    Seja executável. 
    Solicite que o usuário digite o seu nome. 
    Em seguida, o programa deverá exibir a mensagem: “Olá, Fulano! Qual o ano de seu nascimento?”.
    Depois, o programa deverá exibir: “Em 2030 você terá 25 anos” (sendo "Fulano" o nome digitado pelo usuário e "xx" a idade do usuário).

Exemplo:


Qual é o seu nome?
Maria

Olá, Maria! Qual o ano de seu nascimento?
1995

Em 2030 você terá 35 anos.


 */

import java.util.Scanner;

public class Idade {
    
    public static void main(String[] args){

        Scanner leitorInt = new Scanner(System.in);
        Scanner leitorStr = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = leitorStr.nextLine();

        System.out.println(String.format(
            "Olá, %s! Qual o ano do seu nascimento?",nome
        ));
        Integer anoNascimento = leitorInt.nextInt();

        System.out.println(String.format(
            "%s, em 2030 você terá %d anos.",nome,(2030 - anoNascimento)
        ));

        leitorInt.close();
        leitorStr.close();

    }

}
