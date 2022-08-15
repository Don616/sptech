package sptech.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImcController {

    @GetMapping("/imc/{peso}/{altura}")
    public Double imc(@PathVariable Double peso,
                       @PathVariable Double altura){

        return peso / (altura * altura);

    }
}
