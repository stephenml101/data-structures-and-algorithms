package src.test.java.datastructures.tree;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import src.main.java.datastructures.tree.BinarySearchTree;
import src.main.java.datastructures.tree.BinaryTree;
import src.main.java.datastructures.tree.Node;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {
  BinaryTree<Integer> sut;

  @BeforeEach
  void setUp() {
    sut = new BinaryTree<>(4);
    ((BinaryTree<Integer>) sut).getRoot().left = new Node<>(2);
    sut.getRoot().right = new Node<>(6);
  }

  @Test
  public void testInstantiateTreeWithSingleNode() {
    assertEquals(Optional.of(4), sut.getRoot().value);
  }

  @Test
  public void testPreOrderTraversal() {
    List<Integer> preOrder = sut.preOrderTraversal();
    assertEquals(Arrays.asList(4, 2, 6), preOrder);
  }

  @Test
  public void testInOrderTraversal() {
    List<Integer> inOrder = sut.inOrderTraversal();
    assertEquals(Arrays.asList(2, 4, 6), inOrder);
  }

  @Test
  public void testPostOrderTraversal() {
    List<Integer> postOrder = sut.postOrderTraversal();
    assertEquals(Arrays.asList(2, 6, 4), postOrder);
  }

  @Test
  public void testGetMax() {
    BinarySearchTree<Integer> tree = new BinarySearchTree<>(2);

    // [2, 7, 2, 6, 5, 11, 5, 9, 4]
    tree.add(7);
    tree.add(2);
    tree.add(6);
    tree.add(5);
    tree.add(11);
    tree.add(5);
    tree.add(9);
    tree.add(4);

    int expectedMax = 11;
    assertEquals(Optional.of(expectedMax), tree.getMax());
  }

}
