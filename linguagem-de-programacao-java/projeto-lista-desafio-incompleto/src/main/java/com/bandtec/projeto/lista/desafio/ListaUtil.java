package com.bandtec.projeto.lista.desafio;

import java.util.ArrayList;
import java.util.List;

public class ListaUtil {

    private List<Integer> inteiros;

    public ListaUtil() {

        this.inteiros = new ArrayList<>();
    }

    public void add(Integer valor) {

        this.inteiros.add(valor);
    }

    public void remove(Integer valor) {

        this.inteiros.remove(valor);
    }

    public Integer count() {
        return this.inteiros.size();
    }

    public Integer countPares() {
        Integer cont = 0;
        for (Integer num : inteiros) {
            if (num % 2 == 0) {
                cont++;
            }
        }
        return cont;
    }

    public Integer countImpares() {
        Integer cont = 0;
        for (Integer num : inteiros) {
            if (num % 2 == 1) {
                cont++;
            }
        }
        return cont;
    }

    public Integer somar() {

        Integer sum = 0;
        for (Integer num : inteiros) {
            sum += num;
        }
        return sum;
    }

    public Integer getMaior() {
        Integer maior = 0;

        if (this.inteiros.size() == 0) {
            return 0;
        } else {
            for (Integer num : inteiros) {
                if (num >= maior) {
                    maior = num;
                }
            }
            return maior;
        }


    }

    public Integer getMenor() {
        Integer menor = 9999;

        if (this.inteiros.size() == 0) {
            return 0;
        } else {
            for (Integer num : inteiros) {
                if (num <= menor) {
                    menor = num;
                }
            }
            return menor;
        }


    }

    public Boolean hasDuplicidade() {
        //falta fazer
        return null;
    }

}
