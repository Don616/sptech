package sptech.projeto02;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/frutas")
public class FrutasController {

    private List<String> frutas = new ArrayList<>();

    @GetMapping
    public List<String> getFrutas() {
        return frutas;
    }

    @DeleteMapping("/{indice}")
    public String excluir(@PathVariable Integer indice){
        frutas.remove(indice);
        return "Fruta excluida";
    }

    @PutMapping("/{indice}")
    public String atualizar(@PathVariable Integer indice){
        return "Fruta Atualizada";
    }

    @GetMapping("/{indice}")
    public String pegar(@PathVariable Integer indice){
        return frutas.get(indice);
    }

    @PostMapping
    public String cadastrar(){
        return "fruta cadastrada";
    }
}
