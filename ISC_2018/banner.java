import java.util.Scanner;

class banner {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("N=");
    // Accepting value of N
    int n = sc.nextInt();
    // Initial filtration of errors of n range
    if (!(n > 2 && n < 9)) {
      System.out.println("INVALID INPUT");
    } else {
      sc.nextLine();
      // Going to next line
      String[] teams = new String[n];
      // Storing the greatest length in max_len
      int max_len = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        System.out.print("Team " + (i + 1) + ": ");
        teams[i] = sc.nextLine();
        max_len = Math.max(max_len, teams[i].length());
      }
      // Now printing in banner fashion
      for (int i = 0; i < max_len; i++) {
        for (int j = 0; j < n; j++) {
          if (i >= teams[j].length()) {
            // If this check is not there we will overflow
            // resulting in an error
            System.out.print(" " + "\t");
            continue;
          }
          // otherwise print the character at i till max_len - 1 (0 - indexed)
          System.out.print(teams[j].charAt(i) + "\t");
        }
        System.out.println();
      }
    }
  }
}
