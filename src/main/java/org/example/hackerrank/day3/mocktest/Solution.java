package org.example.hackerrank.day3.mocktest;

import java.io.*;

import static java.util.stream.Collectors.joining;


class Result {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
        // Write your code here
        for (int left = 0; left < s.length() / 2; left++) {
            int right = s.length() - 1 - left;
            if (s.charAt(left) != s.charAt(right)) {
                if (isPalindrome(s, left + 1, right)) return left;
                else if (isPalindrome(s, left, right - 1)) return right;
                else break;
            }
        }
        return -1;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        for (int left = start, right = end; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) return false;
        }
        return true;
    }

    public static int palindromeIndex2(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        if (start >= end) return -1; // already a palindrome
        // We need to delete here
        if (isPalindrome2(s, start + 1, end)) return start;
        if (isPalindrome2(s, start, end - 1)) return end;
        return -1;
    }

    public static boolean isPalindrome2(String s, int start, int end) {
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        String s = "morom";
        System.out.println("Result: " + Result.palindromeIndex(s));
        System.out.println("Result: " + Result.palindromeIndex2(s));
    }
}

