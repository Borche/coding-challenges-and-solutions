package org.example.codility.countingelements.lawl;

public class Solution {
  public int[] solution(int N, int[] A) {
    // Implement your solution here
    int[] counters = new int[N];
    int MAX_COUNTER = N + 1;

    int max = 0, last = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == MAX_COUNTER) {
        // op: max counter
        if (last < max) last = max;
      } else {
        // op: increase(X)
        int ci = A[i] - 1;
        if (counters[ci] < last) counters[ci] = last;
        int check = ++counters[ci];
        if (check > max) max = check;
      }
    }

    for (int i = 0; i < counters.length; i++) {
      if (counters[i] < last) counters[i] = last;
    }

    return counters;
  }
}
