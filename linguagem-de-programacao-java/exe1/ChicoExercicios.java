/*
Chicó começou a se exercitar e deseja saber quantas calorias vai perder nos exercícios.

    Crie uma classe Java que:
    Seja executável
    Solicite ao usuário o tempo, em minutos (valor inteiro) que ele passou se aquecendo
    Solicite ao usuário o tempo em minutos (valor inteiro) que ele fez exercícios aeróbicos (correr, andar, pedalar etc)
    Solicite ao usuário o tempo em minutos (valor inteiro) que ele fez exercícios de musculação 
    Calcule quantas calorias o Jorge perdeu, sendo que: * cada minuto de aquecimento faz perder 12 calorias * cada minuto de ex aeróbico faz perder 20 calorias * cada minuto de musculação faz perder 25 calorias
    Exiba, usando interpolação e apenas valores numéricos inteiros, uma frase como esta: 

"Olá, Jorge. Você fez um total de X minutos de exercícios e perdeu cerca de Y calorias".
*/

import java.util.Scanner;

public class ChicoExercicios {
    
    public static void main(String[] args){


        Integer calAquecimento = 12;
        Integer calAerobico = 20;
        Integer calMusculacao = 25;

        Scanner leitorInt = new Scanner(System.in);

        System.out.println("Digite quanto tempo (em minutos) passou se aquecendo: ");
        Integer aquecendo = leitorInt.nextInt();
        System.out.println("Digite quanto tempo (em minutos) fez exercícios aeróbicos: ");
        Integer aerobico = leitorInt.nextInt();
        System.out.println("Digite quanto tempo (em minutos) fez musculação: ");
        Integer musculacao = leitorInt.nextInt();

        Integer totalCaloriaGasta = (calAquecimento * aquecendo) + (calAerobico * aerobico) + (calMusculacao * musculacao);
        Integer totalMinutos = aquecendo + aerobico + musculacao;
        System.out.println(String.format(
            "Olá, Chicó. Você fez um total de %d minutos de exercícios e perdeu cerca de %d calorias",
            totalMinutos,totalCaloriaGasta
        ));

        leitorInt.close();

    }


}
