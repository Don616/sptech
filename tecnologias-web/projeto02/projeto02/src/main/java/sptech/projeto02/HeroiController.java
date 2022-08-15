package sptech.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

    // Precisa de ArrayList para alterar a lista
    private List<Heroi> herois = new ArrayList<>(List.of(

            new Heroi("Wolverine","Regeneração",55.0,true),
            new Heroi("Aranha","Soltar teia",10.0,true),
            new Heroi("Mulher Areia","Soltar areia",15.0,false),
            new Heroi("Lince Negra","Intangibilidade",75.5,true)
    ));

    @GetMapping("/favorito")
    public Heroi heroifavorito(){
        Heroi favorito = new Heroi("Batman","Dinheiro",25.5,true);

        return favorito;
    }

    @GetMapping
    public List<Heroi> getHerois() {
        return herois;
    }

    @GetMapping("{indice}")
    public Heroi getHeroiPorIndice(@PathVariable Integer indice){

        if(indice >= 0 && indice < herois.size()){
            return herois.get(indice);
        }


        return null;
    }

    @GetMapping("/cadastrar/{nome}/{poder}/{forca}/{isVivo}")
    public Heroi cadastrarHeroi(@PathVariable String nome,
                               @PathVariable String poder,
                               @PathVariable Double forca,
                               @PathVariable Boolean isVivo){

        Heroi hero = new Heroi(nome,poder,forca,isVivo);


        herois.add(hero);

        return herois.get(herois.size());

    }

    @GetMapping("/atualizar/{indice}/{nome}/{poder}/{forca}/{isVivo}")
    public void atualizaHeroi(@PathVariable Integer indice,
                              @PathVariable String nome,
                               @PathVariable String poder,
                               @PathVariable Double forca,
                               @PathVariable Boolean isVivo) {

        Heroi hero = new Heroi(nome, poder, forca, isVivo);

        if (indice >= 0 && indice < herois.size()) {
            herois.set(indice, hero);
        }

    }
}
