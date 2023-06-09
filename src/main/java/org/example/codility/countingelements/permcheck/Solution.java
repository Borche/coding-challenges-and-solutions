package org.example.codility.countingelements.permcheck;

import java.util.Arrays;

public class Solution {
  public int solution(int[] A) {
    // Implement your solution here
    Arrays.sort(A);
    if (A[0] != 1) return 0;

    for (int i = 0; i < A.length - 1; i++) {
      if (A[i] != A[i + 1] - 1) return 0;
    }

    return 1;
  }
}
