package aula1;

public class Interpolacao {
    
    public static void main(String[] args){

        String nome = "Don";
        Integer idade = 28;
        Double altura = 1.72;

        // Concatenação ---------------------------------------------

        System.out.println("Meu nome é "+nome+", tenho "+idade+
        " anos e "+altura+" de altura");

        // Interpolação ---------------------------------------------

        System.out.println(String.format(
        "Meu nome é %s, tenho %d anos e %.2f de altura"
        ,nome,idade,altura));
        
    }

}
