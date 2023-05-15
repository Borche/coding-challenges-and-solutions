package org.example.codility.timecomplexity;

import org.example.codility.timecomplexity.frogjmp.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  Solution s = new Solution();

  @Test
  void test() {
    Assertions.assertEquals(3, s.solution(10, 85, 30));
    Assertions.assertEquals(4, s.solution(5, 12, 2));
  }
}