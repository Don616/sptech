package com.bandtec.heranca.aluno;

import java.util.ArrayList;
import java.util.List;

public class Faculdade {
    private String nome;
    private List<Aluno> alunos;

    public Faculdade(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList();
    }
    
    public void matricular(Aluno alunoInformado){
        alunos.add(alunoInformado);
    }
    
    public void exibirAlunos(){
        System.out.println("Exibindo todos:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
    
    public void exibirAlunosGraduacao(){
        System.out.println("Exibindo somente alunos de graduação:");
        for (Aluno aluno : alunos) {
            if(aluno instanceof AlunoGraduacao){
                System.out.println(aluno);
            }
        }
    }
}
