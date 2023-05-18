package org.example.codility.countingelements.permcheck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  Solution s = new Solution();

  @Test
  void test() {
    assertEquals(1, s.solution(new int[]{4,1,3,2}));
    assertEquals(0, s.solution(new int[]{4,1,3}));

    assertEquals(1, s.solution(new int[]{6,4,1,3,5,2,7,9,8}));
    assertEquals(0, s.solution(new int[]{6,4,1,3,2,7,9,8}));

    assertEquals(0, s.solution(new int[]{2}));
  }

}