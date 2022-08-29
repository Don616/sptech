package don616.grifes.Grifes;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/grifes")
public class GrifesController {

    private List<Grifes> listaGrifes = new ArrayList<>();

    @GetMapping
    public List<Grifes> getListaGrifes(){
        return listaGrifes;
    }

    @PostMapping
    public String postListaGrifes(@RequestBody Grifes grife){
        listaGrifes.add(grife);
        return "Lista cadastrada";
    }

    @PutMapping("/{i}")
    public String putListaGrifes(@PathVariable int i,
                                 @RequestBody Grifes grife){

        listaGrifes.set(i,grife);
        return "Lista atualizada";

    }

    @DeleteMapping("/{i}")
    public String deleteListaGrifes(@PathVariable int i){

        listaGrifes.remove(i);
        return "Grife deletada";

    }



}
