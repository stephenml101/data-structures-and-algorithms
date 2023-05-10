package src.test.java.datastructures.tree;

import src.main.java.datastructures.tree.BinarySearchTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
  BinarySearchTree<Integer> sut;

  @BeforeEach
  void setUp() {
    sut = new BinarySearchTree<>(4);
  }

  @Test
  void testAddLeftAndRightChild() {
    sut.add(2); // left child
    sut.add(6); // right child

    assertEquals(2, sut.getRoot().left.value);
    assertEquals(6, sut.getRoot().right.value);
  }

  @Test
  void testContains() {
    sut.add(2);
    sut.add(6);
    sut.add(1);
    sut.add(3);
    sut.add(5);
    sut.add(7);

    assertTrue(sut.contains(3));
    assertFalse(sut.contains(8));
  }
}
