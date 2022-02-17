
package aula2;

/*
 *
 * @author Don616
 */
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Randomicos {
    
    public static void main(String[] args){
        
        Integer numeroConvertido = Integer.valueOf("10");
        
        Random random = new Random(); // Uma opção de Random
        
        Integer num = ThreadLocalRandom.current().nextInt(0,101); // Outra opção
        System.out.println(num);
        
        
        
    }
    
}
