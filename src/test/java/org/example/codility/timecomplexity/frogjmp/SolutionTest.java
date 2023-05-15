package org.example.codility.timecomplexity.frogjmp;

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