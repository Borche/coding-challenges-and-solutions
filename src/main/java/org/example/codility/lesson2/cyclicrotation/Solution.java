package org.example.codility.lesson2.cyclicrotation;

public class Solution {
  public int[] solution(int[] A, int K) {
    // Implement your solution here
    int[] newA = new int[A.length];

    for (int i = 0; i < A.length; i++) {
      if (i + K < A.length)
        newA[i + K] = A[i];
      else
        newA[(i + K) % A.length] = A[i];
    }

    return newA;
  }
}
