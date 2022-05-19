
package com.mycompany.funcionario.abstracto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Don616
 */
public class Empresa {
    
    List<Funcionario> funcionarios;

    public Empresa() {
        
        this.funcionarios = new ArrayList<>();
        
    }
    
    public void adicionaFuncionario(Funcionario funcionario){
        
        if(!this.funcionarios.contains(funcionario)){
            this.funcionarios.add(funcionario);
        }
        
    }
    
    public void exibeTodos(){
        Integer num = 1;
        for(Funcionario func : funcionarios){
            System.out.println(num+" - "+func+"\n");
            num++;
        }
    }
    
    public void exibeTotalSalario(){
        Double totalSalario = 0.0;
        for(Funcionario func : funcionarios){
            totalSalario += func.calcSalario();
        }
    }
    
    
    
}
