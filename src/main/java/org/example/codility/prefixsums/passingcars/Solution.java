package org.example.codility.prefixsums.passingcars;

public class Solution {
  public int solution(int[] A) {
    int count = 0, sum = 0;

    for (int i = 0; i < A.length; i++) {
      if (A[i] == 0) count++;
      else sum += count;

      if (sum > 1_000_000_000) return -1;
    }

    return sum;
  }
}