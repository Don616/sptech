package sptech.projetojpadtoquery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Motorista não existe")
public class MotoristaNaoExisteException extends RuntimeException{
}
