package org.example.codility.arrays.cyclicrotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution s = new Solution();

  @Test
  void lawl() {
    Assertions.assertArrayEquals(
            new int[]{9,7,6,3,8},
            s.solution(new int[]{3,8,9,7,6}, 3));

    Assertions.assertArrayEquals(
            new int[]{0,0,0,0},
            s.solution(new int[]{0,0,0,0}, 1));

    Assertions.assertArrayEquals(
            new int[]{1,2,3,4},
            s.solution(new int[]{1,2,3,4}, 4));

    Assertions.assertArrayEquals(
            new int[]{3,4,1,2},
            s.solution(new int[]{1,2,3,4}, 2));
  }
}