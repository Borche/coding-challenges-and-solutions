package org.example.hackerrank.day2.mocktest;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */
    public static int flippingMatrix(List<List<Integer>> matrix) {
        int N = matrix.size();

        int sum = 0;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                sum += max(matrix.get(i).get(j),
                        matrix.get(N - i - 1).get(j),
                        matrix.get(i).get(N - j - 1),
                        matrix.get(N - i - 1).get(N - j - 1));
            }
        }

        return sum;
    }

    public static int flippingMatrix2(List<List<Integer>> matrix) {
        // Write your code here
        int N = matrix.size();
        int[][] a = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = matrix.get(i).get(j);
            }
        }

        int sum = 0;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                sum += max(a[i][j], a[N - i - 1][j], a[i][N - j - 1], a[N - i - 1][N - j - 1]);
            }
        }

        return sum;
    }

    static int max(int a, int b, int c, int d) {
        return IntStream.of(a, b, c, d).max().getAsInt();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        System.out.println("Result: " + Result.flippingMatrix(buildMatrix()));

        // oldWay();
    }

    private static List<List<Integer>> buildMatrix() {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(112, 42, 83, 119)));
        matrix.add(new ArrayList<>(Arrays.asList(56, 125, 56, 49)));
        matrix.add(new ArrayList<>(Arrays.asList(15, 78, 101, 43)));
        matrix.add(new ArrayList<>(Arrays.asList(62, 98, 114, 108)));
        return matrix;
    }

    private static void oldWay() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = Result.flippingMatrix(matrix);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
