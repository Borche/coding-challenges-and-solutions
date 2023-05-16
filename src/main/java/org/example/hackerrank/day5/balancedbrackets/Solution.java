package org.example.hackerrank.day5.balancedbrackets;

import java.io.*;
import java.math.*;
import java.security.*;
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
   * Complete the 'isBalanced' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String isBalanced(String s) {
    // Write your code here
    if (s.length() % 2 == 1) return "NO";
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '{' || c == '[' || c == '(') {
        stack.push(c);
      } else {
        if (stack.empty()) return "NO";
        char c2 = stack.pop();
        if (!(c2 == '{' && c == '}' || c2 == '[' && c == ']' || c2 == '(' && c == ')')) {
          return "NO";
        }
      }
    }

    return stack.empty() ? "YES" : "NO";
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    // YES
    System.out.println(Result.isBalanced("{[()]}"));
    System.out.println(Result.isBalanced("{[()()]}"));
    System.out.println(Result.isBalanced("{[([{}])]}"));
    System.out.println("---");

    // NO
    System.out.println(Result.isBalanced("{[(])}"));
    System.out.println(Result.isBalanced("[({)})]"));
    System.out.println("---");

    // CRASH?
    System.out.println(Result.isBalanced("}][}}(}][))]"));
    System.out.println(Result.isBalanced("{)[](}]}]}))}(())("));
    System.out.println(Result.isBalanced("{{}("));
    System.out.println("---");

    // DIFFICULT - from file
    BufferedReader br = new BufferedReader(new FileReader("testdata/balancedbrackets.txt"));
    BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

    while (br.ready()) {
      String line = br.readLine();
      bw.write(Result.isBalanced(line));
      bw.newLine();
    }

    br.close();
    bw.close();
  }
}
