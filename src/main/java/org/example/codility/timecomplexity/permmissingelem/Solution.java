package org.example.codility.timecomplexity.permmissingelem;

import java.util.Arrays;

public class Solution {
  public int solution(int[] A) {
    // Implement your solution here
    if (A.length == 0) return 1;
    if (A.length == 1) return A[0] == 1 ? 2 : A[0] - 1;

    Arrays.sort(A);

    for (int i = 0; i < A.length - 1; i++) {
      if (A[i] + 1 != A[i + 1]) {
        return A[i] + 1;
      }
    }

    // First or last missing
    return A[0] != 1 ? A[0] - 1 : A[A.length - 1] + 1;
  }
}
