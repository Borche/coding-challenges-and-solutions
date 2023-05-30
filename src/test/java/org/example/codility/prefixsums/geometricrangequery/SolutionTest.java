package org.example.codility.prefixsums.geometricrangequery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  Solution s = new Solution();
  
  @Test
  @DisplayName("test")
  void test() {
    assertEquals(2, s.solution("CAGCCTA", 2, 4));
    assertArrayEquals(new int[]{2,4,1}, s.solution("CAGCCTA", new int[]{2,5,0}, new int[]{4,5,6}));
  }
}