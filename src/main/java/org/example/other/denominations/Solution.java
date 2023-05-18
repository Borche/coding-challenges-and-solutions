package org.example.other.denominations;

public class Solution {
  public int[] getChange(double inputAmount, double inputPrice) {
    if (inputAmount < inputPrice) throw new IllegalArgumentException("inputAmount less than inputPrice");

    int[] denominations = new int[] { 100, 50, 25, 10, 5, 1 }; // 1.00, 0.50, 0.25, 0.10, 0.05, 0.01

    int amount = (int) (inputAmount * 100);
    int price = (int) (inputPrice * 100);
    int diff = amount - price;

    int[] results = new int[denominations.length];
    for (int i = 0; i < denominations.length; i++) {
      if (diff == 0) break;
      results[i] = diff / denominations[i];
      diff -= results[i] * denominations[i];
      System.out.println();
    }

    return results;
  }
}
