package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Vendavel> listaVendavel;


    public Carrinho() {
        this.listaVendavel = new ArrayList<>();
    }

    public void adicionaVendavel(Vendavel vendavel){

        listaVendavel.add(vendavel);

    }

    public Double calculaTotalVenda(){

        Double total = 0.0;
        for(Vendavel vendavel : listaVendavel){
            total += vendavel.getValorVenda();
        }

        return total;

    }

    public void exibeItensCarrinho(){

        for(Vendavel vendavel : listaVendavel){
            System.out.println(vendavel);
        }

    }
}
