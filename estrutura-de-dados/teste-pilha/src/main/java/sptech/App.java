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

        System.out.println(converterBinario(28));

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

    public static int getLog(int num){
        return (int) (Math.log(num)/Math.log(2));
    }

    public static String converterBinario(int num){

        Pilha pilha = new Pilha(getLog(num)+1);
        String binario = "";
        while(num!=0){
            pilha.push(num%2);
            num=num/2;
        }

        int topo = pilha.getTopo();
        for(int i = 0; i <= topo;i++){
            binario += pilha.pop();
        }
        return binario;
    }


}
