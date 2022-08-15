package sptech.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VotacaoController {

    @GetMapping("/pode-votar/{idade}")
    public Boolean podeVotar(@PathVariable Integer idade){

        return idade >= 16;

    }


}
