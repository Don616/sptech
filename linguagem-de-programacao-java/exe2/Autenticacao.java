/*

Elaborar um programa java que simule a autenticação de um usuário em um sistema. Solicite o nome de usuário e senha.

Enquanto o nome for diferente de “admin” e a senha for diferente de “#SPTech” exiba: “Login e/ou senha inválidos” e solicite novamente.

Caso o usuário digite os campos corretamente, exiba: “Login realizado com sucesso”

*/

import java.util.Scanner;

public class Autenticacao {
    
    public static void main(String[] args){

        Scanner leitorStr = new Scanner(System.in);

        String login = "admin";
        String senha = "#SPTech";
        String inputLogin;
        String inputSenha;

        do {

            System.out.println("Digite seu login: ");
            inputLogin = leitorStr.nextLine();
            System.out.println("Digite sua senha: ");
            inputSenha = leitorStr.nextLine();

            if(!login.equals(inputLogin) || !senha.equals(inputSenha)){

                System.out.println("Login e/ou senha inválidos!\n");

            }

        }while(!login.equals(inputLogin) || !senha.equals(inputSenha));

        System.out.println("Login realizado com sucesso!");

        leitorStr.close();
    }


}
