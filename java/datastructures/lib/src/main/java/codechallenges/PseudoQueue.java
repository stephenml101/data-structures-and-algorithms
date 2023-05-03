package src.main.java.codechallenges;


import java.util.Stack;

public class PseudoQueue<T>{

  Stack<T> front;
  Stack<T> back;

  PseudoQueue(){
    back = new Stack<>();
    front = new Stack<>();
  }

  T dequeue() {
    if(front.isEmpty()) {
      while(!back.isEmpty()){
        front.push(back.pop());
      }
    }
    return front.pop();
  }
  void enqueue(T value) {
    back.push(value);
  }

}
