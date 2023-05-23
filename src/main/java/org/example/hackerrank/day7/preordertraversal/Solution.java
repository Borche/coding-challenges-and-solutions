package org.example.hackerrank.day7.preordertraversal;

import java.util.*;
import java.io.*;

class Node {
  Node left;
  Node right;
  int data;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

public class Solution {

/* you only have to complete the function given below.
Node is defined as

class Node {
    int data;
    Node left;
    Node right;
}

*/

  public static void preOrder(Node root) {
    if (root == null) return;
    System.out.println(root.data);
    preOrder(root.left);
    preOrder(root.right);
  }

  public static Node insert(Node root, int data) {
    if(root == null) {
      return new Node(data);
    } else {
      Node cur;
      if(data <= root.data) {
        cur = insert(root.left, data);
        root.left = cur;
      } else {
        cur = insert(root.right, data);
        root.right = cur;
      }
      return root;
    }
  }

  public static void main(String[] args) {
    int[] nodeData = new int[]{1,2,5,6,3,4};
    Node root = null;
    for (int i = 0; i < nodeData.length; i++) {
      int data = nodeData[i];
      root = insert(root, data);
    }
    preOrder(root);
  }
}
