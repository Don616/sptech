package src.main.java;

import java.util.Scanner;

public class TesteCarrinho {

    public static void main(String[] args) {

        Scanner leitorInt = new Scanner(System.in);
        Scanner leitorStr = new Scanner(System.in);
        Carrinho carrinho = new Carrinho();

        Integer opcao = 1;

        while(opcao > 0 && opcao <6){

            System.out.println("======= CARRINHO =======\n" +
                    "1 - Adiciona Livro;\n" +
                    "2 - Adiciona DVD;\n" +
                    "3 - Adiciona Servico;\n" +
                    "4 - Exibe itens do Carrinho;\n" +
                    "5 - Exibe total de vendas;\n" +
                    "6 - Fim\n");
            System.out.println("Digite uma das opções: ");
            opcao = leitorInt.nextInt();

            switch (opcao){

                case 1:
                    System.out.println("Digite o nome do livro que deseja cadastrar:");
                    String nomeLivro = leitorStr.nextLine();
                    System.out.println("Digite o autor do livro que deseja cadastrar:");
                    String autorLivro = leitorStr.nextLine();
                    System.out.println("Digite o isbn do livro que deseja cadastrar:");
                    String isbnLivro = leitorStr.nextLine();
                    Livro livro = new Livro(nomeLivro,autorLivro,isbnLivro);
                    carrinho.adicionaVendavel(livro);
                    System.out.println("Livro cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Digite o nome do DVD que deseja cadastrar:");
                    String nomeDVD = leitorStr.nextLine();
                    System.out.println("Digite a gravadora do DVD que deseja cadastrar:");
                    String gravadoraDVD = leitorStr.nextLine();
                    DVD dvd = new DVD(nomeDVD,gravadoraDVD);
                    carrinho.adicionaVendavel(dvd);
                    System.out.println("DVD cadastrado com sucesso!");
                    break;

                case 3:
                    System.out.println("Digite a descrição do serviço:");
                    String descricaoServico = leitorStr.nextLine();
                    System.out.println("Digite o código do serviço:");
                    Integer codigoServico = leitorInt.nextInt();
                    System.out.println("Digite a quantidade de Horas:");
                    Integer quantHorasServico = leitorInt.nextInt();
                    System.out.println("Digite o valor da hora do serviço:");
                    Double valorHora = leitorInt.nextDouble();
                    Servico servico = new Servico(descricaoServico,codigoServico,quantHorasServico,valorHora);
                    carrinho.adicionaVendavel(servico);
                    System.out.println("Serviço cadastrado com sucesso");
                    break;

                case 4:
                    carrinho.exibeItensCarrinho();
                    break;

                case 5:
                    carrinho.calculaTotalVenda();
                    break;

                default:
                    System.out.println("Saindo");
                    break;

            }

        }


    }

}
