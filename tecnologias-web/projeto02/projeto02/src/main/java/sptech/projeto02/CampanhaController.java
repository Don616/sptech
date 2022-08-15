package sptech.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampanhaController {

    @GetMapping("/analise-campanha/{vit}/{emp}/{derr}")
    public String analiseCampanha(@PathVariable Integer vit,
                                  @PathVariable Integer emp,
                                  @PathVariable Integer derr){

        Integer pontosPossiveis = (vit+emp+derr)/3;
        Integer pontosObitidos = (vit * 3)+emp;

        Double x = (double)pontosObitidos/pontosPossiveis *100;

        return String.format("A campanha do time foi de %.2f%%", x);


    }

}
