package org.example.hackerrank.day7.noprefixset;

import java.io.*;
import java.math.*;
import java.security.*;
import java.sql.Array;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'noPrefix' function below.
   *
   * The function accepts STRING_ARRAY words as parameter.
   */

  public static void noPrefix2(List<String> words) {
    // Write your code here
    if (words.size() != 1) {
      Set<String> prefixes = new HashSet<>();
      List<String> wordsToSearch = new ArrayList<>();

      for (int i = 0; i < words.size(); i++) {
        String word = words.get(i);
        if (prefixes.contains(word)) {
          System.out.println("BAD SET");
          System.out.println(word);
          return;
        }
        wordsToSearch.add(word);
        char[] letters = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < letters.length; j++) {
          String prefix = sb.append(letters[j]).toString();
          int index = wordsToSearch.indexOf(prefix);
          if (index < i && index != -1) {
            System.out.println("BAD SET");
            System.out.println(word);
            return;
          }
          prefixes.add(prefix);
        }
      }
    }

    System.out.println("GOOD SET");
  }

  public static void noPrefix(List<String> words) {
    // Write your code here
    if (words.size() != 1) {

      Collections.sort(words);

      for (int i = 1; i < words.size(); i++) {
        for (int j = 0; j < i; j++) {
          String current = words.get(i);
          String previous = words.get(j);

          if (current.indexOf(previous) == 0 || previous.indexOf(current) == 0) {
            System.out.println("BAD SET");
            System.out.println(current);
            return;
          }
        }
      }
    }

    System.out.println("GOOD SET");
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    Result.noPrefix(Arrays.asList("aab", "defgab", "abcde", "aabcde", "cedaaa", "bbbbbbbbbb", "jabjjjad"));

    Result.noPrefix(Arrays.asList("abcd", "bcd", "abcde", "bcde"));

    Result.noPrefix(Arrays.asList("aab", "aac", "aacghgh", "aabghgh"));

    Result.noPrefix(Arrays.asList("aab"));

    Result.noPrefix(Arrays.asList("aaaaaabbbbbbccccccddddddeeeeee", "aaaaaaabbbbbbccccccddddddeeeeee"));
    Result.noPrefix(Arrays.asList("abc", "abc"));

    BufferedReader br = new BufferedReader(new FileReader("testdata/noprefixdata.txt"));
    int n = Integer.parseInt(br.readLine());

    System.out.println("Lines: " + n);
    List<String> l = new ArrayList<>();
    while (br.ready()) {
      String s = br.readLine();
      l.add(s);
    }
    System.out.println("All lines added: " + n);

    Result.noPrefix(l);
  }
}

