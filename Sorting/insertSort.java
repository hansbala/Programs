import java.util.Scanner;

class insertSort {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] A = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }
    insertSort(A);
    for (int i = 0; i < n; i++) {
      System.out.print(A[i] + " ");
    }
    System.out.println();
  }
  public static void insertSort(int[] A) {
    for (int i = 1; i < A.length; i++) {
      int curr = A[i], hole = i;
      while (hole > 0 && A[hole - 1] > curr) {
        A[hole] = A[hole - 1];
        --hole;
      }
      A[hole] = curr;
    }
  }
}
