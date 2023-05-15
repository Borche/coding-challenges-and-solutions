package org.example.hackerrank.day4.gridchallenge;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        for (int row = 0; row < grid.size(); row++) {
            String s = grid.get(row);
            String[] chars = s.split("");
            Arrays.sort(chars);
            grid.set(row, String.join("", chars));
        }

        for (int col = 0; col < grid.get(0).length(); col++) {
            for (int row = 0; row < grid.size() - 1; row++) {
                String r1 = grid.get(row);
                String r2 = grid.get(row + 1);
                if (r1.charAt(col) > r2.charAt(col)) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> grid = new ArrayList<>();
        grid.add("ebacd");
        grid.add("fghij");
        grid.add("olmkn");
        grid.add("trpqs");
        grid.add("xywuv");
        System.out.println(Result.gridChallenge(grid));

        List<String> grid2 = new ArrayList<>();
        grid2.add("cba");
        grid2.add("xuv");
        grid2.add("kli");
        System.out.println(Result.gridChallenge(grid2));

        List<String> grid3 = new ArrayList<>();
        grid3.add("abc");
        grid3.add("lmp");
        grid3.add("qrt");
        System.out.println(Result.gridChallenge(grid3));

        List<String> grid4 = new ArrayList<>(Arrays.asList("mpxz", "abcd", "wlmf"));
        System.out.println(Result.gridChallenge(grid4));

        List<String> grid5 = new ArrayList<>(Arrays.asList("abc", "hjk", "mpq", "rtv"));
        System.out.println(Result.gridChallenge(grid5));
    }
}

