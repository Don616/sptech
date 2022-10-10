package sptech.swagger;

public class ValidacaoProduto {

    public String validador(Produto produto){

        if(!validarNome(produto.getNome())){
            return "Nome inválido";
        }
        if(!validarPreco(produto.getPrecoUnitario())){
            return  "Preço inválido";
        }
        if(!validarQuantidade(produto.getQuantidadeEstoque())){
            return "Quantidade inválida";
        }

        return null;

    }

    public Boolean validarNome(String nome){

        if(nome.length()>=2){
            return true;
        } else{
            return false;
        }

    }

    public Boolean validarPreco(Double preco){

        if(preco>=0.01){
            return true;
        } else{
            return false;
        }

    }

    public Boolean validarQuantidade(Double quantidade){

        if(quantidade>=0.01){
            return true;
        } else{
            return false;
        }

    }



}
