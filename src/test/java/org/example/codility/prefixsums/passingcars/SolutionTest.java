package org.example.codility.prefixsums.passingcars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  Solution s = new Solution();

  @Test
  void test() {
    assertEquals(5, s.solution(new int[]{0,1,0,1,1}));
    assertEquals(8, s.solution(new int[]{0,0,1,0,1,1}));
  }

}