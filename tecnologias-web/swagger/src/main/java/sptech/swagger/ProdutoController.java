package sptech.swagger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    List<Produto> listaProdutos = new ArrayList<>();

    @PostMapping
    public ResponseEntity<?> cadastrarProduto(@RequestBody Produto produto){

        String produtoInvalido = new ValidacaoProduto().validador(produto);

        if(produtoInvalido==null){
            listaProdutos.add(produto);
            return ResponseEntity.status(201).body(produto);
        } else {
            return ResponseEntity.status(403).body(produtoInvalido);
        }

    }

    @GetMapping
    public ResponseEntity<List<Produto>> pegarProduto(){

        if(listaProdutos.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(listaProdutos);
        }

    }

    @DeleteMapping("/{posicao}")
    public ResponseEntity<Produto> deletarProdutoPosicao(@PathVariable int  posicao){

        if(posicao>listaProdutos.size()||posicao<0){
            return ResponseEntity.status(403).build();
        } else {
            listaProdutos.remove(posicao);
            return ResponseEntity.status(200).build();
        }

    }

}
