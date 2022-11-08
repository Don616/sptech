public class Banco {
  PilhaObj<Operacao> pilhaOperacao = new PilhaObj(10);
  FilaObj<Operacao> filaOperacao = new FilaObj(10);
  Integer contadorOperacao = 0;

  public void debitar(Double valor, ContaBancaria conta) {
    if (conta.debitar(valor)) {
      Operacao debito = new Operacao(conta, "Débito", valor);
      pilhaOperacao.push(debito);
      contadorOperacao++;
    }
  }
  public void depositar(Double valor, ContaBancaria conta) {
    conta.depositar(valor);
    Operacao deposito = new Operacao(conta, "Depósito", valor);
    pilhaOperacao.push(deposito);
    contadorOperacao++;
  }
  public void desfazerOperacao(Integer qtdOperacaoDesfeita) {
    if (qtdOperacaoDesfeita > contadorOperacao || qtdOperacaoDesfeita == 0) {
      throw new IllegalArgumentException();
    } else {
      for (Integer i = 0; i < qtdOperacaoDesfeita; i++) {
        Operacao op = pilhaOperacao.pop();
        if (("Débito").equals(op.getTipoOperacao())) {
          op.getContaBancaria().depositar(op.getValor());
        } else if ("Depósito".equals(op.getTipoOperacao())) {
          op.getContaBancaria().debitar(op.getValor());
        }
      }
      contadorOperacao -= qtdOperacaoDesfeita;
    }
  }
  public void agendarOperacao(String tipoOperacao, Double valor, ContaBancaria conta) {
    if((tipoOperacao.equals("Débito") || tipoOperacao.equals("Depósito"))
    && valor > 0.0 && conta != null){
      Operacao operacaoAgendada = new Operacao(conta, tipoOperacao, valor);
      filaOperacao.insert(operacaoAgendada);
    }else{
      throw new IllegalArgumentException();
    }
  }

  public void executarOperacoesAgendadas() {
    if (filaOperacao.isEmpty()) {
      System.out.println("Não há operações agendadas");
    } else {
      while (!filaOperacao.isEmpty()) {

        Operacao op = filaOperacao.poll();
        if ("Depósito".equals(op.getTipoOperacao())) {
          op.getContaBancaria().depositar(op.getValor());
        } else if ("Débito".equals(op.getTipoOperacao())) {
          op.getContaBancaria().debitar(op.getValor());
        }
      }
    }
  }
  public PilhaObj<Operacao> getPilhaOperacao() {
    return pilhaOperacao;
  }
  public FilaObj<Operacao> getFilaOperacao() {
    return filaOperacao;
  }
  public Integer getContadorOperacao() {
    return contadorOperacao;
  }
}
