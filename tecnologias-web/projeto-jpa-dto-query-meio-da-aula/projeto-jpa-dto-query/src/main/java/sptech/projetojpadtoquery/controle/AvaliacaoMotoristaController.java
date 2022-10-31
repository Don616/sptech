package sptech.projetojpadtoquery.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sptech.projetojpadtoquery.dominio.AvaliacaoMotorista;
import sptech.projetojpadtoquery.exception.MotoristaNaoExisteException;
import sptech.projetojpadtoquery.repositorio.AvaliacaoMotoristaRepository;
import sptech.projetojpadtoquery.repositorio.MotoristaRepository;
import sptech.projetojpadtoquery.repositorio.PassageiroRepository;
import sptech.projetojpadtoquery.requisicao.NovaAvaliacaoRequest;
import sptech.projetojpadtoquery.resposta.ResumoAvaliacoesMotoristaResponse;

import javax.validation.Valid;
import java.time.LocalDateTime;

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

    @GetMapping("/nota-media-recentes/{idMotorista}")
    public ResponseEntity<Double> getMediaAvaliacoesRecentes(
            @PathVariable int idMotorista) {

        LocalDateTime ha6Meses = LocalDateTime.now().minusMonths(6);

        return ResponseEntity.of(
                avaliacaoMotoristaRepository
                        .getMediaAvaliacoes(idMotorista, ha6Meses));
    }

    @GetMapping("/resumo/{idMotorista}")
    public ResponseEntity<ResumoAvaliacoesMotoristaResponse> getResumoAvaliacoes(@PathVariable int idMotorista) {
        return ResponseEntity.of(avaliacaoMotoristaRepository.getResumoAvaliacoesMotorista(idMotorista));
    }

    @PostMapping
    public ResponseEntity<AvaliacaoMotorista> post(
            @RequestBody @Valid
            NovaAvaliacaoRequest novaAvaliacaoRequest) {

        if (!passageiroRepository.existsById(novaAvaliacaoRequest.getIdPassageiro())) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Passageiro não encontrado"
            );
        }
        if (!motoristaRepository.existsById(novaAvaliacaoRequest.getIdMotorista())) {
            throw new MotoristaNaoExisteException();
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
