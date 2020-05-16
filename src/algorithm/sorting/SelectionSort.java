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
    for (int i = 0; i < A.length - 1; i++) {
      for (int j = i + 1; j < A.length; j++) {
        if (A[i] > A[j]) {
          int temp = A[i];
          A[i] = A[j];
          A[j] = temp;
        }
      }
    }
    return A;
  }

  private static int[] sortDescendingOrder(int[] A) {
    for (int i = 0; i < A.length - 1; i++) {
      for (int j = i + 1; j < A.length; j++) {
        if (A[i] < A[j]) {
          int temp = A[i];
          A[i] = A[j];
          A[j] = temp;
        }
      }
    }
    return A;
  }
}
