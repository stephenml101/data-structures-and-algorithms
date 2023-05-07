package src.main.java.datastructures.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree {
  Node root;

  public BinaryTree() {
    root = null;
  }

  public int[] preorderTraversal() {
    List<Integer> result = new ArrayList<>();
    preorderTraversalHelper(root, result);
    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  private void preorderTraversalHelper(Node node, List<Integer> result) {
    if (node == null) return;
    result.add((Integer) node.value);
    preorderTraversalHelper(node.left, result);
    preorderTraversalHelper(node.right, result);
  }

  public int[] inorderTraversal() {
    List<Integer> result = new ArrayList<>();
    inorderTraversalHelper(root, Collections.singletonList(result));
    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  private void inorderTraversalHelper(Node node, List<Object> result) {
    if (node == null) return;
    inorderTraversalHelper(node.left, result);
    result.add(node.value);
    inorderTraversalHelper(node.right, result);
  }

  public int[] postorderTraversal() {
    List<Integer> result = new ArrayList<>();
    postorderTraversalHelper(root, Collections.singletonList(result));
    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  private void postorderTraversalHelper(Node node, List<Object> result) {
    if (node == null) return;
    postorderTraversalHelper(node.left, result);
    postorderTraversalHelper(node.right, result);
    result.add(node.value);
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




}
