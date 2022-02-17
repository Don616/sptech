

package aula2;


import java.util.Scanner;


/**
 *
 * @author Don616
 */
public class NovaCondicao {
    
    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
        
        
        System.out.println("Digite um número inteiro: ");
        
        
        Integer numeroDigitado = leitor.nextInt();
        
        switch(numeroDigitado){
        
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda");
                break;
            case 3:
                System.out.println("Terça");
                break;
            case 4:
                System.out.println("Quarta");
                break;
            case 5:
                System.out.println("Quinta");
                break;
            case 6:
                System.out.println("Sexta");
                break;
            case 7:
                System.out.println("Sábado");
                break;
            default:
                System.out.println("Número errado, cara");
                break;
                
        }
        
        
        // --------------------------------------------------------------------
        // SEM BREAK para ganhar todos os premios
        
        switch(numeroDigitado){
            
            case 1: 
                System.out.println("Ganhou um PLAY5");
            case 2:
                System.out.println("Ganhou uma MARMITA");
            case 3:
                System.out.println("Ganhou um CELULAR MOTOROLA");
            case 4:
                System.out.println("Ganhou um CHINELO");
            default:
                System.out.println("Ganhou UM REAL");
                break;
            
        }
        
        
    }
    
}
