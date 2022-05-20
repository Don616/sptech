package com.bandtec.heranca.aluno;

public class TesteAluno {
    public static void main(String[] args) {        
        
        AlunoGraduacao a2 = new AlunoGraduacao(10.0, 10.0, 555, "Maria");
        AlunoGraduacao a3 = new AlunoGraduacao(2.0, 9.0, 234, "João", "Jão@email");       
        
        Faculdade f = new Faculdade("SPTech");       
        
        f.matricular(a2);
        f.matricular(a3);
        
        f.exibirAlunos();
        f.exibirAlunosGraduacao();
        
    }
}
