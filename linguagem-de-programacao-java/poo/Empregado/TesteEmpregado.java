public class TesteEmpregado {
    
    public static void main(String[] args){

        Empregado joao = new Empregado("João","Analista de Sistemas",5400.00);
        Empregado don = new Empregado("Don","Analista de Sistemas",10000.00);

        joao.reajustarSalario(15);
        don.reajustarSalario(90);

        System.out.println(joao);
        System.out.println(don);

    }

}
