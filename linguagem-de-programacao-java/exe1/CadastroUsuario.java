/*
Crie uma classe Java chamada "CadastroUsuario" que:

    Seja executável
    Solicite o login do cliente
    Solicite a senha do cliente
    Solicite a quantidade de vezes que o usuário aceita errar a senha antes do bloqueio
    Exiba uma frase como esta: "Seu login é L e sua senha é S. Você tem T tentativas antes de ser bloqueado" 
    Use interpolação

*/



import java.util.Scanner;

public class CadastroUsuario{

    public static void main(String[] args){

        Scanner leitorInt = new Scanner(System.in);
        Scanner leitorStr = new Scanner(System.in);

        System.out.println("Digite seu login: ");
        String login = leitorStr.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = leitorStr.nextLine();
        System.out.println("Digite a quantidade de vezes: ");
        Integer vezes = leitorInt.nextInt();


        System.out.println(String.format(
            "Seu login é %s e sua senha é %s. Você tem %d tentativas antes de ser bloqueado",
            login,senha,vezes));

        leitorInt.close();
        leitorStr.close();
    }

}