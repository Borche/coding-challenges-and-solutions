package org.example.hackerrank.day5.mocktest;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

  /*
   * Complete the 'pairs' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY arr
   */

  public static int pairs(int k, List<Integer> arr) {
    Collections.sort(arr);

    int count = 0, j = 1;
    for (int i = 0; i < arr.size(); i++) {
      while (j < arr.size()) {
        if (arr.get(j) - arr.get(i) == k) count++;
        else if (arr.get(j) - arr.get(i) > k) break;
        j++;
      }
    }
    return count;
  }

  public static int pairsOld(int k, List<Integer> arr) {
    // Write your code here
    Collections.sort(arr, Collections.reverseOrder());

    int count = 0;
    for (int i = 0; i < arr.size() - 1; i++) {
      Integer i1 = arr.get(i);

      for (int j = i + 1; j < arr.size(); j++) {
        if (Math.abs(i1 - arr.get(j)) == k) {
          count++;
          break;
        }
      }
    }

    return count;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    System.out.println(Result.pairs(2, Arrays.asList(1,5,3,4,2)));
    System.out.println(Result.pairs(1, Arrays.asList(1,5,3,4,2)));
    System.out.println(Result.pairs(1, Arrays.asList(1,2)));
  }
}

