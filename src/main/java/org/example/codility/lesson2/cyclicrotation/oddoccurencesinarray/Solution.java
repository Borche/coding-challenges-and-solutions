package org.example.codility.lesson2.cyclicrotation.oddoccurencesinarray;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int solution(int[] A) {
    // Implement your solution here
    Map<Integer, Integer> counts = new HashMap<>();

    for (int i : A) {
      int count = counts.get(i) == null ? 0 : counts.get(i);
      counts.put(i, count + 1);
    }

    for (Integer key : counts.keySet()) {
      if (counts.get(key) % 2 == 1) return key;
    }

    // Should never happen
    return -1;
  }
}
