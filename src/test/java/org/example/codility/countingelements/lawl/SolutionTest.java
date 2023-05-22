package org.example.codility.countingelements.lawl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  Solution s = new Solution();

  @Test
  void test() {
    assertArrayEquals(
            new int[]{3,2,2,4,2},
            s.solution(5, new int[]{3,4,4,6,1,4,4}));

    assertArrayEquals(
            new int[]{4,1,1,1},
            s.solution(4, new int[]{1,5,5,5,1,1,1}));

    assertArrayEquals(
            new int[]{0},
            s.solution(1, new int[]{2}));

    assertArrayEquals(
            new int[]{1},
            s.solution(1, new int[]{1}));
  }
}