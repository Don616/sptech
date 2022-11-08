import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaBancariaTest {
  @Test
  public void debitarQuandoSaldoInsuficiente(){
    ContaBancaria contaTest = new ContaBancaria(123, 150.00);
    assertFalse(contaTest.debitar(500.00));
  }

  @Test
  public void debitarQuandoSaldoValido(){
    ContaBancaria contaTest = new ContaBancaria(123, 150.00);
    assertTrue(contaTest.debitar(100.00));
  }

  @Test
  public void debitarQuandoValorNuloOuZeroOuNegativoRetornaIllegalArgumentException(){
    ContaBancaria contaTest = new ContaBancaria(123, 150.00);
    assertThrows(IllegalArgumentException.class, () -> contaTest.debitar(null));
    assertThrows(IllegalArgumentException.class, () -> contaTest.debitar(0.0));
    assertThrows(IllegalArgumentException.class, () -> contaTest.debitar(-10.0));
  }

  @Test
  public void depositarQuandoSaldoValido(){
    ContaBancaria contaTest = new ContaBancaria(123, 150.00);
    contaTest.depositar(50.0);
    assertEquals(200.0, contaTest.getSaldo());
  }

  @Test
  public void depositarQuandoValorNuloOuZeroOuNegativoRetornaIllegalArgumentException(){
    ContaBancaria contaTest = new ContaBancaria(123, 150.00);
    assertThrows(IllegalArgumentException.class, () -> contaTest.depositar(null));
    assertThrows(IllegalArgumentException.class, () -> contaTest.depositar(0.0));
    assertThrows(IllegalArgumentException.class, () -> contaTest.depositar(-10.0));
  }
}
