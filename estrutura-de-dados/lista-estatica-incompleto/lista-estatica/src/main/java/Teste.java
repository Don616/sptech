import java.util.Arrays;

public class Teste {

    // Testar Classe ListaEstatica
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(6);
        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);
        lista.adiciona(50);
        lista.adiciona(60);
        System.out.println(Arrays.toString(lista.getVetor()));
    }
}
