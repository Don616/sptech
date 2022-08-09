package src.main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Escola {

    private String nome;
    private List<Aluno> alunos;

    public Escola(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public void adicionaAluno(Aluno aluno){

        if(!alunos.contains(aluno)){
            alunos.add(aluno);
            System.out.println("Aluno adicionado com Sucesso");
        } else{
            System.out.println("Aluno já está adicionado!");
        }

    }

    public void exibeTodos(){

        for(Aluno aluno:alunos){
            System.out.println(aluno.getNome());
        }

    }

    public void exibeAlunosGraduacao(){

        for(Aluno aluno:alunos){
            if(aluno instanceof AlunoGraduacao){
                System.out.println(aluno.getNome());
            }
        }

    }

    public void exibeAprovados(){

        for(Aluno aluno:alunos){
            if(aluno.calculaMedia() >= 6){
                System.out.println("O Aluno "+aluno.getNome()+" passou com média "
                +aluno.calculaMedia());
            }
        }

    }

    public void buscarAluno(Integer ra){

        for(Aluno aluno:alunos){
            if(Objects.equals(aluno.getRa(), ra)){
                System.out.println(aluno);
            }
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
