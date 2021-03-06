/* Swap two words in place inside an array
For example:
"thinkcomputer" becomes "computerthink"
"applehans" becomes "hansapple"
"hansbala" becomes "balahans"
*/
class swap_words_inplace_char_array {
  public static void main(String[] args) {
    int index_next = 4;
    char[] A = "hansapple".toCharArray();
    // Reverse entire string to obtain swapped words in reversed order
    for (int i = 0; i <= (A.length - 1) / 2; ++i) {
      swap(A, i, A.length - i - 1);
    }
    // Length of 1st and 2nd words to make it easier to understand
    int first_len = A.length - index_next, sec_len = index_next;
    // Reverse the 1st word
    for (int i = 0; i <= (first_len - 1) / 2; ++i) {
      swap(A, i, first_len - i - 1);
    }
    int k = 1;
    // Reverse the 2nd word
    for (int i = first_len; i <= (first_len + A.length - 1) / 2; ++i) {
      swap(A, i, A.length - k);
      ++k;
    }
    // Finally print it
    for (int i = 0; i < A.length; i++) {
      System.out.print(A[i] + "");
    }
    System.out.println();
  }
  // Swap algorithm
  public static void swap(char[] A, int i, int j) {
    char temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
}
