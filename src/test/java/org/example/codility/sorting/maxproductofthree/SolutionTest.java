package org.example.codility.sorting.maxproductofthree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  
  Solution s = new Solution();
  
  @Test
  @DisplayName("test")
  void test() {
    assertEquals(60, s.solution(new int[]{-3,1,2,-2,5,6}));
  }

}