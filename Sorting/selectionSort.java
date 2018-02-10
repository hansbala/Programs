import java.util.Scanner;

class selectionSort {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] A = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }
    selectionSort(A);
    for (int i = 0; i < n; i++) {
      System.out.print(A[i] + " ");
    }
    System.out.println();
  }
  public static void selectionSort(int[] A) {
    for (int i = 0; i < A.length - 1; i++) {
      int min_index = i;
      for (int j = i + 1; j < A.length; j++) {
        if (A[j] < A[min_index]) {
          min_index = j;
        }
      }
      int temp = A[i];
      A[i] = A[min_index];
      A[min_index] = temp;
    }
  }
}
