public class TesteColaborador {
    
    public static void main(String[] args) {
        
        Colaborador colaborador1 = new Colaborador("João","Dev Jr",5000.00);
        Colaborador colaborador2 = new Colaborador("Ana","QA",4000.00);

        RecursosHumanos rh = new RecursosHumanos();

        System.out.println(colaborador1);
        System.out.println(colaborador2);

        rh.promoverColaborador(colaborador2, "QA", 4900.00);
        rh.promoverColaborador(colaborador1, "Dev Jr", 4500.00);
        rh.reajustarSalarios(colaborador1, 5.0);

        System.out.println(colaborador1);
        System.out.println(colaborador2);

        System.out.println(rh.getTotalPromovidos());
        System.out.println(rh.getSalarioReajustados());
        
        
        

    }

}
