package org.example.codility.countingelements.missinginteger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  Solution s = new Solution();

  @Test
  void test() {
    assertEquals(5, s.solution(new int[]{1,3,6,4,1,2}));
    assertEquals(1, s.solution(new int[]{-1, -3}));
    assertEquals(9, s.solution(new int[]{2,3,1,-1000_000,8,7,6,5,4,10,11,12}));

    assertEquals(1, s.solution(new int[]{2}));
    assertEquals(2, s.solution(new int[]{1}));
  }

  @Test
  void test2() {
    int[] A = new int[100_000];

    int number = -32_345;
    for (int i = 0; i < A.length; i++, number++) {
      if (number == 49_255) continue;
      A[i] = number;
    }

    assertEquals(49_255, s.solution(A));
  }
}