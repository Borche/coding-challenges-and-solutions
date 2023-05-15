package org.example.hackerrank.day1.one;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here

        int pos = 0, neg = 0, zer = 0;
        for (Integer i : arr) {
            if (i > 0) pos++;
            else if (i < 0) neg++;
            else zer++;
        }

        System.out.printf(Locale.US, "%.6f%n", pos / (double) arr.size());
        System.out.printf(Locale.US, "%.6f%n", neg / (double) arr.size());
        System.out.printf(Locale.US, "%.6f%n", zer / (double) arr.size());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

