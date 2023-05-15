package org.example.codility.timecomplexity.permmissingelem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  Solution s = new Solution();

  @Test
  void test() {
    Assertions.assertEquals(4, s.solution(new int[]{2,3,1,5}));
    Assertions.assertEquals(9, s.solution(new int[]{11,2,3,12,1,5,4,6,7,8,10}));

    Assertions.assertEquals(1, s.solution(new int[]{}));
    Assertions.assertEquals(2, s.solution(new int[]{1}));
    Assertions.assertEquals(1, s.solution(new int[]{2}));
    Assertions.assertEquals(3, s.solution(new int[]{1,2}));
    Assertions.assertEquals(1, s.solution(new int[]{2,3}));
    Assertions.assertEquals(4, s.solution(new int[]{5,6}));
  }

}