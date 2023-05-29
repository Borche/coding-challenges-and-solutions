package org.example.other.andreas;

import java.util.Arrays;

public class MergeSortPlay {
  public static void main(String[] args) {
    MergeSort ms = new MergeSort();

    int[] arr = new int[]{5,9,1,5,2,12,7,2,4};

    ms.sort(arr);

    System.out.println(Arrays.toString(arr));

    int[] arr2 = new int[]{150,-5,27,-99,4,51,17};

    ms.sort(arr2);

    System.out.println(Arrays.toString(arr2));
  }

  private static class MergeSort {

    void sort(int[] arr) {
      split(arr, 0, arr.length - 1);
    }

    void split(int[] arr, int l, int r) {
      if (l < r) {
        int m = l + (r-l)/2;

        split(arr, l, m);
        split(arr, m+1, r);

        merge(arr, l, m, r);
      }
    }

    void merge(int[] arr, int l, int m, int r) {
      // m + 1 = first index in right half
      final int N1 = m + 1 - l ;
      final int N2 = r - m;

      // Create temporary arrays
      int[] L = new int[N1];
      int[] R = new int[N2];

      // Copy values to temp arrays
      for (int i = 0; i < N1; i++) L[i] = arr[l + i];
      for (int j = 0; j < N2; j++) R[j] = arr[m + 1 + j]; // m + 1 again

      int i = 0, j = 0, k = l;

      // Place the values from temp arrays back into main array
      // in a sorted manner
      while (i < N1 && j < N2) {
        if (L[i] <= R[j]) {
          arr[k] = L[i];
          i++;
        } else {
          arr[k] = R[j];
          j++;
        }
        k++;
      }

      // Copy back remaining elements from L if there are any
      while (i < N1) {
        arr[k] = L[i];
        i++;
        k++;
      }

      // Copy back remaining elements from R if there are any
      while (j < N2) {
        arr[k] = R[j];
        j++;
        k++;
      }
    }
  }
}
