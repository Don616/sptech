package src.main.java;
public class Produto {

    private String nome;
    private String categoria;
    private Double preco;

    public Produto(String nome, String categoria, Double preco){

        this.setNome(nome);
        this.setCategoria(categoria);
        this.setPreco(preco);

    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "Nome: '" + nome + '\'' +
                ", Categoria: " + categoria + '\'' +
                ", Preco: " + preco +
                '}';
    }
}

