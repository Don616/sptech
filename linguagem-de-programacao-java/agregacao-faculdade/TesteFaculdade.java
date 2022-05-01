public class TesteFaculdade {
    
    public static void main(String[] args){

        Faculdade sptech = new Faculdade("SPTech");

        Aluno don = new Aluno("616","Don",2);
        Aluno evy = new Aluno("777","Evy",3);

        sptech.matricularAluno(don);
        sptech.matricularAluno(evy);

        sptech.exibirAlunos();

        sptech.exibirAlunosPorSemestre(3);

        System.out.println(don);
        System.out.println(evy);

    }

}
