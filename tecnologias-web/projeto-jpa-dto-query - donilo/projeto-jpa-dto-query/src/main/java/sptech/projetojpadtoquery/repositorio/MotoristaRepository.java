package sptech.projetojpadtoquery.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.projetojpadtoquery.dominio.Motorista;
import sptech.projetojpadtoquery.resposta.MotoristaSimplesResponse;

import java.util.List;

public interface MotoristaRepository extends JpaRepository<Motorista, Integer> {



}
