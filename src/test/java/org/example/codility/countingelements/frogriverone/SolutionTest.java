package org.example.codility.countingelements.frogriverone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  Solution s = new Solution();

  @Test
  void test() {
    assertEquals(6, s.solution(5, new int[] {1,3,1,4,2,3,5,4}));
    assertEquals(11, s.solution(4, new int[] {4,3,2,2,2,2,2,2,2,2,2,1}));
  }

}