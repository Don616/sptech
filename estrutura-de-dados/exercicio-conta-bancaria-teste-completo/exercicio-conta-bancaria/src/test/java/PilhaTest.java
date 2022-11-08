import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PilhaTest {
  @Test
  public void isFullTrueQuandoPilhaPreenchida() {
    PilhaObj<Integer> pilhaTest = new PilhaObj<>(5);
    pilhaTest.push(10);
    assertFalse(pilhaTest.isFull());
    pilhaTest.push(20);
    assertFalse(pilhaTest.isFull());
    pilhaTest.push(30);
    assertFalse(pilhaTest.isFull());
    pilhaTest.push(40);
    assertFalse(pilhaTest.isFull());
    pilhaTest.push(50);
    assertTrue(pilhaTest.isFull());
  }

  @Test
  public void isEmptyQuandoPilhaVazia() {
    PilhaObj<Integer> pilhaTest = new PilhaObj<>(8);
    assertTrue(pilhaTest.isEmpty());
    pilhaTest.push( 10);
    pilhaTest.push(20);
    pilhaTest.push(30);
    pilhaTest.push(40);
    pilhaTest.push(50);
    pilhaTest.push(60);
    pilhaTest.push(70);
    assertFalse(pilhaTest.isEmpty());
    pilhaTest.pop();
    assertFalse(pilhaTest.isEmpty());
    pilhaTest.pop();
    assertFalse(pilhaTest.isEmpty());
    pilhaTest.pop();
    assertFalse(pilhaTest.isEmpty());
    pilhaTest.pop();
    assertFalse(pilhaTest.isEmpty());
    pilhaTest.pop();
    assertFalse(pilhaTest.isEmpty());
    pilhaTest.pop();
    assertFalse(pilhaTest.isEmpty());
    pilhaTest.pop();
    assertTrue(pilhaTest.isEmpty());
  }

  @Test
  public void peekQuandoPilhaIndiceDoisRetornaTrinta() {
    PilhaObj<Integer> pilhaTest = new PilhaObj<>(6);
    pilhaTest.push(10);
    pilhaTest.push(20);
    pilhaTest.push(30);
    assertEquals(30, pilhaTest.peek());
  }

  @Test
  public void popQuandoPilhaRetornaTrinta() {
    PilhaObj<Integer> pilhaTest = new PilhaObj<>(6);
    pilhaTest.push(10);
    pilhaTest.push(20);
    pilhaTest.push(30);
    assertEquals(30, pilhaTest.pop());
  }

  @Test
  public void pushLancaIllegalStateExceptionQuandoPilhaCheia() {
    PilhaObj<Integer> pilhaTest = new PilhaObj<>(6);
    pilhaTest.push(30);
    pilhaTest.push(40);
    pilhaTest.push(50);
    pilhaTest.push(60);
    pilhaTest.push(70);
    pilhaTest.push(80);
    assertThrows(IllegalStateException.class, () -> pilhaTest.push(90));
  }

  @Test
  public void pushQuandoPilhaRetornaTrinta() {
    PilhaObj<Integer> pilhaTest = new PilhaObj<>(6);
    pilhaTest.push(10);
    assertEquals(10, pilhaTest.peek());
    pilhaTest.push(20);
    assertEquals(20, pilhaTest.peek());
    pilhaTest.push(30);
    assertEquals(30, pilhaTest.peek());
  }
}
