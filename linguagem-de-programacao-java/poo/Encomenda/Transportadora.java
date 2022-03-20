public class Transportadora {
    
    public static void main(String[] args){

        Encomenda pacote1 = new Encomenda('M',"Rua A, 32","Rua B, 50",43.0,80.0);

        pacote1.emitirEtiqueta();
        pacote1.calcularFrete();
        pacote1.emitirEtiqueta();

    }


}
