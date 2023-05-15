package org.example.hackerrank.day4.recursivedigitsum;

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {
        // Write your code here
        if (n.length() == 1 && k == 1) return Integer.parseInt(n);

        long sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += Character.getNumericValue(n.charAt(i));
        }
        sum *= k;

        return superDigit(Long.toString(sum), 1);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(Result.superDigit("9875", 4));

        BufferedReader br = new BufferedReader(new FileReader("longstring.txt"));
        StringBuilder sb = new StringBuilder();
        while (br.ready()) sb.append(br.readLine());
        System.out.println(Result.superDigit(sb.toString(), 10000));

        BufferedReader br2 = new BufferedReader(new FileReader("longstring2.txt"));
        StringBuilder sb2 = new StringBuilder();
        while (br2.ready()) sb2.append(br2.readLine());
        System.out.println(Result.superDigit(sb2.toString(), 10000));

        BufferedReader br3 = new BufferedReader(new FileReader("longstring3.txt"));
        StringBuilder sb3 = new StringBuilder();
        while (br3.ready()) sb3.append(br3.readLine());
        System.out.println(Result.superDigit(sb3.toString(), 10000));
    }

    /*public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }*/
}
