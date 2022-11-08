import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BancoTest {

  @Test
  public void debitarDiminuiSaldoEmConta() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest = new ContaBancaria(123, 100.0);

    bancoTest.debitar(50.0, contaTest);
    assertEquals(50.0, contaTest.getSaldo());
  }

  @Test
  public void debitarAumentaQuantidadeDeOperacoes() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest = new ContaBancaria(123, 100.0);

    bancoTest.debitar(50.0, contaTest);
    assertEquals(1, bancoTest.getContadorOperacao());
  }

  @Test
  public void debitarInsereOperacaoNaPilha() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest = new ContaBancaria(123, 100.0);
    bancoTest.debitar(50.0, contaTest);

    assertEquals("Débito", bancoTest.getPilhaOperacao().peek().getTipoOperacao());
    assertEquals(50.0, bancoTest.getPilhaOperacao().peek().getValor());
    assertEquals(contaTest, bancoTest.getPilhaOperacao().peek().getContaBancaria());

  }

  @Test
  public void debitarInsereOperacaoNaPilhaQuandoDuasOperacoesRealizadas() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest = new ContaBancaria(123, 100.0);
    bancoTest.debitar(50.0, contaTest);
    bancoTest.debitar(10.0, contaTest);

    assertEquals("Débito", bancoTest.getPilhaOperacao().peek().getTipoOperacao());
    assertEquals(10.0, bancoTest.getPilhaOperacao().peek().getValor());
    assertEquals(contaTest, bancoTest.getPilhaOperacao().peek().getContaBancaria());
  }

  @Test
  public void debitarInsereOperacaoEmContasDiferentes() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest01 = new ContaBancaria(123, 100.0);
    ContaBancaria contaTest02 = new ContaBancaria(345, 100.0);

    bancoTest.debitar(50.0, contaTest01);
    bancoTest.debitar(10.0, contaTest01);
    bancoTest.debitar(20.0, contaTest02);

    assertEquals("Débito", bancoTest.getPilhaOperacao().peek().getTipoOperacao());
    assertEquals(20.0, bancoTest.getPilhaOperacao().peek().getValor());
    assertEquals(contaTest02, bancoTest.getPilhaOperacao().peek().getContaBancaria());

  }

  @Test
  public void depositarAumentaSaldoEmConta() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest = new ContaBancaria(123, 100.0);

    bancoTest.depositar(50.0, contaTest);
    assertEquals(150.0, contaTest.getSaldo());
  }

  @Test
  public void depositarAumentaQuantidadeDeOperacoes() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest = new ContaBancaria(123, 100.0);

    bancoTest.depositar(50.0, contaTest);
    assertEquals(1, bancoTest.getContadorOperacao());
  }

  @Test
  public void depositarInsereOperacaoNaPilha() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest = new ContaBancaria(123, 100.0);
    bancoTest.depositar(50.0, contaTest);

    assertEquals("Depósito", bancoTest.getPilhaOperacao().peek().getTipoOperacao());
    assertEquals(50.0, bancoTest.getPilhaOperacao().peek().getValor());
    assertEquals(contaTest, bancoTest.getPilhaOperacao().peek().getContaBancaria());

  }

  @Test
  public void depositarInsereOperacaoNaPilhaQuandoDuasOperacoesRealizadas() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest = new ContaBancaria(123, 100.0);
    bancoTest.depositar(50.0, contaTest);
    bancoTest.depositar(10.0, contaTest);

    assertEquals("Depósito", bancoTest.getPilhaOperacao().peek().getTipoOperacao());
    assertEquals(10.0, bancoTest.getPilhaOperacao().peek().getValor());
    assertEquals(contaTest, bancoTest.getPilhaOperacao().peek().getContaBancaria());
  }

  @Test
  public void depositarInsereOperacaoEmContasDiferentes() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest01 = new ContaBancaria(123, 100.0);
    ContaBancaria contaTest02 = new ContaBancaria(345, 100.0);

    bancoTest.depositar(50.0, contaTest01);
    bancoTest.depositar(10.0, contaTest01);
    bancoTest.depositar(20.0, contaTest02);

    assertEquals("Depósito", bancoTest.getPilhaOperacao().peek().getTipoOperacao());
    assertEquals(20.0, bancoTest.getPilhaOperacao().peek().getValor());
    assertEquals(contaTest02, bancoTest.getPilhaOperacao().peek().getContaBancaria());

  }

  @Test
  public void desfazerOperacoesQuandoQuantidadeInformadaInvalidaRetornaIllegalArgumentException() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest01 = new ContaBancaria(123, 100.0);
    ContaBancaria contaTest02 = new ContaBancaria(345, 100.0);

    bancoTest.depositar(50.0, contaTest01);
    bancoTest.depositar(10.0, contaTest01);
    bancoTest.depositar(20.0, contaTest02);

    assertThrows(IllegalArgumentException.class, () -> bancoTest.desfazerOperacao(0));
    assertThrows(IllegalArgumentException.class, () -> bancoTest.desfazerOperacao(4));
  }

  @Test
  public void desfazerUmaOperacaoDesempilhaDasOperacoes() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest01 = new ContaBancaria(123, 100.0);
    ContaBancaria contaTest02 = new ContaBancaria(345, 100.0);

    bancoTest.depositar(50.0, contaTest01);
    bancoTest.depositar(10.0, contaTest01);
    bancoTest.debitar(20.0, contaTest02);

    bancoTest.desfazerOperacao(1);

    assertEquals("Depósito", bancoTest.getPilhaOperacao().peek().getTipoOperacao());
    assertEquals(10.0, bancoTest.getPilhaOperacao().peek().getValor());
    assertEquals(contaTest01, bancoTest.getPilhaOperacao().peek().getContaBancaria());
  }

  @Test
  public void desfazerDuasOperacaoDesempilhaDasOperacoes() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest01 = new ContaBancaria(123, 100.0);
    ContaBancaria contaTest02 = new ContaBancaria(345, 100.0);

    bancoTest.depositar(50.0, contaTest01);
    bancoTest.depositar(10.0, contaTest01);
    bancoTest.debitar(20.0, contaTest02);

    bancoTest.desfazerOperacao(2);

    assertEquals("Depósito", bancoTest.getPilhaOperacao().peek().getTipoOperacao());
    assertEquals(50.0, bancoTest.getPilhaOperacao().peek().getValor());
    assertEquals(contaTest01, bancoTest.getPilhaOperacao().peek().getContaBancaria());
  }

  @Test
  public void desfazerUmaOperacaoRetornaDebito() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest01 = new ContaBancaria(123, 100.0);
    ContaBancaria contaTest02 = new ContaBancaria(345, 100.0);

    bancoTest.depositar(50.0, contaTest01);
    bancoTest.depositar(10.0, contaTest01);
    bancoTest.debitar(20.0, contaTest02);

    assertEquals(160.0, contaTest01.getSaldo());
    assertEquals(80.0, contaTest02.getSaldo());

    bancoTest.desfazerOperacao(1);

    assertEquals(160.0, contaTest01.getSaldo());
    assertEquals(100.0, contaTest02.getSaldo());
  }

  @Test
  public void desfazerDuasOperacaoRetornaDebidoEdeposito() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest01 = new ContaBancaria(123, 100.0);
    ContaBancaria contaTest02 = new ContaBancaria(345, 100.0);

    bancoTest.depositar(50.0, contaTest01);
    bancoTest.depositar(10.0, contaTest01);
    bancoTest.debitar(20.0, contaTest02);

    assertEquals(160.0, contaTest01.getSaldo());
    assertEquals(80.0, contaTest02.getSaldo());

    bancoTest.desfazerOperacao(2);

    assertEquals(150.0, contaTest01.getSaldo());
    assertEquals(100.0, contaTest02.getSaldo());
  }

  @Test
  public void desfazerOperacaoDiminuiUmaOperacao() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest01 = new ContaBancaria(123, 100.0);
    ContaBancaria contaTest02 = new ContaBancaria(345, 100.0);

    bancoTest.depositar(50.0, contaTest01);
    bancoTest.depositar(10.0, contaTest01);
    bancoTest.debitar(20.0, contaTest02);

    assertEquals(3, bancoTest.getContadorOperacao());

    bancoTest.desfazerOperacao(1);

    assertEquals(2, bancoTest.getContadorOperacao());
  }

  @Test
  public void desfazerOperacaoDiminuiDuasOperacoes() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest01 = new ContaBancaria(123, 100.0);
    ContaBancaria contaTest02 = new ContaBancaria(345, 100.0);

    bancoTest.depositar(50.0, contaTest01);
    bancoTest.depositar(10.0, contaTest01);
    bancoTest.debitar(20.0, contaTest02);

    assertEquals(3, bancoTest.getContadorOperacao());

    bancoTest.desfazerOperacao(2);

    assertEquals(1, bancoTest.getContadorOperacao());
  }

  @Test
  public void agendarOperacaoQuandoValoresInvalidosIllegalArgumentException() {
    Banco bancoTest = new Banco();
    ContaBancaria contaTest01 = new ContaBancaria(123, 100.0);

    assertThrows(IllegalArgumentException.class, () -> bancoTest.agendarOperacao("X", 10.0, contaTest01));
    assertThrows(IllegalArgumentException.class, () -> bancoTest.agendarOperacao("Débito", -1.0, contaTest01));
    assertThrows(IllegalArgumentException.class, () -> bancoTest.agendarOperacao("Débito", 10.0, null));
  }

  @Test
  public void agendarOperacaoQuandoValoresValidos() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest01 = new ContaBancaria(123, 100.0);

    bancoTest.agendarOperacao("Débito", 10.0, contaTest01);

    assertEquals("Débito", bancoTest.filaOperacao.peek().getTipoOperacao());
    assertEquals(10.0, bancoTest.filaOperacao.peek().getValor());
    assertEquals(contaTest01, bancoTest.filaOperacao.peek().getContaBancaria());
  }

  @Test
  public void executarOperacoesAgendadasEsvaziaFila() {
    Banco bancoTest = new Banco();

    ContaBancaria contaTest01 = new ContaBancaria(123, 100.0);

    bancoTest.agendarOperacao("Débito", 10.0, contaTest01);
    bancoTest.agendarOperacao("Débito", 20.0, contaTest01);
    bancoTest.agendarOperacao("Débito", 20.0, contaTest01);

    bancoTest.executarOperacoesAgendadas();

    assertTrue(bancoTest.getFilaOperacao().isEmpty());
  }
}
