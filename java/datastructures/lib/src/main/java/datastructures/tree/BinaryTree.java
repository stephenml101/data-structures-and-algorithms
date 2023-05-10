package src.main.java.datastructures.tree;

import src.main.java.datastructures.linkedlist.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {
  protected Node<T> root;

  public BinaryTree(T value) {
    root = new Node<>(value);
  }

  public List<T> preOrderTraversal() {
    List<T> output = new ArrayList<>();
    preOrderTraversal(this.root, output);
    return output;
  }

  private void preOrderTraversal(Node<T> node, List<T> output) {
    if (node == null) return;

    output.add(node.value);
    preOrderTraversal(node.left, output);
    preOrderTraversal(node.right, output);
  }

  public List<T> inOrderTraversal() {
    List<T> output = new ArrayList<>();
    inOrderTraversal(this.root, output);
    return output;
  }

  private void inOrderTraversal(Node<T> node, List<T> output) {
    if (node == null) return;

    preOrderTraversal(node.left, output);
    output.add(node.value);
    preOrderTraversal(node.right, output);
  }

  public List<T> postOrderTraversal() {
    List<T> output = new ArrayList<>();
    postOrderTraversal(this.root, output);
    return output;
  }

  private void postOrderTraversal(Node<T> node, List<T> output) {
    if (node == null) return;

    postOrderTraversal(node.left, output);
    postOrderTraversal(node.right, output);
    output.add(node.value);
  }

  public void add(T value) {
    Queue<Node<T>> queue = (Queue<Node<T>>) new LinkedList();
    this.root = add(this.root, value, queue);
  }

  private Node<T> add(Node<T> node, T value, Queue<Node<T>> queue) {
    if (node == null) {
      return new Node<>(value);
    }

    if (node.left == null) {
      node.left = new Node<>(value);
      return node;
    } else if (node.right == null) {
      node.right = new Node<>(value);
      return node;
    } else {
      queue.add(node.left);
      queue.add(node.right);
      add(queue.poll(), value, queue);
    }

    return node;
  }


  public T getMax() {
    if (this.root == null) {
      throw new RuntimeException("Yo! Tree be empty!");
    }

    return getMax(this.root);
  }

  private T getMax(Node<T> node) {
    if (node == null) return null;

    T currentValue = node.value;
    T leftMax = getMax(node.left);
    T rightMax = getMax(node.right);
    T max = currentValue;
    if (leftMax != null && leftMax.compareTo(max) > 0) {
      max = leftMax;
    }
    if (rightMax != null && rightMax.compareTo(max) > 0) {
      max = rightMax;
    }

    return max;
  }

  public Node<T> getRoot() {
    return root;
  }

}

  //methods
//  public <T> void preOrder(Node<T> node){
//    ArrayList<T> arr = new ArrayList<T>();
//  // data logic
//    arr.add(node.value);
//    //left
//    preOrder(node.left);
//    //right
//    preOrder(node.right);
//  }
//
//  public <T> void inOrder(Node<T> node){
//    ArrayList<T> arr = new ArrayList<T>();
//    //left
//    inOrder(node.left);
//    // data logic
//    arr.add(node.value);
//    //right
//    inOrder(node.right);
//  }
//
//  public <T> void postOrder(Node<T> node){
//    ArrayList<T> arr = new ArrayList<T>();
//    //left
//    postOrder(node.left);
//    //right
//    postOrder(node.right);
//    // data logic
//    arr.add(node.value);
//
//  }





