/*

Criar uma classe chamada “Acumulador” que :

    Leia vários números até ler o número 0 e calcule a soma dos números lidos.

     (Não é para usar vetor).

*/


public class Acumulador{
    public static void main(String[] args){

        Integer acumulador =0;

        for(int i = 10; i >= 0; i--){

            System.out.println(String.format(
                "%d",i
            ));

            acumulador += i;


        }

        System.out.println(String.format(
            "A soma dos numeros é: %d",acumulador
        ));

    }
}