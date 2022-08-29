package don616.grifes.Grifes;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Lutadores {

    private String nome;
    private Integer forcaGolpe;
    private Integer forcaDefesa;
    private Integer vida=100;


    public Integer getVida() {
        return vida;
    }

    public String getNome() {
        return nome;
    }

    public Integer getForcaGolpe() {
        return forcaGolpe;
    }

    public Integer getForcaDefesa() {
        return forcaDefesa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setForcaGolpe(Integer forcaGolpe) {
        this.forcaGolpe = forcaGolpe;
    }

    public void setForcaDefesa(Integer forcaDefesa) {
        this.forcaDefesa = forcaDefesa;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }
}
