package org.example.hackerrank.day6.jesseandcookies;

import java.io.*;
import java.math.*;
import java.security.*;
import java.sql.Array;
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
   * Complete the 'cookies' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY A
   */

  public static int cookies(int k, List<Integer> A) {
    // Write your code here
    PriorityQueue<Integer> queue = new PriorityQueue<>(A);

    int count = 0;
    while (queue.size() != 0 && queue.peek() < k) {
      if (queue.size() >= 2) {
        count++;
        int temp1 = queue.poll();
        int temp2 = queue.poll();
        queue.offer(temp1 + 2*temp2);
      } else {
        return -1;
      }
    }

    return count;
  }

  public static int cookies2(int k, List<Integer> A) {
    // Write your code here
    if (A.size() == 1) return A.get(0) >= k ? 0 : -1;

    if (sweetnessOK(k, A)) return 0;

    // if (A.stream().mapToInt(Integer::intValue).sum() < k) return -1;

    int timesMixed = 0;
    while (A.size() >= 2) {
      Collections.sort(A);
      Integer K = A.get(0) + A.get(1) * 2;
      A = new ArrayList<>(A.subList(2, A.size()));
      A.add(K);
      timesMixed++;

      if (sweetnessOK(k, A))
        return timesMixed;
    }

    return -1;
  }

  private static boolean sweetnessOK(int k, List<Integer> A) {
    return A.get(0) >= k && A.get(A.size() - 1) >= k;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    System.out.println(Result.cookies(9, Arrays.asList(2,7,3,6,4,6)));
    System.out.println(Result.cookies(7, Arrays.asList(1,2,3,9,10,12)));

    BufferedReader br = new BufferedReader(new FileReader("testdata/jesseandcookies.txt"));

    String[] firstMultipleInput = br.readLine().replaceAll("\\s+$", "").split(" ");

    int k = Integer.parseInt(firstMultipleInput[1]);

    long start = System.currentTimeMillis();
    List<Integer> A = Stream.of(br.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    System.out.println(Result.cookies(k, A)); // Correct: 67606
    long stop = System.currentTimeMillis();
    System.out.println(stop - start);
  }
}

