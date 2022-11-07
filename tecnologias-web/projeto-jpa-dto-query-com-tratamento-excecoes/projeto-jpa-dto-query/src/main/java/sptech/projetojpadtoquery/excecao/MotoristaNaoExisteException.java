package sptech.projetojpadtoquery.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
Quando criamos uma Exceção que é anotada com @ResponseStatus
definimos quais status de resposta e mensagem de erro
serão apresentados ao cliente quando ela for lançada
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,
                reason = "Motorista não existe")
public class MotoristaNaoExisteException extends RuntimeException {}
