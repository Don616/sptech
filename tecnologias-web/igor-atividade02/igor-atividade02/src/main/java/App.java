import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    static Scanner leitor;

    public static void main(String[] args) {
        boolean arquivoFoiGerado = false;
        leitor = new Scanner(System.in);

        ListaObj<Jogo> jogos = new ListaObj<>(5);
        boolean sair = false;
        while (!sair){
            System.out.println("\nEscolha um número: \n" +
                    "1. Adicionar um jogo a lista ➕\n" +
                    "2. Exibir lista de jogos 🗒️\n" +
                    "3. Gravar arquivo CSV de jogos✍️\n" +
                    "4. Ler arquivo CSV de jogos📘\n" +
                    "5. Fim do programa 💀");
            int decisao = leitor.nextInt();
            while(decisao < 1 || decisao > 5) {
                System.out.println("digite uma das opções:");
                decisao = leitor.nextInt();
            }
            switch (decisao){
                case 1: {
                    adicionarJogoNalista(jogos);
                    break;
                }
                case 2: {
                    if (jogos.getTamanho() == 0) {
                        System.out.println("\nNenhum jogo adicionado");
                        break;
                    }
                    exibeJogoNaLista(jogos);
                    break;
                }
                case 3: {
                    if (jogos.getTamanho() == 0) {
                        System.out.println("\nNão podemos criar um arquivo já que nenhum jogo foi adicionado");
                        break;
                    }
                    gravaArquivosCsv(jogos);
                    System.out.println("\nArquivo CSV Gerado!!!");
                    arquivoFoiGerado = true;
                    break;
                }
                case 4: {
                    if (!arquivoFoiGerado) {
                        System.out.println("\nO arquivo csv não foi gerado ainda");
                        break;
                    }
                    leExibeArquivoCsv();
                    break;
                }
                case 5: {
                    sair = true;
                    break;
                }
            }
        }
    }

    public static void adicionarJogoNalista(ListaObj<Jogo> jogos) {
        leitor = new Scanner(System.in);
        System.out.println("digite o nome do jogo");
        String nome = leitor.next();
        System.out.println("digite o preço do jogo");
        double preco = leitor.nextDouble();
        System.out.println("quantos jogadores podem jogar simultaneamente?");
        int qtdJogadores = leitor.nextInt();
        System.out.println("é um jogo que pode ser jogado online? [true] para sim, [false] para não");
        boolean isOnline = leitor.nextBoolean();
        int id = jogos.nroElem + 1;
        jogos.adiciona(new Jogo(id, nome, preco, qtdJogadores, isOnline));
        System.out.printf("Jogo %s cadastrado \n", nome);
    }

    public static void exibeJogoNaLista(ListaObj<Jogo> jogos){
        System.out.printf("\n%5s | %-15s | %10s | %10s | %6s \n", "id", "nome", "jogadores", "preço", "online");
        for (int i = 0; i < jogos.getTamanho(); i++) {
            System.out.printf("%05d | %-15s | %10d | %10.2f | %6s \n",
                    jogos.getElemento(i).getId(),
                    jogos.getElemento(i).getNome(),
                    jogos.getElemento(i).getQtdJogadores(),
                    jogos.getElemento(i).getPreco(),
                    jogos.getElemento(i).isOnline() ? "sim" : "não");
        }
        System.out.println("");
    }

    public static boolean gravaArquivosCsv (ListaObj<Jogo> lista){
        FileWriter arq = null; // objeto que representa o arquivo de gravação
        Formatter saida = null; // objeto usado para gravar o arquivo
        Boolean deuRuim = false;

        // bloco para abrir o arquivo
        try{
            arq = new FileWriter("Jogos.csv"); //cria ou abre o arquivo
            saida = new Formatter(arq);
        } catch (IOException error){
            System.out.println("Erro ao abrir o arquivo");
            return !deuRuim;
        }

        // Bloco para gravar o arquivo
        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Jogo jogo = lista.getElemento(i);
                saida.format(
                        "%d;%s;%d;%.2f;%s\n",
                        jogo.getId(),
                        jogo.getNome(),
                        jogo.getQtdJogadores(),
                        jogo.getPreco(),
                        jogo.isOnline() ? "sim" : "não"
                );

            }
        }
        catch (FormatterClosedException error){
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try{
                arq.close();
            } catch (IOException error){
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }

        }
        return deuRuim;
    }

    public static boolean leExibeArquivoCsv () {
        FileReader arq = null; // objeto que representa o arquivo que vai ser lido
        Scanner entrada = null; // objeto usado para ler o arquivo
        Boolean deuRuim = false;

        // Bloco para abrir o arquivo
        try {
            arq = new FileReader("Jogos.csv");
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro){
            System.out.println("Arquivo não encontrado");
            return !deuRuim;
        }
        try{
            System.out.printf("\n%5s | %-15s | %10s | %10s | %6s \n", "id", "nome", "jogadores", "preço", "online");
            while (entrada.hasNext()){
                int id = entrada.nextInt();
                String nome = entrada.next();
                int qtd = entrada.nextInt();
                Double preco = entrada.nextDouble();
                String online = entrada.next();
                System.out.printf("%05d | %-15s | %10d | %10.2f | %6s \n", id, nome, qtd, preco, online);
            }
        }
        catch (NoSuchElementException erro) {
            System.out.println("Não existem elementos no documento");
            System.out.println(erro);
            deuRuim = true;
        }
        catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try{
                arq.close();
            } catch (IOException error){
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
        }
        return deuRuim;
    }
}
