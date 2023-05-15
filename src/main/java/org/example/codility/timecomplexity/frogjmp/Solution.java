package org.example.codility.timecomplexity.frogjmp;

public class Solution {
  public int solution(int X, int Y, int D) {
    // Implement your solution here
    int distanceLeft = Y - X;

    double exactJumpsRequired = (double) distanceLeft / D;

    return (int) Math.ceil(exactJumpsRequired);
  }
}
