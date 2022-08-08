package sptech.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    List<String> pokemons = new ArrayList<>();

    @GetMapping
    public String home(){
        return "Bem vindo ao mundo pokemon";
    }

    @GetMapping("/cadastrar/{poke}")
    public String cadastrar(@PathVariable String poke){

        if(!pokemons.contains(poke)){
            pokemons.add(poke);
            return "Pokemon Cadastrado";
        } else{
            return "Já cadastrado!";
        }

    }
    @GetMapping("/quantidade")
    public Integer quantidade(){
        return pokemons.size();
    }

    @GetMapping("/recuperar/{indice}")
    public String recuperar(@PathVariable Integer indice){

        if(indice < pokemons.size()){
            return pokemons.get(indice);
        } else{
            return "Pokémon não encontrado";
        }

    }

}
