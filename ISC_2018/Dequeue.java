// Non-cyclic implementation of double ended queue
// data structure

class Dequeue {
  
  int[] A;
  int front, rear;

  Dequeue(int size) {
    A = new int[size];
    front = rear = -1;
  }

  // Insert a value at the front end of the queue
  void enqueue_front(int x) {
    if (front == -1 && rear == -1) {
      // Queue is empty so increment both, place, and continue
      front = rear = 0;
      A[front] = x;
      return;
    }
    if (front <= 0) {
      System.out.print("Cannot insert at front");
      return;
    }
    A[--front] = x;
  }

  // Insert a value at the rear end
  void enqueue_rear(int x) {
    if (front == -1 && rear == -1) {
      // Queue is empty so increment both, place, and continue
      front = rear = 0;
      A[front] = x;
      return;
    }
    if (rear == A.length - 1) {
      System.out.print("Cannot insert at rear");
      return;
    }
    A[++rear] = x;
  }

  // remove an element from the front
  int dequeue_front() {
    if (front == -1 && rear == -1) {
      // Queue is empty so return garbage
      return -9999;
    }
    if (front == rear) {
      // On removing this last element the queue is empty so make
      // front = rear = -1 and return that last element
      int temp = A[front];
      front = rear = -1;
      return temp;
    }
    return A[front++];
  }

  // remove an element from the rear end
  int dequeue_rear() {
    if (front == -1 && rear == -1) {
      // Queue is empty so return garbage
      return -9999;
    }
    if (front == rear) {
      int temp = A[front];
      front = rear = -1;
      return temp;
    }
    return A[rear--];
  }
}
