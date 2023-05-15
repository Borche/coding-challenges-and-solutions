package org.example.hackerrank.day4.newyearchaos;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribesFirst(List<Integer> q) {
        // Write your code here
        int bribeCount = 0;

        for (int i = 0; i < q.size() - 1; i++) {
            Integer current = q.get(i);
            int currentCount = 0;
            for (int j = i + 1; j < q.size(); j++) {
                Integer next = q.get(j);

                if (current > next) {
                    currentCount++;
                }

                if (currentCount >= 3) {
                    System.out.println("Too chaotic");
                    return;
                }
            }
            bribeCount += currentCount;
        }

        System.out.println(bribeCount);
    }

    public static void minimumBribesIncorrect(List<Integer> q) {
        // Write your code here
        int totalBribeCount = 0;

        for (int currentIndex = 0; currentIndex < q.size() - 1; currentIndex++) {
            Integer currentNumber = q.get(currentIndex);
            Integer nextNumber = q.get(currentIndex + 1);
            int originalIndex = currentNumber - 1;

            if (currentIndex < originalIndex) {
                // Has bribed
                int bribeCount = originalIndex - currentIndex;
                if (bribeCount >= 3) {
                    System.out.println("Too chaotic");
                    return;
                } else {
                    totalBribeCount += bribeCount;
                }
            } else if (currentNumber > nextNumber) {
                totalBribeCount++;
            }
        }

        System.out.println(totalBribeCount);
    }

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int MAX_BRIBES_PER_PERSON = 2;
        int bribeCount = 0;

        for (int index = 0; index < q.size(); index++) {
            Integer current = q.get(index);
            int orgIndex = current - 1;

            if (orgIndex - index > MAX_BRIBES_PER_PERSON) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, orgIndex + 1 - MAX_BRIBES_PER_PERSON); j < index; j++) { // orgIndex + 1 = orgIndex of next orgElement
                if (q.get(j) > current) bribeCount++;
            }
        }

        System.out.println(bribeCount);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> q1 = Arrays.asList(2,1,5,3,4);
        List<Integer> q2 = new ArrayList<>(Arrays.asList(2,5,1,3,4));
        List<Integer> q3 = new ArrayList<>(Arrays.asList(1,2,3,4,5,10,7,6,8,9));
        List<Integer> q4 = new ArrayList<>(Arrays.asList(1,7,2,3,4,5,10,6,8,9));
        List<Integer> q5 = new ArrayList<>(Arrays.asList(2,1,3,5,7,4,6,8,9,10));
        List<Integer> q6 = new ArrayList<>(Arrays.asList(1,2,5,3,7,8,6,4));
        List<Integer> q7 = new ArrayList<>(Arrays.asList(1,5,2,3,7,8,6,4));

        Result.minimumBribes(q1);
        Result.minimumBribes(q2);
        Result.minimumBribes(q3);
        Result.minimumBribes(q4);
        Result.minimumBribes(q5);
        Result.minimumBribes(q6);
        Result.minimumBribes(q7);
    }
}

