package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class Tributo {

    List<Tributavel> listaTributaveis;

    public Tributo() {
        this.listaTributaveis = new ArrayList<>();
    }

    public void adicionaTributavel(Tributavel tributavel){

        if(!listaTributaveis.contains(tributavel)){
            listaTributaveis.add(tributavel);
        }

    }

    public Double calculaTotalTributo(){

        Double total = 0.0;
        for(Tributavel tributavel:listaTributaveis){
            total += tributavel.getValorTributo();
        }

        return total;
    }

    public void exibeTodos(){

        for(Tributavel tributavel:listaTributaveis){
            System.out.println(tributavel);
        }

    }

}
