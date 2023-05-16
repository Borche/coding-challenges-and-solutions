package org.example.codility.timecomplexity.tapeequilibrium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  Solution s = new Solution();

  @Test
  void test() {
    Assertions.assertEquals(1, s.solution(new int[] {3,1,2,4,3}));
    Assertions.assertEquals(28, s.solution(new int[] {3,1,21,44,2,4,3}));
    Assertions.assertEquals(2000, s.solution(new int[] {1,2001}));
    Assertions.assertEquals(2000, s.solution(new int[] {2001,1}));
    Assertions.assertEquals(2000, s.solution(new int[] {-1000,1000}));
    Assertions.assertEquals(2000, s.solution(new int[] {1000,-1000}));
    Assertions.assertEquals(1, s.solution(new int[] {1,1,3}));
  }
}