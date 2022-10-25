import java.util.ListIterator;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Integer opcao = 0;
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNl = new Scanner(System.in);
        System.out.println("Bem vindo a loja da Giu!");

        ListaObj<Produto> produtosLoja = new ListaObj<>(10);

        do{
            System.out.println("Escolha a opção desejada: (digite 1, 2 ou 3)");
            System.out.println("1 - Adicionar um Produto");
            System.out.println("2 - Exibir Relatório");
            System.out.println("3 - Sair");
            opcao = leitor.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Digite o identificador:");
                    int id = leitor.nextInt();

                    System.out.println("Digite o nome:");
                    String nome = leitorNl.nextLine();

                    System.out.println("Digite o valor:");
                    Double valor = leitor.nextDouble();

                    System.out.println("Digite a quantidade em estoque:");
                    int qtdEstoque = leitor.nextInt();

                    produtosLoja.adiciona(new Produto(id,nome,valor,qtdEstoque));

                    System.out.println("Produto adicionado!");
                    break;
                case 2:
                    System.out.println("");
                    System.out.printf("%-6s %-14s %10s %-7s \n", "CÓDIGO", "PRODUTO", "VALOR", "ESTOQUE");
                    for (int i = 0; i < produtosLoja.getTamanho(); i++){
                        Produto p = produtosLoja.getElemento(i);
                        System.out.printf("%06d %-14s %10.2f %7d \n", p.getId(),p.getNome(), p.getValorUnitario(),p.getQuantidadeEstoque());
                    }
                    System.out.printf("");
                    break;
                case 3:
                    System.out.println("Obrigada por utilizar :)");
                    break;
                default:
                    System.out.println("Opção digitada inválida");
                    break;
            }
        }while (opcao != 0);
    }
}
