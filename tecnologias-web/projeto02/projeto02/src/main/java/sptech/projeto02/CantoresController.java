package sptech.projeto02;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cantores")
public class CantoresController {

    private List<Cantores> cantores = new ArrayList<>();

    @GetMapping
    public List<Cantores> getCantores(){
        return cantores;
    }

    @GetMapping("/{i}")
    public Cantores getCantoresPorIndice(@PathVariable Integer i){

        return cantores.get(i);

    }

    @PostMapping
    public String postCantores(@RequestBody Cantores cantor){
        cantor.setId(cantores.size()+1);
        cantores.add(cantor);
        return "Cantor "+cantor.getNome()+" cadastrado com sucesso!";
    }

    @PutMapping("/{i}")
    public String putCantores(@PathVariable Integer i,
                                @RequestBody Cantores cantor){

        String nomeAntigo = cantores.get(i).getNome();
        cantores.set(i,cantor);
        return "O cantor "+nomeAntigo+" foi alterado para: "+cantor.getNome();


    }

    @DeleteMapping("/{i}")
    public String deleteCantores(@PathVariable int i){

        String nomeRemovido = cantores.get(i).getNome();
        cantores.remove(i);
        return "Cantor: "+nomeRemovido+" removido com sucesso";

    }

}
