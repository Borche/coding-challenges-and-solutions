package org.example.hackerrank.day3.towerbreakers;

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int towerBreakers(int n, int m) {
        // Write your code here
        return (m == 1 || n % 2 == 0) ? 2 : 1;

        // OLD CODE
        /*int currPlayer = 1;
        int[] tHeights = new int[n];

        // init all towers' heights
        for (int i = 0; i < n; i++) tHeights[i] = m;

        int towersLeft = 0;
        int maxLeft = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (tHeights[i] > 1) towersLeft++;
                if (tHeights[i] == m) maxLeft++;
            }
            if (towersLeft == 0) break;
            if (maxLeft > 0) {
                for (int i = 0; i < n; i++) {
                    if (tHeights[i] == m) {
                        if (towersLeft > 1) {
                            tHeights[i] = findNewHeight(m);
                        } else {
                            tHeights[i] = 1;
                        }
                        break;
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    if (tHeights[i] > 1 && towersLeft == 1) {
                        tHeights[i] = 1;
                        break;
                    } else if (tHeights[i] > 1 && towersLeft > 1) {
                        tHeights[i] = findNewHeight(tHeights[i]);
                        break;
                    }
                }
            }
            currPlayer = currPlayer == 1 ? 2 : 1;
            towersLeft = 0;
            maxLeft = 0;
        }

        return currPlayer == 1 ? 2 : 1;*/
    }

    private static int findNewHeight(int x) {
        for (int i = x - 1; i >= 1; i--) {
            if (x % i == 0) return i;
        }
        return 1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println("Player " + Result.towerBreakers(2, 6) + " wins.");
        System.out.println("Player " + Result.towerBreakers(1, 4) + " wins.");
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.towerBreakers(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}

