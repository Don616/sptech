public class Aluno{

    private String ra;
    private String nome;
    private Integer semestre;
    private Boolean ativo;

    public Aluno(String ra, String nome, Integer semestre){

        this.setRa(ra);
        this.setNome(nome);
        this.setSemestre(semestre);
        


    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getRa() {
        return ra;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    @Override
    public String toString() {
        
        return String.format("\nAluno~~>"
        + "\nRA: %s"
        + "\nNome: %s"
        + "\nSemestre: %d"
        + "\nAtivo: %b",
        this.getRa(),this.getNome(),this.getSemestre(),this.getAtivo());
    }


}