package org.example.hackerrank.day5.mergetwosortedlinkedlists;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  static class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
  }

  static class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
      }

      this.tail = node;
    }
  }

  public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
    while (node != null) {
      System.out.print(String.valueOf(node.data));

      node = node.next;

      if (node != null) {
        System.out.print(sep);
      }
    }
  }

  // Complete the mergeLists function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     int data;
   *     SinglyLinkedListNode next;
   * }
   *
   */
  static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    if (head1 == null) return head2;
    if (head2 == null) return head1;

    SinglyLinkedList result = new SinglyLinkedList();
    while (head1 != null && head2 != null) {
      if (head1.data <= head2.data) {
        result.insertNode(head1.data);
        head1 = head1.next;
      } else {
        result.insertNode(head2.data);
        head2 = head2.next;
      }
    }

    // Since we exited loop above, one of the lists has been exhausted
    // Fill up with elements from remaining list
    SinglyLinkedListNode rest = head1 != null ? head1 : head2;
    while (rest != null) {
      result.insertNode(rest.data);
      rest = rest.next;
    }

    return result.head;
  }

  public static void main(String[] args) throws IOException {
    SinglyLinkedList llist1 = new SinglyLinkedList();
    llist1.insertNode(1);
    llist1.insertNode(3);
    llist1.insertNode(9);
    llist1.insertNode(15);
    llist1.insertNode(18);
    llist1.insertNode(21);

    SinglyLinkedList llist2 = new SinglyLinkedList();
    llist2.insertNode(1);
    llist2.insertNode(2);
    llist2.insertNode(9);
    llist2.insertNode(13);
    llist2.insertNode(25);
    llist2.insertNode(27);
    llist2.insertNode(30);

    SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

    printSinglyLinkedList(llist3, " ");
  }
}

