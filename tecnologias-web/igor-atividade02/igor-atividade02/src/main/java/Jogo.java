public class Jogo {
    private int id;
    private String nome;
    private double preco;
    private int qtdJogadores;
    private boolean isOnline;

    public Jogo(int id, String nome, double preco, int qtdJogadores, boolean isOnline) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.qtdJogadores = qtdJogadores;
        this.isOnline = isOnline;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdJogadores() {
        return qtdJogadores;
    }

    public void setQtdJogadores(int qtdJogadores) {
        this.qtdJogadores = qtdJogadores;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
