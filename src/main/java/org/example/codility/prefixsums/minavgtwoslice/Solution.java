package org.example.codility.prefixsums.minavgtwoslice;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  public int solution(int[] A) {
    // Implement your solution here
    double minAvg = (A[0] + A[1]) / 2.0;
    int minAvgIndex = 0;

    for (int i = 0; i < A.length - 2; i++) {
      if ((A[i] + A[i+1]) / 2.0 < minAvg) {
        minAvg = (A[i] + A[i+1]) / 2.0;
        minAvgIndex = i;
      }
      if ((A[i] + A[i+1] + A[i+2]) / 3.0 < minAvg) {
        minAvg = (A[i] + A[i+1] + A[i+2]) / 3.0;
        minAvgIndex = i;
      }
    }

    if ((A[A.length-2] + A[A.length-1]) / 2.0 < minAvg) {
      minAvgIndex = A.length-2;
    }

    return minAvgIndex;
  }
}
