package algorithm.sorting;

import java.util.Arrays;

/**
 * <p> Selection Sort
 */
public class SelectionSort {

  public static void main(String args[]) {
    int[] ex1 = {6, 2, 1, 5, 4, 10, 7, 9, 8, 3};
    System.out.println("Ascending Order: " + Arrays.toString(sortAscendingOrder(ex1)));
    System.out.println("Descending Order: " + Arrays.toString(sortDescendingOrder(ex1)));
  }

  private static int[] sortAscendingOrder(int[] A) {
    int index = 0, temp, min;
    for (int i = 0; i < A.length; i++) {
      min = 9999;
      for (int j = i; j < A.length; j++) {
        if (min > A[j]) {
          min = A[j];
          index = j;
        }
      }
      temp = A[i];
      A[i] = A[index];
      A[index] = temp;
    }
    return A;
  }

  private static int[] sortDescendingOrder(int[] A) {
    int index = 0, temp, max;
    for (int i = 0; i < A.length; i++) {
      max = 0;
      for (int j = i; j < A.length; j++) {
        if (max < A[j]) {
          max = A[j];
          index = j;
        }
      }
      temp = A[i];
      A[i] = A[index];
      A[index] = temp;
    }
    return A;
  }
}
