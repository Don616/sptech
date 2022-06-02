/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.Main to edit this template
 */
package br.com.sptech.totemsistem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author Totem System CLI
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Usuario user = new Usuario();
        ValidacaoLogin validacao = new ValidacaoLogin();
        Scanner leitor = new Scanner(System.in);
        SalvarDados salvar = new SalvarDados();
        BancoDeDados banco = new BancoDeDados();
        Sistema sistema = new Sistema();
        JSONObject json = new JSONObject();
        ValidacaoLogin validacaoBanco = new ValidacaoLogin();

        String email;
        String senha;

        System.out.println("\nCarregando console...\n");
        System.out.println("Digite seu email:\n");
        email = leitor.nextLine();
        System.out.println("Digite sua senha:\n");
        senha = leitor.nextLine();

        Boolean validacaoCampo = user.validacaoCampo(email, senha);

        if (validacaoCampo == true) {
            // Boolean validacaoBanco = user.validarCredenciais(email, senha);
            if (validacaoBanco.validarLogin(email, senha)) {

                
                try {
                    sistema.logAcao("---> Usuário " + email + " acessou o totem");
                } catch (IOException ex) {
                    sistema.logErro("---> Usuário " + email + " não conseguiu acessar o totem");
                }

                try {
                    Main.validacoesTotem();
                } catch (Exception e) {
                    System.out.println(e);
                    try {
                        sistema.logErro("---> Erro na conexão com o banco");
                    } catch (IOException ex) {
                        
                    }
                }

            }
        } else {
            //System.out.println(username);
            System.out.println("Dados incorretos!!!!!");
            
            try {
                sistema.logAcao("---> tentativa de login com email: " + email);
                //System.out.println(username + "test");
            } catch (IOException ex) {
                sistema.logErro("---> Usuário " + email + " não conseguiu logar");
            }
        }
    }
    
    public static void menu() throws IOException {

        Sistema sistema = new Sistema();
        Scanner leitor = new Scanner(System.in);
        Info info = new Info();
        Totem totem = new Totem();
        SalvarDados salvar = new SalvarDados();

        Integer opcao = 0;

        while (opcao <= 5) {

            sistema.setLinhas("=", 20);
            System.out.println("\nBEM VINDO À TOTEM SYSTEM\n");
            System.out.println("Escolha uma opção:"
                    + "\n1 - Mostrar informações do Totem."
                    + "\n2 - Mostrar processos do Totem."
                    + "\n3 - Mostrar serviços em Execução."
                    + "\n4 - Salvar dados de máquina."
                    + "\n5 - Salvar dados variáveis."
                    + "\n6 - Sair.");
            opcao = leitor.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\nOpção escolhida: Informações do Totem\n");
                    info.getInfo();
                    sistema.logAcao("---> Usuario visualizou informações do Totem");
                    System.out.println("\nFim.");
                    break;
                case 2:
                    System.out.println("\nOpção escolhida: Mostrar processos do Totem.\n");
                    totem.processos();
                    sistema.logAcao("---> Usuario visualizou processos do totem");
                    System.out.println("\nFim.");
                    break;
                case 3:
                    System.out.println("\nOpção escolhida: Mostrar serviços em Execução.\n");
                    totem.servicos();
                    sistema.logAcao("---> Usuario visualizou serviços do totem");
                    System.out.println("\nFim.");
                    break;
                case 4:
                    System.out.println("\nOpção escolhida: Salvar dados estáticos.\n");
                    System.out.println("\nSalvando dados...");
                    salvar.salvarDadosEstaticos();
                    sistema.logAcao("---> Usuario salvou dados estáticos do Totem");
                    System.out.println("\nFim.");
                    break;
                case 5:
                    System.out.println("\nOpção escolhida: Salvar dados variáveis.");
                    sistema.logAcao("---> Usuario salvou dados variáveis do Totem");
                    System.out.println("\nSalvando dados...");

                    try {
                        for (int i = 0; i < 600; i++) {

                            salvar.salvarDadosVariaveis();
                            Thread.sleep(2000);

                        }
                    } catch (Exception e) {
                        System.out.println("ERRO");
                    }
                    System.out.println("\nFim.");
                    break;
                case 6:
                    System.out.println("Saindo... até logo!");
                    sistema.logAcao("---> Usuario deslogou do sistema");
                    break;

                default:
                    System.out.println("\nOpção Inválida.\n");
                    sistema.logAcao("---> Usuario digitou opção inválida");
                    break;
            }

        }
    }

    public static void validacoesTotem() throws SQLException, ClassNotFoundException, IOException {

        Usuario user = new Usuario();
        ValidacaoLogin validacao = new ValidacaoLogin();
        Scanner leitor = new Scanner(System.in);
        SalvarDados salvar = new SalvarDados();
        BancoDeDados banco = new BancoDeDados();
        Sistema sistema = new Sistema();

        
        if (banco.existeHostname("azure") && banco.existeHostname("mysql")) {

            Main.menu();

        } else if(!banco.existeHostname("azure") || !banco.existeHostname("mysql")){
            System.out.println("\nERRO! Totem não cadastrado!");
            sistema.logErro("---> Erro! Totem não cadastrado!");
            System.out.println("Deseja cadastrar este Totem minimamente? (S/N)");
            String resposta = leitor.nextLine();
            if (resposta.toLowerCase().equals("s")) {
                sistema.logAcao("---> Cadastro de novo totem escolhido");
                System.out.println("\nDigite o nome da estação onde deseja cadastrar o Totem:");
                String estacao = leitor.nextLine();

                    salvar.salvarTotemTemporariamente(estacao);
                    sistema.logAcao("---> Novo totem salvo na estação: "+estacao);
                    Main.menu();

            } else if (resposta.equals("N")) {
                sistema.logAcao("---> Usuario não cadastrou novo totem");
                System.out.println("Fim do Programa!");
            } else {
                sistema.logErro("---> Erro! Usuario digitou valor incorreto");
                System.out.println("Valor incorreto");
            }
        }

    }

}


