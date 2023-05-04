package src.test.java.datastructures.stack;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.datastructures.stack.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
  private Stack<Integer> sut;

  @BeforeEach
  public void setup() {
    sut = new Stack<>();
  }

  @Test
  public void canPushOntoStack() {
    sut.push(1);
    assertFalse(sut.isEmpty());
  }

  @Test
  public void canPushMultipleValuesOntoStack() {
    sut.push(1);
    sut.push(2);
    sut.push(3);

    assertEquals(3, sut.peek());
  }

  @Test
  public void canPopOffStack() {
    sut.push(1);
    sut.push(2);
    int poppedValue = sut.pop();

    assertEquals(2, poppedValue);
    assertEquals(1, sut.peek());
  }

  @Test
  public void canEmptyStackAfterMultiplePops() {
    sut.push(1);
    sut.push(2);
    sut.push(3);

    sut.pop();
    sut.pop();
    sut.pop();

    assertTrue(sut.isEmpty());
  }

  @Test
  public void canPeekNextItemOnStack() {
    sut.push(1);
    sut.push(2);
    sut.push(3);

    assertEquals(3, sut.peek());
  }

  @Test
  public void canInstantiateEmptyStack() {
    assertTrue(sut.isEmpty());
  }

  @Test
  public void popOnEmptyStackRaisesException() {
    assertThrows(RuntimeException.class, () -> sut.pop());
  }

  @Test
  public void peekOnEmptyStackRaisesException() {
    assertThrows(RuntimeException.class, () -> sut.peek());
  }
}
