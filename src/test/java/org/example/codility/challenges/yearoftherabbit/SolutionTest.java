package org.example.codility.challenges.yearoftherabbit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  Solution s = new Solution();

  @Test
  void test() {
    assertEquals(2, s.solution(new int[]{1,3,5,2,8,7}, new int[]{7, 1, 9, 8, 5, 7}));
    assertEquals(-1, s.solution(new int[]{1, 1, 1, 1}, new int[]{1, 2, 3, 4}));
    assertEquals(0, s.solution(new int[]{3, 5, 0, 2, 4}, new int[]{1, 3, 10, 6, 7}));
  }

}