# Circular Queue Implementation

## What is a Circular Queue?
A **Circular Queue** is a linear data structure in which the last position is connected back to the first position to form a **circle**. It overcomes the limitations of a linear queue by reusing empty spaces.

---

## Operations in Circular Queue
1. **Enqueue** - Insert an element at the rear.
2. **Dequeue** - Remove an element from the front.
3. **Front** - Get the front element.
4. **Rear** - Get the rear element.
5. **isEmpty** - Check if the queue is empty.
6. **isFull** - Check if the queue is full.

---

## **Circular Queue Implementation in Java**
```java
class CircularQueue {
    int[] queue;
    int front, rear, size;

    CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = rear = -1;
    }

    boolean isFull() {
        return (rear + 1) % size == front;
    }

    boolean isEmpty() {
        return front == -1;
    }

    void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        if (isEmpty()) front = 0;
        rear = (rear + 1) % size;
        queue[rear] = data;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int data = queue[front];
        if (front == rear) front = rear = -1;
        else front = (front + 1) % size;
        return data;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.display();
        System.out.println("Dequeued: " + cq.dequeue());
        cq.display();
    }
}
