package don616.grifes.Grifes;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lutadores")
public class LutadoresController {

    List<Lutadores> listaLutadores = new ArrayList<>();

    @GetMapping
    public List<Lutadores> retornaLista(){
        return listaLutadores;
    }

    @PostMapping
    public String cadastraLutador(@RequestBody Lutadores lutador){
        listaLutadores.add(lutador);
        return "Lutador cadastrado";
    }

    @PutMapping("/{posBate}/{golpe}/{posApanha}")
    public List<Lutadores> briga(@PathVariable int posBate,
                                 @PathVariable String golpe,
                                 @PathVariable int posApanha){

        if(posBate <= listaLutadores.size() && posApanha <= listaLutadores.size()){

            Lutadores  lutadorBate = listaLutadores.get(posBate);
            Lutadores  lutadorApanha = listaLutadores.get(posApanha);

            lutadorApanha.setVida(lutadorApanha.getVida() - (lutadorBate.getForcaGolpe() - lutadorApanha.getForcaDefesa()));

            listaLutadores.set(posApanha,lutadorApanha);

            if(lutadorApanha.getVida() <= 0 ){
                lutadorApanha.setVida(0);

            }

            return listaLutadores;

        } else {
            return null;
        }


    }

}
