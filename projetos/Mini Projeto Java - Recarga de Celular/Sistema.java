import java.util.Scanner;



public class Sistema {

    Double saldoAtual = 0.0;

    Scanner leitorStr = new Scanner(System.in);
    Scanner leitorInt = new Scanner(System.in);
    
    
    void divisor(String tipo, Integer quantidade){

        System.out.println(String.format(
            "\n%s\n",tipo.repeat(quantidade)
        ));

    }

    void addSaldo(){

        String valorAdicionado;

        do{
            this.divisor("*", 30);
            System.out.print("Digite o valor que deseja adicionar: ");
            valorAdicionado = leitorStr.nextLine();
            this.divisor("*", 30);

            try{
                Double valorAdicionadoConvertido = Double.parseDouble(valorAdicionado); 
                saldoAtual += valorAdicionadoConvertido;
                this.divisor("*", 30);
                System.out.println(String.format("Saldo Adicionado: R$%.2f", valorAdicionadoConvertido));
                System.out.println(String.format("Saldo Total: R$%.2f", saldoAtual)); 
                this.divisor("*", 30);
            }catch(NumberFormatException e){
                this.divisor("*", 30);
                System.out.println("Opção inválida. Digite apenas números!");
                this.divisor("*", 30);
            }

            
            System.out.print("Deseja adicionar mais saldo?\nDigite 'n' para sair ou qualquer tecla para continuar: ");
            String tecla = leitorStr.nextLine();

            if(tecla.equals("n") || tecla.equals("N")){
                System.out.println("\n");
                break;
            }
        

        }while(true);


    }

    Double verSaldo(){

        if(saldoAtual == 0.0){

            System.out.print("\nNão há saldo disponível\nDeseja adicionar mais saldo?\n\nDigite 's' para adicionar: ");
            String tecla = leitorStr.nextLine();

            if(tecla.equals("s") || tecla.equals("S")){
                addSaldo();
                return saldoAtual;
            }

        } else {
            return saldoAtual;
        }

        return saldoAtual;
        


    }

    String smsMSG(){

        System.out.print("Digite a mensagem que deseja enviar: ");
        String msg = leitorStr.nextLine();
        return msg;
    }

    void enviarSMS(){

        String msg = this.smsMSG();
        Integer valorMensagem = msg.length();
        
        if(valorMensagem > this.verSaldo()){

            this.divisor("-", 30);
            System.out.println("Você não tem créditos suficientes para enviar esta mensagem!");

        } else {

            saldoAtual -= valorMensagem;
            this.divisor("=", 30);
            System.out.println(String.format(
                "SMS Enviado:\n>> '%s'",msg
            ));

        }


    }

    void init(){

        Integer opcao = 0;
        

        do{

            System.out.println("\n");
            System.out.println("----- Sistema de Créditos de Celular -----\n");
            System.out.println("Escolha uma opção:\n");
            System.out.println("1 - Adicionar Saldo");
            System.out.println("2 - Verificar Saldo");
            System.out.println("3 - Enviar SMS");
            System.out.println("4 - Sair");
            System.out.print(">> ");
            opcao = leitorInt.nextInt();
            System.out.print("\n");

            switch(opcao){

                case 1:
                    System.out.println("Opção 'Adicionar Saldo' escolhida");
                    this.addSaldo();
                    this.divisor("*", 3);
                    
                    break;
                case 2:
                    System.out.println("Opção 'Verificar Saldo' escolhida");
                    System.out.println(String.format("Seu saldo atual é de: R$%.2f",this.verSaldo()));
                    this.divisor("*", 3);
                    
                    break;
                case 3:
                    System.out.println("Opção 'Enviar SMS' escolhida");
                    this.enviarSMS();
                    this.divisor("*", 3);
                    
                    break;
                case 4:
                    System.out.println("Opção 'Sair' escolhida");
                    System.out.println("Você saiu do programa.");
                    this.divisor("*", 3);
                    break;
                default:
                    break;
            }

        }while(opcao != 4);

    }
}





 