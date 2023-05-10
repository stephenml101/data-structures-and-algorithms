package src.main.java.datastructures.tree;


public class Node<T> {

  public T value = null;

  public Node<T> left;

  public Node<T> right;

  public Node(T value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}
