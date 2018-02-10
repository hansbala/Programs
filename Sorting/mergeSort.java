import java.util.Scanner;

class mergeSort {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] A = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }
    mergeSort(A);
    for (int i = 0; i < n; i++) {
      System.out.print(A[i] + " ");
    }
    System.out.println();
  }
  public static void mergeSort(int[] A) {
    if (A.length < 2) {
      return;
    }
    int mid = A.length / 2;
    int[] left = new int[mid], right = new int[A.length - mid];
    System.arraycopy(A, 0, left, 0, mid);
    System.arraycopy(A, mid, right, 0, A.length - mid);
    mergeSort(left);
    mergeSort(right);
    merge(left, right, A);
  }
  public static void merge(int[] left, int[] right, int[] A) {
    int i = 0, j = 0, k = 0;
    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) {
        A[k++] = left[i++];
      } else {
        A[k++] = right[j++];
      }
    }
    while (i < left.length) {
      A[k++] = left[i++];
    }
    while (j < right.length) {
      A[k++] = right[j++];
    }
  }
}
