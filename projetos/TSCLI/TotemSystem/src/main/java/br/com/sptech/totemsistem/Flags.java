package br.com.sptech.totemsistem;

/**
 *
 * @author Totem System
 */
public class Flags {

    private Double critico = 0.9;
    private Double atencao = 0.7;
    private Integer servicosCritico = 20;
    private Integer servicosAtencao = 14;
    private Integer processosCritico = 40;
    private Integer processosAtencao = 28;
    

    private String vermelho = "VERMELHO";
    private String amarelo = "AMARELO";
    private String verde = "VERDE";

    public String getFlagRam(Totem totem) {

        Long memoriaTotal = totem.getMemoriaDisponivel() + totem.getMemoriaEmUso();

        if (totem.getMemoriaEmUso() >= (memoriaTotal * critico)) {
            return this.vermelho;
        } else if (totem.getMemoriaEmUso() >= (memoriaTotal * atencao) && totem.getMemoriaEmUso() < (memoriaTotal * critico)) {
            return this.amarelo;
        } else {
            return this.verde;
        }

    }

    public String getFlagVolume(Totem totem) {

        if (totem.getVolumeEmUso() >= (totem.getVolumeTotal() * critico)) {
            return this.vermelho;
        } else if (totem.getVolumeEmUso() >= (totem.getVolumeTotal() * atencao) && totem.getVolumeEmUso() < (totem.getVolumeTotal() * critico)) {
            return this.amarelo;
        } else {
            return this.verde;
        }

    }

    public String getFlagProcessos(Totem totem) {
        
        if(totem.getTotalProcessos() >= processosCritico){
            return vermelho;
        } else if(totem.getTotalProcessos() >= processosAtencao && totem.getTotalProcessos() < processosCritico){
            return amarelo;
        } else {
            return verde;
        }
    }

    public String getFlagServicos(Totem totem) {
        
        if(totem.getTotalDeServicos() >= servicosCritico){
            return vermelho;
        } else if(totem.getTotalDeServicos() >= servicosAtencao && totem.getTotalDeServicos() < servicosCritico){
            return amarelo;
        } else {
            return verde;
        }
    }

}
