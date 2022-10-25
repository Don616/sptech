public class Produto {
  private int id;
  private String nome;
  private Double valorUnitario;
  private Integer quantidadeEstoque;

  public Produto(int id, String nome, Double valorUnitario, Integer quantidadeEstoque) {
    this.id = id;
    this.nome = nome;
    this.valorUnitario = valorUnitario;
    this.quantidadeEstoque = quantidadeEstoque;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Double getValorUnitario() {
    return valorUnitario;
  }

  public void setValorUnitario(Double valorUnitario) {
    this.valorUnitario = valorUnitario;
  }

  public Integer getQuantidadeEstoque() {
    return quantidadeEstoque;
  }

  public void setQuantidadeEstoque(Integer quantidadeEstoque) {
    this.quantidadeEstoque = quantidadeEstoque;
  }

  @Override
  public String toString() {
    return "Produto{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", valorUnitario=" + valorUnitario +
        ", quantidadeEstoque=" + quantidadeEstoque +
        '}';
  }
}
