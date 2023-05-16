package org.example.codility.timecomplexity.tapeequilibrium;

public class Solution {

  public int solution(int[] A) {
    if (A.length == 2) return Math.abs(A[0] - A[1]);

    int sumL = A[0], sumR = 0;

    for (int i = 1; i < A.length; i++) sumR += A[i];

    int smallestDiffSoFar = Math.abs(sumL - sumR);

    for (int P = 1; P < A.length; P++) {
      if (Math.abs(sumL - sumR) < smallestDiffSoFar) {
        smallestDiffSoFar = Math.abs(sumL - sumR);
      }
      sumL += A[P];
      sumR -= A[P];
    }

    return smallestDiffSoFar;
  }

  public int solutionOld(int[] A) {
    // Implement your solution here
    int sum = 0;
    for (int a : A) sum += Math.abs(a);

    int half = sum / 2;

    int sum1 = 0, sum1Real = 0;
    int diff = Integer.MAX_VALUE;
    int i;
    for (i = 0; i < A.length; i++) {
      sum1Real += A[i];
      sum1 += Math.abs(A[i]);
      if (Math.abs(half - sum1) < diff) {
        diff = half - sum1;
      } else {
        sum1Real -= A[i];
        break;
      }
    }

    int sum2 = 0;
    for (int j = i; j < A.length; j++) {
      sum2 += A[j];
    }

    return Math.abs(sum2 - sum1Real);
  }
}
