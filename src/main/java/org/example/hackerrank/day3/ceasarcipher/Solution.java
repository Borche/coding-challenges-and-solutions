package org.example.hackerrank.day3.ceasarcipher;

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    static char[] lower = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    static char[] upper = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static String caesarCipher(String s, int k) {
        // Write your code here
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(rotateLetter(s.charAt(i), k));
        }

        return sb.toString();
    }

    private static char rotateLetter(char c, int k) {
        if (!Character.isAlphabetic(c)) return c;
        if (Character.isUpperCase(c)) {
            for (int i = 0; i < upper.length; i++) {
                if (c == upper[i]) {
                    return shift(upper, i, k);
                }
            }
        } else {
            for (int i = 0; i < lower.length; i++) {
                if (c == lower[i]) {
                    return shift(lower, i, k);
                }
            }
        }
        return 'a';
    }

    private static char shift(char[] alphabet, int i, int k) {
        if (i + k > alphabet.length - 1) {
            return alphabet[(i + k) % (alphabet.length)];
        }
        return alphabet[i + k];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        String result = Result.caesarCipher("middle-Outz", 2);
        System.out.println("Expected: okffng-Qwvb");
        System.out.println("Result: " + result);
    }
}

