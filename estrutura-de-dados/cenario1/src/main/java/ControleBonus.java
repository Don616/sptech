package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class ControleBonus {

    private List<IEducador> listaEducadores;

    public ControleBonus() {
        this.listaEducadores = new ArrayList<>();
    }

    public void adicionaEducador(IEducador e){
        listaEducadores.add(e);
    }

    public void mostraEducador(){
        for(IEducador e: listaEducadores){
            System.out.println(e);
        }
    }

    public Double calculaTotal(){
        Double total = 0.0;
        for(IEducador e: listaEducadores){
            total += e.getValorBonus();
        }
        return total;
    }

}
