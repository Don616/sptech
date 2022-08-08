package sptech.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public String soma(@PathVariable Integer n1,@PathVariable Integer n2){
        return n1 + " + "+ n2 + " = "+(n1+n2);
    }
}
