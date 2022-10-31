package sptech.projetojpadtoquery.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CalculadoraService {

    protected static final Double PRECO_KM = 12.0;

    public Double calcularPrecoCorrida(Double distanciaKm){
        if(distanciaKm==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Distancia não deve ser null");
        }
        if(distanciaKm <0.0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Distancia deve ser >=0");
        }

        return distanciaKm * PRECO_KM;
    }

}
