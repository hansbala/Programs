import java.util.Scanner;

class BST {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Node root = new Node(sc.nextInt());
    for (int i = 1; i < n; i++) {
      root.insert(sc.nextInt());
    }
    root.walk();
    System.out.println();
    int check = sc.nextInt();
    if (root.contains(check)) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
class Node {
  Node left, right;
  int data;
  Node(int data) {
    this.data = data;
    left = right = null;
  }
  public void insert(int value) {
    if (value <= data) {
      if (left == null) {
        left = new Node(value);
      } else {
        left.insert(value);
      }
    } else {
      if (right == null) {
        right = new Node(value);
      } else {
        right.insert(value);
      }
    }
  }
  public boolean contains(int value) {
    if (value == data) {
      return true;
    } else if (value < data) {
      if (left == null) {
        return false;
      }
      return left.contains(value);
    } else {
      if (right == null) {
        return false;
      }
      return right.contains(value);
    }
  }
  public void walk() {
    if (left != null) {
      left.walk();
    }
    System.out.print(data + " ");
    if (right != null) {
      right.walk();
    }
  }
}
