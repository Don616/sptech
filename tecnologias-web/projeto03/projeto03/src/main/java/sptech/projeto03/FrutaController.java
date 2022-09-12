package sptech.projeto03;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/frutas")
public class FrutaController {

    private List<Fruta> listaFrutas = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Fruta>> getFrutas(){
        if(listaFrutas.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(listaFrutas);
        }

    }

    @PostMapping
    public ResponseEntity post(@RequestBody Fruta novaFruta){
        if(novaFruta.getNome()==null||novaFruta.getNome().isBlank()){
            return ResponseEntity.status(400).body("Nome deve ter uma ou mais letras");
        }
        return ResponseEntity.status(218).build();
    }

    @GetMapping("/{posicao}")
    public ResponseEntity<Fruta> get(@PathVariable int posicao){
        if(posicao >=0&&posicao<listaFrutas.size()){
            return ResponseEntity.status(200).body(listaFrutas.get(posicao));
        }
        return ResponseEntity.status(404).build();
    }

}
