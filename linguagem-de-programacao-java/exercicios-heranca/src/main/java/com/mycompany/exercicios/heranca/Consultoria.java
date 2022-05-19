/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exercicios.heranca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Don616
 */
public class Consultoria {

    private String nome;
    private Integer vagas;
    List<Desenvolvedor> desenvolvedores;

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public Boolean existePorNome(String nome) {

        for (Desenvolvedor desenvolvedor : desenvolvedores) {

            if (desenvolvedor.getNome().toLowerCase().equals(nome.toLowerCase())) {
                return true;
            }

        }
        return false;

    }

    public void contratar(Desenvolvedor desenvolvedor) {

        if (this.getVagas() > 0) {

            if (this.desenvolvedores.contains(desenvolvedor)) {
                System.out.println("Dev já cadastrado");
            } else {
                this.desenvolvedores.add(desenvolvedor);
                this.setVagas(this.getVagas() - 1);
            }

        } else {
            System.out.println("Sem vagas disponíveis");
        }

    }

    public Integer getQuantidadeDesenvolvedores() {

        return this.desenvolvedores.size();

    }

    public Integer getQuantidadeDesenvolvedoresMobile() {

        Integer count = 0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {

            if (desenvolvedor instanceof DesenvolvedorMobile) {
                count++;
            }

        }
        return count;

    }

    public Double getTotalSalarios() {

        Double totalSalarios = 0.0;
        for (Desenvolvedor dev : desenvolvedores) {
            totalSalarios += dev.getSalario();
        }
        return totalSalarios;
    }

    public Desenvolvedor buscarDesenvolvedorPorNome(String nome) {

        for (Desenvolvedor dev : desenvolvedores) {

            if (dev.getNome().toLowerCase().equals(nome.toLowerCase())) {
                return dev;
            }

        }
        return null;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    @Override
    public String toString() {
        return String.format("\n"
                + "Nome: %s\n"
                + "Nº de Vagas: %d\n"
                + "Lista de Devs atualmente: \n%s\n",
                this.getNome(),
                this.getVagas(),
                this.desenvolvedores.toString());
    }

}
