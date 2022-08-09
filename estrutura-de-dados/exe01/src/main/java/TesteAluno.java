package src.main.java;

public class TesteAluno {

    public static void main(String[] args) {

        Escola sptech = new Escola("SPTech");

        AlunoFundamental ze = new AlunoFundamental(123,"Zé",
                4.0,5.0,3.0,10.0);
        AlunoGraduacao don = new AlunoGraduacao(789,"Don",
                7.5,9.5);
        AlunoPos max = new AlunoPos(456,"Max",
                7.0,8.8,3.5);


        sptech.adicionaAluno(ze);
        sptech.adicionaAluno(don);
        sptech.adicionaAluno(don);
        sptech.adicionaAluno(max);

        sptech.exibeTodos();

        sptech.exibeAlunosGraduacao();

        sptech.exibeAprovados();

        sptech.buscarAluno(456);


    }

}
