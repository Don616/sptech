package sptech.projeto02;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {

    private List<Investimento> investimentos = new ArrayList<>();

    @GetMapping
    public List<Investimento> getInvestimentos() {
        return investimentos;
    }

    @PostMapping
    public Investimento postInvestimento(@RequestBody Investimento novoInvestimento){
        investimentos.add(novoInvestimento);
        return novoInvestimento;
    }

    @GetMapping("/{posicao}")
    public Investimento getInvestimentos(@PathVariable Integer posicao){
        return investimentos.get(posicao);
    }

    @DeleteMapping("/{posicao}")
    public String removeInvestimentos(@PathVariable Integer posicao){
        investimentos.remove(posicao);
        return "Excluído com sucesso";
    }

    @PutMapping("/{posicao}")
    public Investimento putInvestimentos(@PathVariable Integer posicao,@RequestBody Investimento inv){
        investimentos.set(posicao,inv);
        return inv;
    }


}
