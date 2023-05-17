package org.example.codility.countingelements.frogriverone;

import java.util.stream.IntStream;

public class Solution {
  public int solution(int X, int[] A) {
    // Implement your solution here
    int desiredSum = IntStream.range(1, X + 1).sum();
    int sum = 0;

    boolean[] hasBeenCounted = new boolean[100_000 + 1]; // All values default by default

    for (int i = 0; i < A.length; i++) {
      if (!hasBeenCounted[A[i]]) {
        sum += A[i];
        hasBeenCounted[A[i]] = true;
        if (sum == desiredSum) return i;
      }
    }

    return -1;
  }
}
