package Planejamento;

public class TestarPlanejamento {
    
    public static void main(String[] args) {
        

        Planejamento planner = new Planejamento("Estudar Java","Don",10);

        planner.terminarAtividade(10);
        System.out.println(planner.calcularTempo());

        System.out.println(planner);

    }

}
