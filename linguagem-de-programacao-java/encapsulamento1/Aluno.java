
package aula3.projeto.encapsulamento1;

/**
 *
 * @author Don616
 */
public class Aluno {
    
    /*
    
    Modificador de acesso:
    - default
    - public
    - private
    - protected
    
    */
    
    
    
    private String nome;
    private String ra;
    private String curso;
    private Double nota1;    
    private Double nota2;
    private Integer notas = 2;

    public Aluno(String nome, String ra, String curso, Double nota1, Double nota2) {
        this.nome = nome;
        this.ra = ra;
        this.curso = curso;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public Aluno() {
    }
    
    
   
    public String getRa(){
        return ra;
    }
    
    public void setRa(String ra){
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        if(curso.equals("ADS") || curso.equals("CCO")){
            this.curso = curso;
        } 
        
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        if(nota1 >= 0 && nota1 <= 10){
            this.nota1 = nota1;
        }
        
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        if(nota2 >= 0 && nota2 <= 10){
            this.nota2 = nota2;
        }
        this.nota2 = nota2;
    }

    public Double getMedia() {
        return (this.nota1 + this.nota2) / this.notas;
    }

    @Override
    public String toString() {
        return "\nnome:" + nome + ", \nra:" + ra + ", \ncurso:" + curso + ", \nnota1:" + nota1 + ", \nnota2:" + nota2 + ", \nnotas:" + notas;
    }


    
    
    
    
    
    
    
    
    
    
    
    
    

}
