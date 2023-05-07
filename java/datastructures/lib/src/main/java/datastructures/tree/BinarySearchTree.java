package src.main.java.datastructures.tree;

import src.main.java.datastructures.tree.Node;

public class BinarySearchTree extends BinaryTree {
  public BinarySearchTree() {
    super();
  }

  public void add(int value) {
    root = addHelper(root, value);
  }

  private Node addHelper(Node node, int value) {
    if (node == null) {
      node = new Node(value);
      return node;
    }

    if (value < node.value) {
      node.left = addHelper(node.left, value);
    } else if (value > node.value) {
      node.right = addHelper(node.right, value);
    }

    return node;
  }

  public boolean contains(int value) {
    return containsHelper(root, value);
  }

  private boolean containsHelper(Node node, int value) {
    if (node == null) return false;

    if (value == node.value) return true;

    if (value < node.value) {
      return containsHelper(node.left, value);
    } else {
      return containsHelper(node.right, value);
    }
  }
