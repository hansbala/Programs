import java.util.Scanner;

class matrix {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("M=");
    int m = sc.nextInt();
    System.out.print("N=");
    int n = sc.nextInt();
    if (!(m > 2 && m < 10 && n > 2 && n < 10)) {
      System.out.println("MATRIX OUT OF RANGE");
    } else {
      int[][] A = new int[m][n];
      System.out.println("ENTER ELEMENTS OF MATRIX");
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          A[i][j] = sc.nextInt();
        }
      }
      System.out.println("ORIGINAL MATRIX");
      printMatrix(A);
      // Sorting rows
      for (int i = 0; i < m; i++) {
        sortRow(A[i]);
      }
      // Finally printing the sorted matrix
      System.out.println("MATRIX AFTER SORTING ROWS");
      printMatrix(A);
    }
  }
  public static void printMatrix(int[][] A) {
    // Print the proper matrix with tab (even) spacing
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length; j++) {
        System.out.print(A[i][j] + "\t");
      }
      // Adding newline at end of each row
      System.out.println();
    }
  }
  public static void sortRow(int[] A) {
    // Applying bubble sort algorithm to each row
    for (int i = 0; i < A.length - 1; i++) {
      for (int j = 0; j < A.length - i - 1; j++) {
        if (A[j] > A[j + 1]) {
          // Comparing consecutive elements
          // and swap if A[j] > A[j + 1]
          int temp = A[j];
          A[j] = A[j + 1];
          A[j + 1] = temp;
        }
      }
    }
  }
}
