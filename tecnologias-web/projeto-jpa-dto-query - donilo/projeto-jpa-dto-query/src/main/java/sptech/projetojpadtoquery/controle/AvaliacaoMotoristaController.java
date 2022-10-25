package sptech.projetojpadtoquery.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpadtoquery.dominio.AvaliacaoMotorista;
import sptech.projetojpadtoquery.repositorio.AvaliacaoMotoristaRepository;
import sptech.projetojpadtoquery.repositorio.MotoristaRepository;
import sptech.projetojpadtoquery.repositorio.PassageiroRepository;
import sptech.projetojpadtoquery.requisicao.NovaAvaliacaoRequest;
import sptech.projetojpadtoquery.resposta.AvaliacaoMotoristaSimplesResponse;
import sptech.projetojpadtoquery.resposta.ResumoAvaliacoesMotoristaResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes/motoristas")
public class AvaliacaoMotoristaController {

    @Autowired
    private AvaliacaoMotoristaRepository avaliacaoMotoristaRepository;

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @GetMapping("/nota-media/{idMotorista}")
    public ResponseEntity<Double> getMediaAvaliacoes(@PathVariable int idMotorista) {
        return ResponseEntity.of(avaliacaoMotoristaRepository.getMediaAvaliacoes(idMotorista));
    }

    @GetMapping("/resumo/{idMotorista}")
    public ResponseEntity<ResumoAvaliacoesMotoristaResponse> getResumoAvaliacoes(@PathVariable int idMotorista) {
        return ResponseEntity.of(avaliacaoMotoristaRepository.getResumoAvaliacoesMotorista(idMotorista));
    }

    @GetMapping("/{idMotorista}")
    public ResponseEntity<List<AvaliacaoMotorista>> getAvaliacoesMotorista(@PathVariable @Valid int idMotorista){
        if(idMotorista<0){
            return ResponseEntity.status(404).build();
        }
        List<AvaliacaoMotorista> listaAvaliacao = avaliacaoMotoristaRepository.findByMotoristaId(idMotorista);
        if(listaAvaliacao.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listaAvaliacao);
    }

    @GetMapping("/{idMotorista}/simples")
    public ResponseEntity<List<AvaliacaoMotoristaSimplesResponse>> getSimples(@PathVariable @Valid int idMotorista){
        if(idMotorista<0){
            return ResponseEntity.status(404).build();
        }
        List<AvaliacaoMotoristaSimplesResponse> lista = avaliacaoMotoristaRepository.getAvaliacaoMotoristaSimples(idMotorista);
        if(lista.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(lista);
    }



    @PostMapping
    public ResponseEntity<AvaliacaoMotorista> post(@RequestBody @Valid NovaAvaliacaoRequest novaAvaliacaoRequest) {

        if (!passageiroRepository.existsById(novaAvaliacaoRequest.getIdPassageiro())) {
            return ResponseEntity.status(404).build();
        }
        if (!motoristaRepository.existsById(novaAvaliacaoRequest.getIdMotorista())) {
            return ResponseEntity.status(404).build();
        }

        AvaliacaoMotorista novaAvaliacao = new AvaliacaoMotorista();

        novaAvaliacao.setPassageiro(
                passageiroRepository.findById(novaAvaliacaoRequest.getIdPassageiro()).get());
        novaAvaliacao.setMotorista(
                motoristaRepository.findById(novaAvaliacaoRequest.getIdMotorista()).get());

        novaAvaliacao.setNota(novaAvaliacaoRequest.getNota());

        avaliacaoMotoristaRepository.save(novaAvaliacao);

        return ResponseEntity.status(201).body(novaAvaliacao);
    }
}
