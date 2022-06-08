package br.com.sptech.totemsistem;


import java.util.List;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Volume;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Totem {

    Looca looca = new Looca();
    Sistema sistema = new Sistema();

    // Dados Estáticos
    private Integer fkEstacao;
    private String hostname;
    private String dataAtual;
    private String sistemaOperacional;
    private String fabricanteSistema;
    private Integer arquitetura;
    private String inicializadoEm;
    private String permissoes;
    private String marca;
    private String fabricanteProcessador;
    private String microArquitetura;
    private Integer cpusFisicas;
    private Integer cpusLogicas;
    private Integer pacotesFisicos;
    private Long frequencia;
    // Dados Variaveis
    private Long volumeTotal;
    private Long volumeDisponivel;
    private Long volumeEmUso;
    private Long memoriaEmUso;
    private Long memoriaDisponivel;
    private Integer totalProcessos;
    private Integer totalThreads;
    private Integer totalDeServicos;
    private Integer totalServicosAtivos;
    private Integer totalServicosInativos;
    private Double temperatura;


    public Totem(){

        this.setHostname();
        this.setDataAtual();
        this.setSistemaOperacional();
        this.setFabricanteSistema();
        this.setArquitetura();
        this.setInicializadoEm();
        this.setPermissoes();
        this.setMarca();
        this.setFabricanteProcessador();
        this.setMicroArquitetura();
        this.setCpusFisicas();
        this.setCpusLogicas();
        this.setPacotesFisicos();
        this.setFrequencia();
        this.setVolumes();
        this.setMemoriaEmUso();
        this.setMemoriaDisponivel();
        this.setTotalProcessos();
        this.setTotalThreads();
        this.setTotalDeServicos();
        this.setTotalServicosAtivos();
        this.setTotalServicosInativos();
        //this.setTemperatura();

    }

    public void processos(){

        List listaProcessos = looca.getGrupoDeProcessos().getProcessos();

        for(int i = 0; i < listaProcessos.size(); i++){
            sistema.setLinhas("-", 30);
            System.out.println(listaProcessos.get(i));
        }

    }

    public void servicos(){

        List listaServicos = looca.getGrupoDeServicos().getServicos();

        for(int i = 0; i < listaServicos.size(); i++){
            sistema.setLinhas("-", 30);
            System.out.println(listaServicos.get(i));
        }

    }
    
    private void setVolumes(){
        
        List<Volume> listaVolume = looca.getGrupoDeDiscos().getVolumes();
        for (Volume volume : listaVolume) {
            
            this.setVolumeTotal(volume.getTotal());
            this.setVolumeDisponivel(volume.getDisponivel());
                  
        }
            this.setVolumeEmUso();
        
    }

    public Integer getFkEstacao(){
        return fkEstacao;
    }

    public String getHostname() {
        return hostname;
    }

    private void setHostname() {

        this.hostname = "";
        try {
            this.hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    public String getDataAtual() {
        return dataAtual;
    }

    private void setDataAtual() {
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yy - HH:mm:ss");
        this.dataAtual = dtf2.format(LocalDateTime.now());
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    private void setSistemaOperacional() {
        this.sistemaOperacional = looca.getSistema().getSistemaOperacional();
    }

    public String getFabricanteSistema() {
        return fabricanteSistema;
    }

    private void setFabricanteSistema() {
        this.fabricanteSistema = looca.getSistema().getFabricante();
    }

    public Integer getArquitetura() {
        return arquitetura;
    }

    private void setArquitetura() {
        this.arquitetura = looca.getSistema().getArquitetura();
    }

    public String getInicializadoEm() {
        return inicializadoEm;
    }

    private void setInicializadoEm() {
        this.inicializadoEm = String.valueOf(looca.getSistema().getInicializado());
    }

    public String getPermissoes() {
        return permissoes;
    }

    private void setPermissoes() {
        this.permissoes = String.valueOf(looca.getSistema().getPermissao());
    }

    public String getMarca() {
        return marca;
    }

    private void setMarca() {
        this.marca = looca.getProcessador().getNome();
    }

    public String getFabricanteProcessador() {
        return fabricanteProcessador;
    }

    private void setFabricanteProcessador() {
        this.fabricanteProcessador = looca.getProcessador().getFabricante();
    }

    public String getMicroArquitetura() {
        return microArquitetura;
    }

    private void setMicroArquitetura() {
        this.microArquitetura = looca.getProcessador().getMicroarquitetura();
    }

    public Integer getCpusFisicas() {
        return cpusFisicas;
    }

    private void setCpusFisicas() {
        this.cpusFisicas = looca.getProcessador().getNumeroCpusFisicas();
    }

    public Integer getCpusLogicas() {
        return cpusLogicas;
    }

    private void setCpusLogicas() {
        this.cpusLogicas = looca.getProcessador().getNumeroCpusLogicas();
    }

    public Integer getPacotesFisicos() {
        return pacotesFisicos;
    }

    private void setPacotesFisicos() {
        this.pacotesFisicos = looca.getProcessador().getNumeroPacotesFisicos();
    }

    public Long getFrequencia() {
        return frequencia;
    }

    private void setFrequencia() {
        this.frequencia = looca.getProcessador().getFrequencia();
    }

    public Long getVolumeTotal() {
        return volumeTotal;
    }

    private void setVolumeTotal(Long discoTotal) {
        this.volumeTotal = discoTotal;
    }

    public Long getVolumeDisponivel() {
        return volumeDisponivel;
    }

    private void setVolumeDisponivel(Long discoEmUso) {
        this.volumeDisponivel = discoEmUso;
    }

    public Long getVolumeEmUso() {
        return volumeEmUso;
    }

    private void setVolumeEmUso() {
        this.volumeEmUso = this.getVolumeTotal() - this.getVolumeDisponivel();
    }
    

    public Long getMemoriaEmUso() {
        return memoriaEmUso;
    }

    private void setMemoriaEmUso() {
        this.memoriaEmUso = looca.getMemoria().getEmUso();
    }

    public Long getMemoriaDisponivel() {
        return memoriaDisponivel;
    }

    private void setMemoriaDisponivel() {
        this.memoriaDisponivel = looca.getMemoria().getDisponivel();
    }

    public Integer getTotalProcessos() {
        return totalProcessos;
    }

    private void setTotalProcessos() {
        this.totalProcessos = looca.getGrupoDeProcessos().getTotalProcessos();
    }

    public Integer getTotalThreads() {
        return totalThreads;
    }

    private void setTotalThreads() {
        this.totalThreads = looca.getGrupoDeProcessos().getTotalThreads();
    }

    public Integer getTotalDeServicos() {
        return totalDeServicos;
    }

    private void setTotalDeServicos() {
        this.totalDeServicos = looca.getGrupoDeServicos().getTotalDeServicos();
    }

    public Integer getTotalServicosAtivos() {
        return totalServicosAtivos;
    }

    private void setTotalServicosAtivos() {
        this.totalServicosAtivos = looca.getGrupoDeServicos().getTotalServicosAtivos();
    }

    public Integer getTotalServicosInativos() {
        return totalServicosInativos;
    }

    private void setTotalServicosInativos() {
        this.totalServicosInativos = looca.getGrupoDeServicos().getTotalServicosInativos();
    }
    
    

    public Double getTemperatura() {
        return temperatura;
    }

    private void setTemperatura() {
        //this.temperatura = looca.getTemperatura().getTemperatura();
    }

    @Override
    public String toString() {
        return "Totem{" + "fkEstacao=" + fkEstacao + ", hostname=" + hostname + ", dataAtual=" + dataAtual + ", sistemaOperacional=" + sistemaOperacional + ", fabricanteSistema=" + fabricanteSistema + ", arquitetura=" + arquitetura + ", inicializadoEm=" + inicializadoEm + ", permissoes=" + permissoes + ", marca=" + marca + ", fabricanteProcessador=" + fabricanteProcessador + ", microArquitetura=" + microArquitetura + ", cpusFisicas=" + cpusFisicas + ", cpusLogicas=" + cpusLogicas + ", pacotesFisicos=" + pacotesFisicos + ", frequencia=" + frequencia + ", memoriaEmUso=" + memoriaEmUso + ", memoriaDisponivel=" + memoriaDisponivel + ", totalProcessos=" + totalProcessos + ", totalThreads=" + totalThreads + ", totalDeServicos=" + totalDeServicos + ", temperatura=" + temperatura + '}';
    }


    
    
}
