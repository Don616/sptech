package src.main.java;

public class Aluno{

    private String id;
    private String nome;
    private AssinaturaEnum assinatura;
    private Integer qtdCurso;


    public Aluno(String id, String nome, Integer qtdCurso) {
        this.id = id;
        this.nome = nome;
        this.assinatura = AssinaturaEnum.getPorQtdCursos(qtdCurso);
    }

    public Integer getQtdCurso() {
        return qtdCurso;
    }

    public void setQtdCurso(Integer qtdCurso) {
        this.qtdCurso = qtdCurso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public AssinaturaEnum getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(AssinaturaEnum assinatura) {
        this.assinatura = assinatura;
    }


}