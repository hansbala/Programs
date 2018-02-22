/*
Non-cyclic implementation of single-ended queue data structure
*/

class Queue {
  
  int[] A; //Holds the queue in array fashion
  int front, rear;

  Queue(int size) {
    // Constructor to initialize front and rear
    // size is max_size. Greater than this value is considered overflow.
    A = new int[size];
    front = rear = -1;
  }

  // Adds an element to the queue
  // Enqueue as in the verb enqueue
  void enqueue(int x) {
    // x is the value to be inserted
    if (rear + 1 == A.length) {
      System.out.println("QUEUE IS FULL");
      return;
    }
    if (front == -1 && rear == -1) {
      front = rear = 0;
    } else {
      ++rear;
    }
    A[rear] = x;
  }

  // Removes an element from the Queue from the front end
  // Dequeue as in the verb dequeue
  void dequeue() {
    if (front == -1 && rear == -1) {
      System.out.println("Queue is empty");
    } else if (front == rear) {
      // After removing single element queue is empty so make them -1
      front = rear = -1;
    } else {
      // Remove from the front by incremening front
      ++front;
    }
  }

  // Returns the element at the front of the queue
  int front() {
    if (front == -1) {
      System.out.println("cannot return front from empty queue");
      return -9999;
    }
    return A[front];
  }
}
