/*
Crie uma classe Java e escreva um método chamado calcularMedia, que recebe duas notas e retorna a média das notas, como é calculada a média da Faculdade Bandtec (nota1 * 0.4 + nota2 * 0.6). No método main, solicite que o usuário digite 2 notas, chame o método calcularMedia passando as notas digitadas como argumento e exiba o valor retornado pelo método. 
 */
package exe3;

/**
 *
 * @author don616
 */
public class SistemaSPTech {
    
    Double calcularMedia(Double num1, Double num2){
        
        Double nota1 = num1 * 0.4;
        Double nota2 = num2 * 0.6;
        
        return nota1 + nota2;
        
        
    }
    
    
}
