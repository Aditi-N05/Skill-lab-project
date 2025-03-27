import java.util.Scanner;

class CircularQueue {
    private int size;
    private int front, rear;
    private int[] queue;

    public CircularQueue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full! Cannot enqueue " + data);
            return;
        }
        if (isEmpty()) { 
            front = 0;
        }
        rear = (rear + 1) % size;
        queue[rear] = data;
        System.out.println("Enqueued: " + data);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty! Cannot dequeue.");
            return;
        }
        System.out.println("Dequeued: " + queue[front]);
        if (front == rear) { 
            front = -1;
            rear = -1;
            queue[front]=9999;

        } else {
            queue[front]=9999;
            front = (front + 1) % size;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return queue[front];
    }
}

public class CircularQueueDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularQueue cq = new CircularQueue(5);

        while (true) {
            System.out.println("\nCircular Queue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Show Front");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter data to enqueue: ");
                    int data = sc.nextInt();
                    cq.enqueue(data);
                    break;
                case 2:
                    cq.dequeue();
                    break;
                case 3:
                    cq.display();
                    break;
                case 4:
                    System.out.println("Front element: " + cq.front());
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
