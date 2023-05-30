package org.example.codility.prefixsums.countdiv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  Solution s = new Solution();

  @Test
  void test() {
    assertEquals(6, s.solution(0, 10, 2));
    assertEquals(54054055, s.solution(0, 2_000_000_000, 37));

    assertEquals(3, s.solution(5, 12, 3));
    assertEquals(2, s.solution(7, 25, 10));

    assertEquals(3, s.solution(6, 11, 2));

  }

  @Test
  void problems() {
    assertAll("Problem test cases with K = 11",
      () -> assertEquals(1, s.solution(0, 0, 11)),
      () -> assertEquals(0, s.solution(1, 1, 11)),
      () -> assertEquals(1, s.solution(0, 1, 11)),
      () -> assertEquals(1, s.solution(10, 11, 11)),
      () -> assertEquals(0, s.solution(10, 10, 11)),
      () -> assertEquals(1, s.solution(22, 22, 11), "Test case (22, 22, 11)"),
      () -> assertEquals(1, s.solution(23, 43, 11), "Test case (23, 43, 11)")
    );
  }
}