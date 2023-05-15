package org.example.codility.iterations.binarygap;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public int solution73(int N) {
    // Implement your solution here

    String b = Integer.toBinaryString(N);

    int i = 1, count = 0, biggest = 0;
    while (i < b.length()) {
      if (b.charAt(i) == '0' && b.charAt(i - 1) == '1') {
        count++;

        for (int forth = i + 1; forth < b.length(); forth++) {
          if (b.charAt(forth) == '1') {
            if (count > biggest) {
              biggest = count;
            }

            // Update while condition
            count = 0;
            i = forth + 1;

            break;
          } else if (forth == b.length() - 1 && b.charAt(forth) == '0') {
            return biggest;
          } else {
            count++;
          }
        }
      } else {
        i++;
      }
    }

    return biggest;
  }

  public int solution(int N) {
    String b = Integer.toBinaryString(N);

    List<Integer> indexes = new ArrayList<>();
    for (int i = 0; i < b.length(); i++) {
      if (b.charAt(i) == '1') indexes.add(i);
    }

    if (indexes.size() < 2) return 0;

    int diff = 0;

    for (int i = 1; i < indexes.size(); i++) {
      if (indexes.get(i) - indexes.get(i - 1) - 1 > diff) {
        diff = indexes.get(i) - indexes.get(i - 1) - 1;
      }
    }

    return diff;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().solution(1041));
    System.out.println(new Solution().solution(281));
    System.out.println(new Solution().solution(16000));
    System.out.println(new Solution().solution(1792));
  }
}
