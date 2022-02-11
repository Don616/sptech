package aula1;

public class PassagemMetro {
    
    public static void main(String[] args){

        String usuario = "Don";
        Double saldo = 250.5;
        Double passagem = 4.40;
        Double preco = Math.floor(saldo / passagem);


        System.out.println(String.format
        ("Olá, %s. Você ainda pode usar o metrô %.0f vezes",
        usuario,preco));

        // Pode usar o método intValue() para converter para int


    }

}
