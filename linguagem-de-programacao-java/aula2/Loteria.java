
package aula2;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Don616
 */
public class Loteria {
    
    public static void main(String[] args) {
        
        Scanner leitorInt = new Scanner(System.in);
        Scanner leitorStr = new Scanner(System.in);
        
        Boolean jogar = true;
        
        while(jogar){ //loop infinito
            
            Integer numRand = ThreadLocalRandom.current().nextInt(0,11);
            Integer numDigitado;

            do{

                System.out.println("Digite um número de 0 ate 10");
                numDigitado = leitorInt.nextInt();

            } while(numDigitado < 0 || numDigitado > 10);



            Integer tentativa = 0;

            while(numDigitado != numRand){

                tentativa++;
                numRand = ThreadLocalRandom.current().nextInt(0,11);
                System.out.println(numRand);
            }


            if(tentativa <= 3){

                System.out.println(String.format(
            "Você acertou com %d tentativas. Você é muito sortudo",tentativa));

            } else if(tentativa <= 10){

                System.out.println(String.format(
            "Você acertou com %d tentativas. Você tem sorte",tentativa));

            } else{
                System.out.println(String.format(
            "Você acertou com %d tentativas. Que pena...",tentativa));
            }
            

         
        }
        
        
        
        
       
    }
    
}
