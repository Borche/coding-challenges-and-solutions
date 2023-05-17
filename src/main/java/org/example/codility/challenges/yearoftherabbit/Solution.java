package org.example.codility.challenges.yearoftherabbit;

public class Solution {
  public int solution(int[] A, int[] B) {
    if (A.length == 0) return 0;
    if (A.length == 1 && A[0] == B[0]) return -1;

    int rotations = 0;
    while (rotations < A.length) {
      if (validSolution(A, B)) return rotations;

      B = rotateRight(B);
      rotations++;
    }

    return -1;
  }

  private int[] rotateRight(int[] B) {
    int[] result = new int[B.length];
    for (int i = 0; i < B.length; i++) {
      result[(i + 1) % B.length] = B[i];
    }
    return result;
  }

  private boolean validSolution(int[] A, int[] B) {
    for (int i = 0; i < A.length; i++) {
      if (A[i] == B[i]) return false;
    }
    return true;
  }
}
