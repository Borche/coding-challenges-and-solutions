package org.example.other.denominations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  Solution s = new Solution();

  @Test
  void test() {
    assertArrayEquals(new int[]{0,1,1,1,0,1}, s.getChange(4.00, 3.14));
    assertArrayEquals(new int[]{6,1,1,1,0,4}, s.getChange(10.00, 3.11));
    assertArrayEquals(new int[]{6,1,1,1,1,2}, s.getChange(10.00, 3.08));
    assertArrayEquals(new int[]{5,0,1,1,1,1}, s.getChange(8.49, 3.08));
    assertArrayEquals(new int[]{0,0,0,0,0,4}, s.getChange(0.05, 0.01));
    assertArrayEquals(new int[]{4,1,1,2,0,2}, s.getChange(5.00, 0.03));
    assertArrayEquals(new int[]{0,0,1,0,0,0}, s.getChange(0.50, 0.25));

    // Paid the exact price
    assertArrayEquals(new int[]{0,0,0,0,0,0}, s.getChange(10.00, 10.00));
    assertArrayEquals(new int[]{0,0,0,0,0,0}, s.getChange(0.01, 0.01));
    assertArrayEquals(new int[]{0,0,0,0,0,0}, s.getChange(1.91, 1.91));
  }
}