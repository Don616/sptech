package src.main.java.empresa;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private List<Funcionario> listaFuncionario;

    public Empresa(){
        this.listaFuncionario = new ArrayList<>();
    }


    public void adicionarFuncionario(Funcionario funcionario){

        if(!listaFuncionario.contains(funcionario)){

            listaFuncionario.add(funcionario);

        }

    }

    public void exibeTodos(){

        for (Funcionario funcionario:listaFuncionario){
            System.out.println(funcionario);
        }

    }

    public void exibeTotalSalario(){
        Double totalSalario = 0.0;

        for(Funcionario funcionario:listaFuncionario){

            totalSalario += funcionario.calcSalario();

        }

        System.out.println(totalSalario);
    }

    public void exibeHoristas(){

        for(Funcionario funcionario: listaFuncionario){

            if(funcionario instanceof Horista){
                System.out.println(funcionario);
            }

        }

    }

    @Override
    public String toString() {
        return "Empresa{" +
                "listaFuncionario=" + listaFuncionario +
                '}';
    }
}
