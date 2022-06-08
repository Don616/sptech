package br.com.sptech.totemsistem;

import com.github.britooo.looca.api.core.Looca;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// link para pegar hostname da maquina:
//https://www.devmedia.com.br/como-detectar-o-endereco-ip-e-o-nome-da-maquina-do-host-sem-usar-socket/3100#:~:text=Veja%20nesta%20dica%20como%20obter%20informa%C3%A7%C3%B5es%20do%20host.&text=A%20classe%20java.,o%20endere%C3%A7o%20da%20m%C3%A1quina%20local.

public class Info {

    Looca looca = new Looca();
    Sistema sistema = new Sistema();
    
    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");

    public void getInfo() throws IOException{ 
        String hostname = "";
           try {
            hostname = InetAddress.getLocalHost().getHostName();
      } catch (UnknownHostException e) {
            e.printStackTrace();
            sistema.logErro("---> Nome do Totem não detectado");
      }
           

        sistema.setLinhas("-", 70);
        System.out.println("\t\t\t SISTEMA OPERACIONAL\n");
        System.out.println("Data:...................................| "+dtf2.format(LocalDateTime.now()));
        System.out.println("Sistema Operacional:....................| "+looca.getSistema().getSistemaOperacional());
        System.out.println("Hostname:...............................| "+hostname);
        System.out.println("Fabricante:.............................| "+looca.getSistema().getFabricante());
        System.out.println("Arquitetura:............................| "+looca.getSistema().getArquitetura());
        System.out.println("Inicializado em:........................| "+looca.getSistema().getInicializado());
        System.out.println("Permissões:.............................| "+looca.getSistema().getPermissao());

        sistema.setLinhas("-", 70);
        System.out.println("\t\t\t PROCESSADOR\n");
        System.out.println("Marca:..................................| "+looca.getProcessador().getNome());
        System.out.println("Fabricante:.............................| "+looca.getProcessador().getFabricante());
        System.out.println("Micro arquitetura:......................| "+looca.getProcessador().getMicroarquitetura());
        System.out.println("CPUs Físicas:...........................| "+looca.getProcessador().getNumeroCpusFisicas());
        System.out.println("CPUs Lógicas:...........................| "+looca.getProcessador().getNumeroCpusLogicas());
        System.out.println("Pacotes Físicos:........................| "+looca.getProcessador().getNumeroPacotesFisicos());
        System.out.println("Frequência:.............................| "+looca.getProcessador().getFrequencia());

        sistema.setLinhas("-", 70);
        System.out.println("\t\t\t Memória\n");
        System.out.println("Memória Total:..........................| "+looca.getMemoria().getTotal());
        System.out.println("Memória Disponível:.....................| "+looca.getMemoria().getDisponivel());
        System.out.println("Memória em Uso:.........................| "+looca.getMemoria().getEmUso());

        sistema.setLinhas("-", 70);
        System.out.println("\t\t\t Discos\n");
        System.out.println("Quantidade de Discos:...................| "+looca.getGrupoDeDiscos().getQuantidadeDeDiscos());
        System.out.println("Quantidade de Volumes:..................| "+looca.getGrupoDeDiscos().getQuantidadeDeVolumes());
        System.out.println("Tamanho total em Disco:.................| "+looca.getGrupoDeDiscos().getTamanhoTotal());




        

    }

    
}
