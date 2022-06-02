package br.com.sptech.totemsistem;

//Criação Arquivo txxt
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// Pegar hostname
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

// Data & Hora formatada
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Lista
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    //Info info = new Info();
    public void setLinhas(String tipo, Integer quantidade) {

        System.out.println(String.format(
                "%s", tipo.repeat(quantidade)
        ));
    }

    private void log(String texto) throws IOException {

        
        File arquivo = new File("./totemsystem.log");

        String hostname = "";
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException existe) {
            existe.printStackTrace();
        }



        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        List<String> lista = new ArrayList<>();

        // Adicionar a Lista (e no .txt)
        lista.add("-------------------------\n"
                + "Totem: " + hostname
                + "\n"
                + "Data & Hora: " + dtf3.format(LocalDateTime.now())
                + "\n"
                + texto);

        Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
    }

    public void logAcao(String texto) throws IOException {


        File arquivo = new File("./totemsystem.log");


        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        List<String> lista = new ArrayList<>();

        lista.add(texto);

        this.log("Tipo: Update");
        Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
    }

    public void logErro(String texto) throws IOException {

        File arquivo = new File("./totemsystemERRO.log");

        String hostname = "";
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException existe) {
            existe.printStackTrace();
        }


        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        List<String> lista = new ArrayList<>();

        // Adicionar a Lista (e no .txt)
        lista.add("-------------------------\n"
                + "Totem: " + hostname
                + "\n"
                + "Data & Hora: " + dtf3.format(LocalDateTime.now())
                + "\n"
                + "Tipo: ERRO\n"
                + texto);

        Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
    }

}
