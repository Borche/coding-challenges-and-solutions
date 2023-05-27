package org.example.hackerrank.day7.noprefixset;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Trie_100 {
  int LEN = 'j' - 'a' + 1;
  Node root = new Node();

  class Node {
    Node [] children;
    boolean wordleaf;

    Node() {
      children = new Node[LEN];
      wordleaf = false;
    }
  }

  // return true if prefix, otherwise false
  boolean insert(String str) {
    return insert(str, root);
  }

  boolean insert(String str, Node node) {
    if (str == null || str.length() < 1) return false;
    char c = str.charAt(0);
    Node child = node.children[c - 'a'];
    if (child == null) {
      // extend
      child = new Node();
      node.children[c - 'a'] = child;
    }
    // support both prefix cases, such as (a, ab) and (ab, a)
    else if (child.wordleaf || str.length() == 1) {
      return true;
    }

    if (str.length() == 1) {
      child.wordleaf = true;
      return false;
    }
    return insert(str.substring(1), child);
  }
}

class Result {

  /*
   * Complete the 'noPrefix' function below.
   *
   * The function accepts STRING_ARRAY words as parameter.
   */

  public static void noPrefix_old(List<String> words) {
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

  public static void noPrefix_Old_2(List<String> words) {
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

  public static void noPrefix_100(List<String> words) {
    // Write your code here
    Trie_100 trie = new Trie_100();
    boolean good = true;
    for (String word : words) {
      if (trie.insert(word)) {
        System.out.println("BAD SET");
        System.out.println(word);
        good = false;
        break;
      }
    }
    if (good)
      System.out.println("GOOD SET");
  }

  // My own with a Trie impl.
  public static void noPrefix(List<String> words) {
    if (words == null || words.size() == 1) {
      System.out.println("GOOD SET");
      return;
    }

    Trie trie = new Trie();
    for (int i = 0; i < words.size(); i++) {
      String word = words.get(i);
      if (trie.insert(word)) {
        System.out.println("BAD SET");
        System.out.println(word);
        return;
      }
    }

    System.out.println("GOOD SET");
  }

}

class Trie {
  private static final short ALPHABET_SIZE = 'j' - 'a' + 1;
  Node root = new Node('*');

  static class Node {
    char c;
    boolean isLeaf = false;
    Node[] children = new Node[ALPHABET_SIZE];

    Node(char c) {
      this.c = c;
    }

    static int getIndex(char c) {
      return c -'a';
    }
  }

  boolean insert(String s) {
    return insert(s, root);
  }

  boolean insert(String s, Node root) {
    char c = s.charAt(0);
    Node child = root.children[Node.getIndex(c)];
    if (child == null) {
      child = new Node(c);
      root.children[Node.getIndex(c)] = child;
      if (s.length() == 1) {
        child.isLeaf = true;
        return false;
      }
    } else if (s.length() == 1 || child.isLeaf) {
      return true;
    }

    return insert(s.substring(1), child);
  }
}


public class Solution {
  public static void main(String[] args) throws IOException {
    Result.noPrefix(Arrays.asList("aab", "aabcde", "defgab", "abcde", "cedaaa", "bbbbbbbbbb", "jabjjjad"));

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

    long startTime = System.currentTimeMillis();
    Result.noPrefix(l);
    long endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);
  }
}

