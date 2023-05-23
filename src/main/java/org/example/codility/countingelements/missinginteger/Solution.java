package org.example.codility.countingelements.missinginteger;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
  public int solution(int[] A) {
    // Implement your solution here
    int[] B = IntStream.of(A).filter(n -> n > 0).distinct().toArray();
    Arrays.sort(B);

    int i = 0, expected = 1;
    while (i < B.length) {
      if (B[i] != expected) return expected;
      expected++;
      i++;
    }

    return expected;
  }
}
