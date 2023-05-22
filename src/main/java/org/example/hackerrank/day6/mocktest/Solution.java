package org.example.hackerrank.day6.mocktest;

import java.io.*;
import java.util.*;
import java.util.stream.*;


class BFSTreeNode {
  int number;
  BFSTreeNode left;
  BFSTreeNode right;

  public BFSTreeNode(int number) {
    this.number = number;
  }
}

class Result {

  public static List<Integer> bfs2(int n, int m, List<List<Integer>> edges, int s) {
    // Write your code here
    if (n < 1 || edges == null || edges.size() < 1 || s < 1) return null;

    // Step 1
    Set<Integer> [] tree = new Set[n];
    for (List<Integer> edge : edges) {
      int a = edge.get(0);
      int b = edge.get(1);
      if (tree[a-1] == null) {
        tree[a-1] = new HashSet<Integer>();
      }
      tree[a-1].add(b);
      if (tree[b-1] == null) {
        tree[b-1] = new HashSet<Integer>();
      }
      tree[b-1].add(a);
    }

    // Step 2
    List<Integer> res = new ArrayList<Integer>();

    // O(n) start from S
    for (int i = 0; i < n - 1; i++) {
      res.add(-1);
    }

    Set<Integer> root = tree[s-1];
    if (root == null) return res;

    Deque<Integer> queue = new LinkedList<Integer>();
    for (Integer r : root) {
      queue.add(r);
    }
    int height = 1;
    boolean [] visited = new boolean [n];
    visited[s-1] = true;
    while (!queue.isEmpty()) {
      Deque<Integer> queuen = new LinkedList<Integer>();
      while (!queue.isEmpty()) {
        int v = queue.poll().intValue();
        if (!visited[v-1]) {
          visited[v-1] = true;
          // update distances
          if (v > s)
            res.set(v-2, height*6);
          else
            res.set(v-1, height*6);
          if (tree[v-1] != null) {
            for (Integer r : tree[v-1]) {
              queuen.add(r);
            }
          }
        }
      }
      queue = queuen;
      height++;
    }

    // return res
    return res;
  }

  public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
    // Write your code here
    if (n == 2 && m == 1) return Collections.singletonList(6);

    // Build the graph
    Set<Integer>[] graph = new Set[n];
    for (List<Integer> l : edges) {
      int p1 = l.get(0) - 1;
      int p2 = l.get(1) - 1;

      if (graph[p1] == null) graph[p1] = new HashSet<>();
      graph[p1].add(p2);

      // Both directions because the graph is undirected
      if (graph[p2] == null) graph[p2] = new HashSet<>();
      graph[p2].add(p1);
    }

    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();

    visited[s - 1] = true;
    queue.offer(s - 1);

    int[] result = new int[n];

    while (!queue.isEmpty()) {
      int node = queue.poll();
      if (graph[node] == null) break;

      // Check the node's children
      for (int neighbour : graph[node]) {
        if (!visited[neighbour]) {
          result[neighbour] = result[node] + 6;
          visited[neighbour] = true;
          queue.offer(neighbour);
        }
      }
    }

    result[s - 1] = -2;
    return IntStream.of(result).filter(i -> i != -2).map(i -> i == 0 ? -1 : i).boxed().collect(Collectors.toList());
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    System.out.println(Result.bfs(4, 2, createEdges(1,2, 1,3), 1));

    System.out.println(Result.bfs(4, 2, createEdges(1,2, 1,3), 2));

    System.out.println(Result.bfs(5, 4, createEdges(1,2, 2,3, 2,4, 4,5), 4));

    System.out.println(Result.bfs(7, 5, createEdges(1,2, 1,4, 2,3, 3,7, 6,7), 7));
    System.out.println(Result.bfs(7, 5, createEdges(1,2, 1,4, 2,3, 3,7, 6,7), 5));
    System.out.println(Result.bfs(7, 5, createEdges(1,2, 1,4, 2,3, 3,7, 6,7), 4));
  }

  public static List<List<Integer>> createEdges(int... nodes) {
    if (nodes.length % 2 != 0) throw new IllegalArgumentException("Must have even number of nodes when creating edges");

    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nodes.length; i += 2) {
      result.add(createEdge(nodes[i], nodes[i+1]));
    }
    return result;
  }

  public static List<Integer> createEdge(int a, int b) {
    return Arrays.asList(a, b);
  }
}

