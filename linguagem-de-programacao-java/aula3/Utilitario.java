/*

 */
package aula3;

/**
 *
 * @author Don616
 */
public class Utilitario {
    
    void exibirDivisor(String divisor, Integer vezes){
        
        
        System.out.println(String.format(
                "%s",divisor.repeat(vezes)));
        
        
    }
    
    
    void exibirNomeESobrenome(String nome, String sobrenome){
    
        System.out.println(String.format(
                "Nome: %s\nSobrenome: %s",nome, sobrenome
        ));
    
    }
    
    void exibirApresentacao(String nome, Integer idade, Double altura){
        
        System.out.println(String.format(
                "Seu nome é %s, tem %d de idade e %.2f de altura",nome, idade, altura
        ));
        
        
    }
    
    void exibirSoma(Integer num1, Integer num2){
    
        Integer resultado = num1 + num2;
        System.out.println("A soma é: "+resultado);
    
    
    }
    
    Integer somar(Integer num1, Integer num2){
        
        Integer soma = num1 + num2;
        return soma;
        
        
        
    }
    
}
