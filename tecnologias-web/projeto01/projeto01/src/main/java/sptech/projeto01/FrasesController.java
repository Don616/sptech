package sptech.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class FrasesController {


    @GetMapping
    public String cumprimentar(){
        return "Olá mundo!";
    }

    @GetMapping("/despedida")
    public String despedir(){
        return "ADEUS mundo!";
    }

    @GetMapping("/elogiar")
    public String elogiar(){
        return "Você é bonito!";
    }

    @GetMapping("/somar/{n1}/{n2}")
    public String soma(@PathVariable Integer n1,
                       @PathVariable Integer n2){
        return n1 + " + "+ n2 + " = "+(n1+n2);
    }

    @GetMapping("/maior/{n1}/{n2}")
    public String maior(@PathVariable Double n1,
                        @PathVariable Double n2){
        if(n1 > n2){
            return n1+ " É maior que "+n2;
        } else if(n2 > n1){
            return n2+ " É maior que "+n1;
        } else{
            return "São iguais";
        }

    }

    @GetMapping("/sorteio/{num}")
    public String sorteio(@PathVariable Integer num){

        if(num >= 0 && num <= 9){

            Random rand = new Random();
            Integer sort = rand.nextInt(9);

            if(num == sort){
                return "Sucesso!";
            } else{
                return "#NADA!";
            }


        } else {

            return "Número incorreto!";

        }

    }






}
