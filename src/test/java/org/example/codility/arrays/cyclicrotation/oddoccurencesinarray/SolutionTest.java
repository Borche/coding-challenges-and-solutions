package org.example.codility.arrays.cyclicrotation.oddoccurencesinarray;

import org.example.codility.arrays.oddoccurencesinarray.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution s = new Solution();

  @Test
  void test() {
    Assertions.assertEquals(7, s.solution(new int[]{9,3,9,3,9,7,9}));
    Assertions.assertEquals(8, s.solution(new int[]{9,11,11,11,3,9,3,9,7,9,11,8,7,7,7}));
  }

}