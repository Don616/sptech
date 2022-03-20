public class TesteTermometro {
    
    public static void main(String[] args){

        Termometro term = new Termometro(25.0,40.0,12.0);

        term.aumentaTemperatura(30.0);

        System.out.println(term.getTempAtual());
        System.out.println(term.exibeFahreinheit());


    }

}
