package datastructures.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.datastructures.queue.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
  private Queue<Integer> sut;

  @BeforeEach
  public void setUp() {
    sut = new Queue<>();
  }

  @Test
  public void canEnqueueIntoQueue() {
    sut.enqueue(1);
    assertFalse(sut.isEmpty());
  }

  @Test
  public void canEnqueueMultipleValuesIntoQueue() {
    sut.enqueue(1);
    sut.enqueue(2);
    sut.enqueue(3);

    assertEquals(1, sut.peek());
  }

  @Test
  public void canDequeueOutOfQueue() {
    sut.enqueue(1);
    sut.enqueue(2);
    int dequeuedValue = sut.dequeue();

    assertEquals(1, dequeuedValue);
    assertEquals(2, sut.peek());
  }

  @Test
  public void canPeekIntoQueue() {
    sut.enqueue(1);
    sut.enqueue(2);

    assertEquals(1, sut.peek());
  }

  @Test
  public void canEmptyQueueAfterMultipleDequeues() {
    sut.enqueue(1);
    sut.enqueue(2);
    sut.enqueue(3);

    sut.dequeue();
    sut.dequeue();
    sut.dequeue();

    assertTrue(sut.isEmpty());
  }

  @Test
  public void canInstantiateEmptyQueue() {
    assertTrue(sut.isEmpty());
  }

  @Test
  public void dequeueOnEmptyQueueRaisesException() {
    assertThrows(RuntimeException.class, () -> sut.dequeue());
  }

  @Test
  public void peekOnEmptyQueueRaisesException() {
    assertThrows(RuntimeException.class, () -> sut.peek());
  }
}
