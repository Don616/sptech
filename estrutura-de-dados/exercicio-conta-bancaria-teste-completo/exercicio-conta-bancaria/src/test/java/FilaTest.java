import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilaTest {
  @Test
  public void isFullTrueQuandoFilaPreenchida() {
    FilaObj<Integer> filaTest = new FilaObj(5);
    filaTest.insert(10);
    assertFalse(filaTest.isFull());
    filaTest.insert(20);
    assertFalse(filaTest.isFull());
    filaTest.insert(30);
    assertFalse(filaTest.isFull());
    filaTest.insert(40);
    assertFalse(filaTest.isFull());
    filaTest.insert(50);
    assertTrue(filaTest.isFull());
  }

  @Test
  public void isEmptyQuandoFilaVazia() {
    FilaObj<Integer> filaTest = new FilaObj(8);
    assertTrue(filaTest.isEmpty());
    filaTest.insert(10);
    filaTest.insert(20);
    filaTest.insert(30);
    filaTest.insert(40);
    filaTest.insert(50);
    filaTest.insert(60);
    filaTest.insert(70);
    assertFalse(filaTest.isEmpty());
    filaTest.poll();
    assertFalse(filaTest.isEmpty());
    filaTest.poll();
    assertFalse(filaTest.isEmpty());
    filaTest.poll();
    assertFalse(filaTest.isEmpty());
    filaTest.poll();
    assertFalse(filaTest.isEmpty());
    filaTest.poll();
    assertFalse(filaTest.isEmpty());
    filaTest.poll();
    assertFalse(filaTest.isEmpty());
    filaTest.poll();
    assertTrue(filaTest.isEmpty());
  }

  @Test
  public void peekQuandoFilaRetornaDez() {
    FilaObj<Integer> filaTest = new FilaObj(3);
    filaTest.insert(10);
    filaTest.insert(20);
    filaTest.insert(30);
    assertEquals(10, filaTest.peek());
  }

  @Test
  public void poolQuandoFilaRetornaDez() {
    FilaObj<Integer> filaTest = new FilaObj(3);
    filaTest.insert(10);
    filaTest.insert(20);
    filaTest.insert(30);
    assertEquals(10, filaTest.poll());
  }

  @Test
  public void poolQuandoFilaRetornaVinte() {
    FilaObj<Integer> filaTest = new FilaObj(3);
    filaTest.insert(10);
    filaTest.insert(20);
    filaTest.insert(30);
    assertEquals(10, filaTest.poll());
    assertEquals(20, filaTest.poll());
  }

  @Test
  public void insertLancaIllegalStateExceptionQuandoFilaCheia() {
    FilaObj<Integer> filaTest = new FilaObj(6);
    filaTest.insert(30);
    filaTest.insert(40);
    filaTest.insert(50);
    filaTest.insert(60);
    filaTest.insert(70);
    filaTest.insert(80);
    assertThrows(IllegalStateException.class, () -> filaTest.insert(90));
  }

  @Test
  public void insertQuandoFilaRetornaDez() {
    FilaObj<Integer> filaTest = new FilaObj(6);
    filaTest.insert(10);
    assertEquals(10, filaTest.peek());
    filaTest.insert(20);
    assertEquals(10, filaTest.peek());
    filaTest.insert(30);
    assertEquals(10, filaTest.peek());
    filaTest.insert(40);
    assertEquals(10, filaTest.peek());
  }
}
