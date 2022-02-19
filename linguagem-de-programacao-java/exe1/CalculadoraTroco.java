/*
Crie uma classe  Java chamada “CalculadoraTroco” que:

    Seja executável.
    Solicite o valor unitário de um produto.
    Solicite a quantidade vendida.
    Solicite o valor pago pelo cliente.
    Calcule e exiba o troco com a seguinte frase: "Seu troco será de R$ X", onde "X" é o valor a ser devolvido ao cliente.
*/
import java.util.Scanner;

public class CalculadoraTroco {
    
    public static void main(String[] args){

        Scanner leitorInt = new Scanner(System.in);
        Scanner leitorDouble = new Scanner(System.in);
        
        System.out.println("Qual o valor unitário do produto? ");
        Double valorUnitario = leitorDouble.nextDouble();
        System.out.println("Qual foi a quantidade vendida? ");
        Integer quantidadeVendida = leitorInt.nextInt();
        System.out.println("Digite a quantia em dinheiro paga: ");
        Double valorPago = leitorDouble.nextDouble();

        Double valorTotal = valorUnitario * quantidadeVendida;
        Double troco = valorPago - valorTotal;

        System.out.println(String.format(
            "Seu troco será de R$%.2f",
            troco
            ));

        leitorInt.close();
        leitorDouble.close();
        

    }

}
