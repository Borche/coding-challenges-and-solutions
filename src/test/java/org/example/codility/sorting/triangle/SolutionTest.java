package org.example.codility.sorting.triangle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  
  Solution s = new Solution();
  
  @Test
  @DisplayName("test")
  void test() {
    assertEquals(1, s.solution(new int[]{10,2,5,1,8,20}));
  }

}