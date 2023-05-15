package org.example.hackerrank.day4.mocktest;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;


class Result {

  /*
   * Complete the 'truckTour' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
   */

  public static int truckTour(List<List<Integer>> petrolpumps) {
    // Write your code here
    for (int i = 0; i < petrolpumps.size(); i++) {
      List<Integer> pump = petrolpumps.get(i);
      Integer amountOfPetrol = pump.get(0);
      Integer distanceToNext = pump.get(1);
      if (amountOfPetrol >= distanceToNext) {
        // Potential start pump
        if (canCompleteCircle(i, petrolpumps)) return i;
      }
    }

    return -1;
  }

  private static boolean canCompleteCircle(int startIndex, List<List<Integer>> petrolpumps) {
    int i = startIndex;
    boolean firstTime = true;
    int totalPetrolLeft = 0;
    while (true) {
      // Check if we completed circle
      if (i == startIndex && !firstTime) return true;

      int petrol = petrolpumps.get(i).get(0);
      int distance = petrolpumps.get(i).get(1);

      totalPetrolLeft += petrol;

      // If not enough total petrol, we can't continue
      if (totalPetrolLeft - distance < 0) return false;

      totalPetrolLeft -= distance;

      // Next
      i++;
      firstTime = false;
      if (i >= petrolpumps.size()) i = 0;
    }
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    List<List<Integer>> pumps = new ArrayList<>();

    pumps.add(Arrays.asList(1, 5));
    pumps.add(Arrays.asList(10, 3));
    pumps.add(Arrays.asList(3, 4));

    System.out.println(Result.truckTour(pumps));
  }
}

