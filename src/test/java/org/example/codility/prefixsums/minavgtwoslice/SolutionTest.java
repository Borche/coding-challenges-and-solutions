package org.example.codility.prefixsums.minavgtwoslice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  
  Solution s = new Solution();
  
  @Test
  @DisplayName("test")
  void test() {
    assertEquals(1, s.solution(new int[]{4,2,2,5,1,5,8}));
    assertEquals(4, s.solution(new int[]{4,2,2,5,1,1,5,8}));
    assertEquals(4, s.solution(new int[]{4,2,2,100,1,1,5,8}));
  }

}