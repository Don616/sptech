package sptech.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContadorController {

    private int contador;

    @GetMapping("/contador")
    public Integer getContador() {
        contador++;
        return contador;
    }
}
