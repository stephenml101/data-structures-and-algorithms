package src.main.java.datastructures.tree;

import src.main.java.datastructures.tree.Node;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

  public BinarySearchTree(T value) {
    super(value);
  }

  public void add(T value) {
    this.root = add(this.root, value);
  }

  protected Node<T> add(Node<T> node, T value) {
    if (node == null) {
      return new Node<>(value);
    }

    int cmp = value.compareTo(node.value);
    if (cmp < 0) {
      node.left = add(node.left, value);
    } else if (cmp > 0) {
      node.right = add(node.right, value);
    } else {
      // Value already exists in the tree; ignore the new value.
    }

    return node;
  }

  public boolean contains(T value) {
    return contains(this.root, value);
  }

  private boolean contains(Node<T> node, T value) {
    if (node == null) {
      return false;
    }

    int comparable = value.compareTo(node.value);
    if (comparable < 0) {
      return contains(node.left, value);
    } else if (comparable > 0) {
      return contains(node.right, value);
    } else {
      return true;
    }
  }
}

