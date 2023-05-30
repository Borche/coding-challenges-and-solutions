package org.example.codility.prefixsums.geometricrangequery;

public class Solution {


  public int solution(String S, int P, int Q) {
    int[][] prefixSums = buildPrefixSums(S);


    if (prefixSums[Q + 1][0] - prefixSums[P][0] > 0) return 1;
    else if (prefixSums[Q + 1][1] - prefixSums[P][1] > 0) return 2;
    else if (prefixSums[Q + 1][2] - prefixSums[P][2] > 0) return 3;
    else return 4;
  }

  private int[][] buildPrefixSums(String S) {
    int[][] genomes = new int[S.length() + 1][4];

    for (int i = 0; i < S.length(); i++) {
      System.arraycopy(genomes[i], 0, genomes[i + 1], 0, 4);
      genomes[i+1][getIndex(S.charAt(i))]++;
    }
    return genomes;
  }

  int getIndex(char c) {
    if (c == 'A') return 0;
    else if (c == 'C') return 1;
    else if (c == 'G') return 2;
    else return 3;
  }

  public int[] solution(String S, int[] P, int[] Q) {
    // Implement your solution here
    int[][] prefixSums = buildPrefixSums(S);

    int[] results = new int[P.length];

    for (int i = 0; i < P.length; i++) {
      if (prefixSums[Q[i] + 1][0] - prefixSums[P[i]][0] > 0) results[i] = 1;
      else if (prefixSums[Q[i] + 1][1] - prefixSums[P[i]][1] > 0) results[i] = 2;
      else if (prefixSums[Q[i] + 1][2] - prefixSums[P[i]][2] > 0) results[i] = 3;
      else results[i] = 4;
    }

    return results;
  }
}
