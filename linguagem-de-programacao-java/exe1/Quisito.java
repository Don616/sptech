/*
No país “Quisito” existe um benefício social chamado "Bolsa Filhos".

    Crie uma classe Java que:
    Solicite ao usuário quantos filhos de 0 a 3 anos possui.
    Solicite ao usuário quantos filhos de 4 a 16 anos possui.
    Solicite ao usuário quantos filhos de 17 a 18 anos possui.
    Calcule o valor da Bolsa, sendo que o governo paga:


* R$25,12 por filhos com menos de 4 anos 

* R$15,88 por filhos entre 4 e 16 anos 

* R$12,44 por filhos entre 17 e 18 anos

Exiba uma frase como esta: 

"Você tem um total de T filhos e vai receber R$B de bolsa"
Use interpolação com 2 casas decimais para o valor da bolsa
*/

import java.util.Scanner;

public class Quisito {
    
    public static void main(String[] args){

        Scanner leitorInt = new Scanner(System.in);


        System.out.println("Benefício Social: Bolsa Filhos");
        System.out.println("------------------------------");
        System.out.println("Quantos filhos de 0 a 3 anos possui?");
        Integer quantFilhosAte3 = leitorInt.nextInt();
        System.out.println("Quantos filhos de 4 a 16 anos possui?");
        Integer quantFilhosAte16 = leitorInt.nextInt();
        System.out.println("Quantos filhos de 17 a 18 anos possui?");
        Integer quantFilhosAte18 = leitorInt.nextInt();

        Integer totalFilhos = quantFilhosAte3 + quantFilhosAte18 + quantFilhosAte16;
        Double valorFilhosAte4 = 25.12; 
        Double valorFilhosAte16 = 15.88; 
        Double valorFilhosAte18 = 12.44;
        
        Double bolsaAte4 = valorFilhosAte4 * quantFilhosAte3;
        Double bolsaAte16 = valorFilhosAte16 * quantFilhosAte16;
        Double bolsaAte18 = valorFilhosAte18 * quantFilhosAte18;

        Double totalBolsa = bolsaAte4 + bolsaAte16 + bolsaAte18;

        System.out.println(String.format(
            "Você tem um total de %d filhos e vai receber R$%.2f de bolsa",
            totalFilhos,totalBolsa));

        leitorInt.close();

    }

}
