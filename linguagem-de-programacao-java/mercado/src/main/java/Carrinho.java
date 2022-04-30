package src.main.java;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private String cliente;
    private List<Produto> produtos;

    public Carrinho(String cliente){

        this.setCliente(cliente);
        this.produtos = new ArrayList();

    }

    public Integer getQuantidade(){

        return produtos.size();

    }

    public void adicionar(Produto produto){

        this.produtos.add(produto);

    }

    public Boolean existsPorNome(String nome){


        for (Produto produto: produtos){
            if(nome.equals(produto.getNome())){
                return true;
            }
        }
        return false;

    }

    public Integer getQuantidadePorCategoria(String nome){

        Integer contador = 0;

        for (Produto produto: produtos){
            if(nome.equals(produto.getCategoria())){
                contador++;
            }
        }

        return contador;

    }

    public void limpar(){

        produtos.clear();

    }

    public void removePorNome(String nome){

        for( Produto produto : produtos){

            if(produto.getNome().equals(nome)){
                produtos.remove(produto);
            }

        }

    }

    public String getPorNome(String nome){

        for( Produto produto : produtos){

            if(produto.getNome().equals(nome)){
                return produto.getNome();
            }

        }
        return null;
    }

    public Double getValorTotal(){

        Double contador = 0.0;

        for (Produto produto: produtos){
            contador += produto.getPreco();

        }

        return contador;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Carrinho: " +
                "\nCliente: " + cliente +
                "\nProdutos: " + produtos
                ;
    }
}
