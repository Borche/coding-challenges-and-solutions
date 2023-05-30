package org.example.codility.sorting.triangle;

import java.util.Arrays;

public class Solution {
  public int solution(int[] A) {
    // Implement your solution here
    Arrays.sort(A);

    int len = A.length;
    for (int i = 0; i < len - 2; i++) {
      long P = A[i], Q = A[i+1], R = A[i+2];
      if (P + Q > R
      && P + R > Q && Q + R > P) {
        return 1;
      }
    }

    return 0;
  }
}
