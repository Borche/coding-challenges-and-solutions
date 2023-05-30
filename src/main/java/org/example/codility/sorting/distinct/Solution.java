package org.example.codility.sorting.distinct;

import java.util.stream.IntStream;

public class Solution {
  public int solution(int[] A) {
    // Implement your solution here

    return (int) IntStream.of(A).distinct().count();
  }
}
