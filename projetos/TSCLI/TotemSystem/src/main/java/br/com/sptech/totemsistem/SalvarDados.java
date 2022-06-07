package br.com.sptech.totemsistem;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.JdbcTemplate;
import com.github.britooo.looca.api.core.Looca;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import org.json.JSONObject;

public class SalvarDados {

    Connection configMYSQL = new Connection("mysql");
    Connection configAZURE = new Connection("azure");
    Looca looca = new Looca();
    BancoDeDados banco = new BancoDeDados();
    Sistema sistema = new Sistema();

    JdbcTemplate templateMYSQL = new JdbcTemplate(configMYSQL.getDataSource());
    JdbcTemplate templateAZURE = new JdbcTemplate(configAZURE.getDataSource());
    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");

    public void salvarDadosEstaticos() throws IOException {

        Totem totem = new Totem();

        String hostname = "";
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            sistema.logErro("---> Nome do Totem não detectado!");
        }

        String nomeTabela = "tb_totem";

        String dataAtual = dtf2.format(LocalDateTime.now());

        String inserirDado = String.format("UPDATE %s SET "
                + "sistema_operacional = '%s',"
                + "fabricante_sistema = '%s',"
                + "arquitetura = %d,"
                + "inicializado_em = '%s',"
                + "permissoes = '%s',"
                + "marca_processador = '%s',"
                + "fabricante_processador = '%s',"
                + "micro_arquitetura = '%s',"
                + "cpus_fisicas = %d,"
                + "cpus_logicas = %d,"
                + "pacotes_fisicos = %d,"
                + "frequencia = %d,"
                + "data_atual = '%s' "
                + "where hostname = '%s'",
                nomeTabela,
                totem.getSistemaOperacional(),
                totem.getFabricanteSistema(),
                totem.getArquitetura(),
                totem.getInicializadoEm(),
                totem.getPermissoes(),
                totem.getMarca(),
                totem.getFabricanteProcessador(),
                totem.getMicroArquitetura(),
                totem.getCpusFisicas(),
                totem.getCpusLogicas(),
                totem.getPacotesFisicos(),
                totem.getFrequencia(),
                dataAtual,
                totem.getHostname());

        templateMYSQL.execute(inserirDado);
        templateAZURE.execute(inserirDado);

    }

    public void salvarDadosVariaveis() throws IOException, InterruptedException {

        Totem totem = new Totem();
        String dataAtual = dtf2.format(LocalDateTime.now());
        System.out.println("Inserindo... " + dataAtual);

        String inserirDado = String.format("INSERT INTO tb_log"
                + "(fk_hostname,"
                + "data_atual,"
                + "memoria_uso,"
                + "memoria_disponivel,"
                + "total_processos,"
                + "total_threads,"
                + "total_servicos,"
                + "total_servicos_ativos,"
                + "total_servicos_inativos,"
                + "volume_total,"
                + "volume_disponivel,"
                + "volume_em_uso) "
                + "VALUES "
                + "('%s','%s',%d,%d,%d,%d,%d,%d,%d,%d,%d,%d)",
                totem.getHostname(),
                dataAtual,
                totem.getMemoriaEmUso(),
                totem.getMemoriaDisponivel(),
                totem.getTotalProcessos(),
                totem.getTotalThreads(),
                totem.getTotalDeServicos(),
                totem.getTotalServicosAtivos(),
                totem.getTotalServicosInativos(),
                totem.getVolumeTotal(),
                totem.getVolumeDisponivel(),
                totem.getVolumeEmUso());

        templateMYSQL.execute(inserirDado);
        templateAZURE.execute(inserirDado);
        this.emitirAlertaSlack(totem);

    }

    public void salvarTotemTemporariamente(String estacao) throws SQLException, ClassNotFoundException, IOException {
        Totem totem = new Totem();
        Scanner leitor = new Scanner(System.in);
        if (!banco.existeHostname("azure")) {
            if (banco.existeEstacao(estacao, "azure")) {
                System.out.println("Estação encontrada... Salvando na Azure...");
                Integer id = banco.getIdEstacao(estacao, "azure");

                String inserirDado = String.format("INSERT INTO tb_totem"
                        + "(fk_estacao,"
                        + "hostname)"
                        + "values"
                        + "(%d,'%s')",
                        id,
                        totem.getHostname());

                templateAZURE.execute(inserirDado);

            } else {
                System.out.println("Estação não existe no banco de dados! Cadastre em outra!");
                String novaEstacao = leitor.nextLine();
                this.salvarTotemTemporariamente(novaEstacao);
            }

        }
        if (!banco.existeHostname("mysql")) {
            if (banco.existeEstacao(estacao, "mysql")) {
                System.out.println("Estação encontrada... Salvando no MYSQL");
                Integer id = banco.getIdEstacao(estacao, "mysql");

                String inserirDado = String.format("INSERT INTO tb_totem"
                        + "(fk_estacao,"
                        + "hostname)"
                        + "values"
                        + "(%d,'%s')",
                        id,
                        totem.getHostname());

                templateMYSQL.execute(inserirDado);

            } else {
                System.out.println("Estação não existe no banco de dados! Cadastre em outra!");
                String novaEstacao = leitor.nextLine();
                this.salvarTotemTemporariamente(novaEstacao);
            }
        }

    }

    private void emitirAlertaSlack(Totem totem) throws IOException, InterruptedException {

        Flags flag = new Flags();
        JSONObject json = new JSONObject();
        
        Long memoriaTotal = totem.getMemoriaEmUso()+totem.getMemoriaDisponivel();

        // PROCESSOS
        if (flag.getFlagProcessos(totem).equals("VERMELHO")) {
            json.put("text", "🚨 ~~> Número de Processos ("+totem.getTotalProcessos()+") em estado crítico no totem: " + totem.getHostname());
            Slack.sendMessage(json);
        } else if (flag.getFlagProcessos(totem).equals("AMARELO")) {
            json.put("text", "⚠ ~~> Número de Processos ("+totem.getTotalProcessos()+") em estado de alerta no totem: " + totem.getHostname());
            Slack.sendMessage(json);
        } else if (flag.getFlagProcessos(totem).equals("VERDE")) {
            json.put("text", "✅ ~~> Número de Processos ("+totem.getTotalProcessos()+") OK, no totem: " + totem.getHostname());
            Slack.sendMessage(json);
        }

        // VOLUMES
        if (flag.getFlagVolume(totem).equals("VERMELHO")) {
            json.put("text", "🚨 ~~> Volume do disco em uso ("+Conversor.formatarBytes(totem.getVolumeEmUso())+") em estado crítico no totem: " + totem.getHostname());
            Slack.sendMessage(json);
        } else if (flag.getFlagVolume(totem).equals("AMARELO")) {
            json.put("text", "⚠ ~~> Volume do disco em usi ("+Conversor.formatarBytes(totem.getVolumeEmUso())+") em estado de alerta no totem: " + totem.getHostname());
            Slack.sendMessage(json);
        } else if (flag.getFlagVolume(totem).equals("VERDE")) {
            json.put("text", "✅ ~~> Volume do disco em uso ("+Conversor.formatarBytes(totem.getVolumeEmUso())+") está OK, no totem: " + totem.getHostname());
            Slack.sendMessage(json);
        }

        // MEMÓRIA RAM
        if (flag.getFlagRam(totem).equals("VERMELHO")) {
            json.put("text", "🚨 ~~> Memória RAM ("+Conversor.formatarBytes(memoriaTotal)+") em estado crítico no totem: " + totem.getHostname());
            Slack.sendMessage(json);
        } else if (flag.getFlagRam(totem).equals("AMARELO")) {
            json.put("text", "⚠ ~~> Memória RAM ("+Conversor.formatarBytes(memoriaTotal)+") em estado de alerta no totem: " + totem.getHostname());
            Slack.sendMessage(json);
        } else if (flag.getFlagRam(totem).equals("VERDE")) {
            json.put("text", "✅ ~~> Memória RAM ("+Conversor.formatarBytes(memoriaTotal)+") está OK, no totem: " + totem.getHostname());
            Slack.sendMessage(json);
        }

        // SERVIÇOS
        if (flag.getFlagServicos(totem).equals("VERMELHO")) {
            json.put("text", "🚨 ~~> Número de Serviços ("+totem.getTotalDeServicos()+") em estado crítico no totem: " + totem.getHostname());
            Slack.sendMessage(json);
        } else if (flag.getFlagServicos(totem).equals("AMARELO")) {
            json.put("text", "⚠ ~~> Número de Serviços ("+totem.getTotalDeServicos()+") em estado de alerta no totem: " + totem.getHostname());
            Slack.sendMessage(json);
        } else if (flag.getFlagServicos(totem).equals("VERDE")) {
            json.put("text", "✅ ~~> Número de Serviços ("+totem.getTotalDeServicos()+") OK, no totem: " + totem.getHostname());
            Slack.sendMessage(json);
        }
    }

}
