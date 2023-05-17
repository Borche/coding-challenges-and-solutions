package org.example.hackerrank.day6.legoblocks;

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result {

  /*
   * Complete the 'legoBlocks' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER m
   */

  public static int legoBlocks(int n, int m) {
    if (m == 1) return 1;

    return (A(m, n) - sumX(m, n)) % (1_000_000_000 - 7);
  }

  private static int sumX(int W, int H) {
    int sum = 0;
    for (int X = 1; X < W; X++)
      sum += legoBlocks(H, X) * A(W-X, H);
    return sum;
  }

  private static int A(int W, int H) {
    return (int) Math.pow(T(W), H);
  }

  // Calculate tetranacci value
  private static int T(int X) {
    if (X < 0) return 0;
    if (X == 0) return 1;
    return T(X - 1) + T(X - 2) + T(X - 3) + T(X - 4);
  }


}

public class Solution {
  public static void main(String[] args) throws IOException {
    int result = Result.legoBlocks(2, 2);
    // assert result == 3;
    System.out.println(result);


    result = Result.legoBlocks(3, 2);
    // assert result == 7;
    System.out.println(result);


    result = Result.legoBlocks(2, 3);
    // assert result == 9;
    System.out.println(result);

    // System.out.println(Result.legoBlocks(3,3));

    result = Result.legoBlocks(4, 4);
    assert result == 3375;
    System.out.println(result);
  }
}

