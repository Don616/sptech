package src.main.java;

import java.util.Scanner;

public class PesquisaNome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[10];

        for(int i = 0; i < nomes.length; i++){

            System.out.println("Digite um nome: ");
            nomes[i] = scanner.nextLine();

        }

        System.out.println("\nBlz, agora digita outro nome ai: ");
        String outroNome = scanner.nextLine();

        boolean hasNome = false;
        for(int i = 0; i < nomes.length; i++){
            if(outroNome.equals(nomes[i])){
                System.out.println("Nome encontrado no índice: "+i);
                hasNome = true;
            }
        }

        if(!hasNome){
            System.out.println("Nome não encontrado");
        }



    }





}
