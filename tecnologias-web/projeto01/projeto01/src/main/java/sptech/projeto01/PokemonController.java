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

        if(indice > 0 && indice < pokemons.size()){
            return pokemons.get(indice);
        } else{
            return "Pokémon não encontrado";
        }

    }

    @GetMapping("excluir/{indice}")
    public String excluir(@PathVariable Integer indice){

        if(indice > 0 && indice < pokemons.size()){
            String nome = pokemons.get(indice);
            pokemons.remove(indice);
            return "Pokemon "+nome+" deletado!";
        } else{
            return "Não encontrado";
        }

    }

    @GetMapping("atualizar/{indice}/{nome}")
    public String atualizar(@PathVariable Integer indice,
                            @PathVariable String nome){

        if(indice > 0 && indice < pokemons.size()){
            String poke = pokemons.get(indice);
            pokemons.set(indice,nome);
            return "Pokemon "+poke+" atualizado para: "+nome;

        }else{
            return "Não encontrado";
        }

    }


}
