package org.example.hackerrank.day6.simpletexteditor;

import java.util.*;

interface Command {
  String perform(String S, String commandParameter);
  String undo(String S);
}

class AddCommand implements Command {
  String txt;
  @Override
  public String perform(String S, String txtToAppend) {
    this.txt = txtToAppend;
    return S + txtToAppend;
  }
  @Override
  public String undo(String S) {
    return S.substring(0, S.length() - txt.length());
  }
}

class RemoveCommand implements Command {
  String removed;
  @Override
  public String perform(String S, String numOfCharsToRemove) {
    int k = Integer.parseInt(numOfCharsToRemove);
    this.removed = S.substring(S.length() - k);
    return S.substring(0, S.length() - k);
  }
  @Override
  public String undo(String S) {
    return S + removed;
  }
}

public class Solution {

  private static String S = "";

  private final static Stack<Command> commands = new Stack<Command>();

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);

    // System.out.print("Number of operations: ");
    int Q = Integer.parseInt(in.nextLine());

    for (int i = 0; i < Q; i++) {
      // printMenu();
      String[] inputs = in.nextLine().split(" ");

      switch (inputs[0]) {
        case "1":
          appendText(inputs[1]);
          break;
        case "2":
          removeText(inputs[1]);
          break;
        case "3":
          printK(inputs[1]);
          break;
        case "4":
          undo();
          break;
        default:
          throw new IllegalArgumentException("Unsupported operation");
      }
      // System.out.printf("-- %s --\n", S);
    }
  }

  private static void undo() {
    S = commands.pop().undo(S);
  }

  private static void printK(String K) {
    int k = Integer.parseInt(K);
    if (k < 1 || k > S.length()) return; // Nothing to do
    System.out.println(S.charAt(k - 1));
  }

  private static void removeText(String K) {
    Command rc = new RemoveCommand();
    S = rc.perform(S, K);
    commands.push(rc);
  }

  private static void appendText(String s) {
    Command ac = new AddCommand();
    S = ac.perform(S, s);
    commands.push(ac);
  }

  private static void printMenu() {
    System.out.println("1. Append text");
    System.out.println("2. Delete the K last characters");
    System.out.println("3. print the Kth character");
    System.out.println("4. Undo");
  }
}
