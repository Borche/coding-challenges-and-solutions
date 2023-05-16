package org.example.hackerrank.day5.queueusingtwostacks;

import java.util.Scanner;
import java.util.Stack;

class Queue {

  private final Stack<Integer> stack1 = new Stack<>();
  private final Stack<Integer> stack2 = new Stack<>();

  public void enqueue(int e) {
    stack1.push(e);
  }

  public void dequeue() {
    if (stack2.empty()) {
      while (!stack1.empty()) {
        stack2.push(stack1.pop());
      }
    }
    stack2.pop();
  }

  public void printFirstElement() {
    if (!stack2.empty()) {
      System.out.println(stack2.peek());
    } else if (!stack1.empty()) {
      while (!stack1.empty()) {
        stack2.push(stack1.pop());
      }
      System.out.println(stack2.peek());
    } else {
      System.out.println("Queue is empty.");
    }
  }
}

public class Solution {
  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);

    Queue q = new Queue();

    System.out.print("Number of queries: ");
    int numQ = Integer.parseInt(in.nextLine());

    for (int i = 0; i < numQ; i++) {
      String input = in.nextLine();
      String[] inputTokens = input.split(" ");
      int type = Integer.parseInt(inputTokens[0]);

      switch (type) {
        case 1:
          q.enqueue(Integer.parseInt(inputTokens[1]));
          break;
        case 2:
          q.dequeue();
          break;
        case 3:
          q.printFirstElement();
          break;
      }
    }
    System.out.printf("All %d queries completed\n", numQ);

    in.close();
  }
}
