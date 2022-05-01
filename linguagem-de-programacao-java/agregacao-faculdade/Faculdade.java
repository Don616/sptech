import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

public class Faculdade {
    
    private String nome;
    private List<Aluno> alunos;
    

    public Faculdade(String nome){

        this.setNome(nome);
        this.alunos = new ArrayList<>();
        
        
    }

    public void matricularAluno(Aluno aluno){

        this.alunos.add(aluno);
        aluno.setAtivo(true);

    }

    public void cancelarMatricula(String ra){

        for(Aluno aluno:alunos){

            if(aluno.getRa().equals(ra)){
                
                aluno.setAtivo(false);

            }

        }

    }

    public void exibirAlunos(){

        for(Aluno aluno:alunos){
            System.out.println(String.format("%s",aluno.getNome()));
        }
        

    }

    public void exibirAlunosPorSemestre(Integer semestre){

        for(Aluno aluno:alunos){

            if(aluno.getSemestre().equals(semestre)){
                System.out.println(String.format("%s",aluno.getNome()));
            }

        }

    }

    public void exibirCancelados(){

        for(Aluno aluno:alunos){

            if(aluno.getAtivo() == false){
                System.out.println(String.format("%s",aluno.getNome()));
            }

        }

    }



    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        
        return String.format("\nFaculdade~~>"
        + "\nNome: %s", this.getNome());
    }


}
