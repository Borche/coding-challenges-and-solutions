package org.example.hackerrank.day1.two;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here

        List<Long> a = arr.stream().map(Long::valueOf).collect(Collectors.toList());
        Collections.sort(a);
        long min = a.get(0) + a.get(1) + a.get(2) + a.get(3);
        long max = a.get(1) + a.get(2) + a.get(3) + a.get(4);
        System.out.printf("%d %d%n", min, max);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}

