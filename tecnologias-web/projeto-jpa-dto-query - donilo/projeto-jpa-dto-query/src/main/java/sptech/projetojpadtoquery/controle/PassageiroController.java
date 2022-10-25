package sptech.projetojpadtoquery.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpadtoquery.repositorio.PassageiroRepository;
import sptech.projetojpadtoquery.requisicao.DesativaPassageiroRequest;
import sptech.projetojpadtoquery.resposta.PassageiroSimplesResponse;

import java.util.List;

@RestController
@RequestMapping("/passageiros")
public class PassageiroController {

    @Autowired
    PassageiroRepository passageiroRepository;

    @GetMapping("/simples")
    public ResponseEntity<List<PassageiroSimplesResponse>> getSimples(){
        return ResponseEntity.status(200).body(passageiroRepository.getPassageirosSimples());
    }

    @DeleteMapping("/{idPassageiro}")
    public ResponseEntity<?> desativaPassageiro(@PathVariable int idPassageiro){
       return null;
    }

}
