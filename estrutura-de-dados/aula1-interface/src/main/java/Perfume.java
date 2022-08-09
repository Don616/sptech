package src.main.java;

public class Perfume extends Produto {

    private String fragancia;

    public Perfume(Integer codigo, String descricao,
                   Double preco, String fragancia) {
        super(codigo, descricao, preco);
        this.fragancia = fragancia;
    }

    @Override
    public Double getValorTributo() {
        return getPreco()*0.27;
    }

    @Override
    public String toString() {
        return "\nPerfume{" +
                "fragancia='" + fragancia + '\'' +
                "} " + super.toString();
    }
}
