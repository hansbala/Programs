// Standard implementation of bounded stack

class Stack {
  
  int[] A;
  int top;

  // Constructor
  Stack(int size) {
    A = new int[size];
    top = -1;
  }

  void push(int x) {
    if (top + 1 == A.length) {
      System.out.print("OVERFLOW");
    }
    A[++top] = x;
  }

  int pop() {
    if (top == -1) {
      System.out.println("UNDERFLOW");
      return -9999;
    }
    A[top--];
  }

}
