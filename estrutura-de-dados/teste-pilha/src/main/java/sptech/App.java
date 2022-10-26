package sptech;

public class App {
    public static void main(String[] args) {

        int[] vet1 = {1,2,2,1};
        int[] vet2 = {1,2,2,4};
        int[] vet3 = {4,2,2,4};
        int[] vet4 = {1,2,4,1};

        System.out.println(isPalindromo(vet1));
        System.out.println(isPalindromo(vet2));
        System.out.println(isPalindromo(vet3));
        System.out.println(isPalindromo(vet4));

    }

    public static Boolean isPalindromo(int[] vetor){

        Pilha pilha = new Pilha(vetor.length);
        for(int i =0; i< vetor.length;i++){
            pilha.push(vetor[i]);
        }

        for(int i =0;i < vetor.length;i++){
            if(vetor[i]!=pilha.pop()){
                return false;
            }
        }
        return true;

    }
}
