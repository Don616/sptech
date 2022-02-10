import java.util.Scanner;

public class Leitura {
    
    public static void main(String[] args){

        Scanner leitorInt = new Scanner(System.in); // Cria um leitor pra texto e pra numero
        Scanner leitorStr = new Scanner(System.in); // Cria um leitor pra texto e pra numero
        

        System.out.println("Digite seu nome: ");
        String nomeDigitado = leitorStr.nextLine();
        System.out.println("Blz, agora manda sua idade: ");
        Integer suaIdade = leitorInt.nextInt();
        System.out.println("Diz sua altura aí mermão: ");
        Double altura = leitorInt.nextDouble();
        
        System.out.println("Seu nome é "+nomeDigitado+ 
        ", a sua idade é "+ suaIdade+
        ", e a sua altura é "+altura);


        leitorInt.close();
        leitorStr.close();

    }

}
