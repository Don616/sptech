
package aula2;

/**
 *
 * @author Don616
 */
public class NovoOperador {
    
    public static void main(String[] args){
        
      
      Boolean isAluno = true;
      String resultado;
      
      // maneira tradicional ------------------------------------------------
      
      if(isAluno){
          resultado = "É Aluno";
      } else {
          resultado = "Não é aluno";
      }
      
      // ternário -----------------------------------------------------------
      
      resultado = isAluno ? "É aluno" : "Não é aluno"; // ternario
        
    }
    
}
