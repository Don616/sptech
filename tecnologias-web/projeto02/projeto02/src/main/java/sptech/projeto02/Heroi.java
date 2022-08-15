package sptech.projeto02;


public class Heroi {

    private String nome;
    private String poder;
    private Double forca;
    private boolean isVivo;
    private String classe = "x";

    public Heroi(String nome, String poder, Double forca, boolean isVivo) {
        this.nome = nome;
        this.poder = poder;
        this.forca = forca;
        this.isVivo = isVivo;
    }

    public String getNome() {
        return nome;
    }

    public String getPoder() {
        return poder;
    }

    public Double getForca() {
        return forca;
    }

    public boolean isVivo() {
        return isVivo;
    }

    public String getClasse() {
        return classe;
    }

    public String getDescricao(){
        return forca > 50 ? "É forte":"É fraco";
    }


}
