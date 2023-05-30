package org.example.codility.sorting.maxproductofthree;

import java.util.Arrays;

public class Solution {
  public int solution(int[] A) {
    Arrays.sort(A);

    int len = A.length;

    int r1 = A[len-3] * A[len-2] * A[len-1];
    int r2 = A[0] * A[1] * A[len-1];
    return Math.max(r1, r2);
  }
}
