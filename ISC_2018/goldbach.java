import java.util.Scanner;

class goldbach {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("N=");
    // Accepting n
    int n = sc.nextInt();
    // Filtering for initial errors
    if (n % 2 != 0) {
      System.out.println("INVALID INPUT. NUMBER IS ODD.");
    } else if (n <= 9 || n >= 50) {
      System.out.println("INVALID INPUT. NUMBER OUT OF RANGE.");
    } else {
      boolean flag = false;
      System.out.print("PRIME PAIRS ARE: ");
      for (int i = 3; i <= n / 2; i += 2) {
        // If i and (n - i) is prime they are factors
        if (isPrime(i) && isPrime(n - i)) {
          if (!flag) {
            // For first time we must print on the same line so we have flag
            // variable for the first time
            System.out.println(i + ", " + (n - i));
            flag = true;
            continue;
          }
          // If it is not first time, print two tabs and then a space for required
          // spacing
          System.out.println("\t\t " + i + ", " + (n - i));
        }
      }
    }
  }
  public static boolean isPrime(int num) {
    // If it is 1 or a multiple of 2 it cannot be prime
    if (num == 1) return false;
    if (num == 2 || num == 3) return true;
    if (num % 2 == 0) return false;
    // Square root prime sieve algoithm for totol
    // time complexity of O(sqrt(n))
    for (int i = 3; i <= (int)Math.sqrt(num); i += 2) {
      if (num % i == 0) return false;
    }
    return true;
  }
}