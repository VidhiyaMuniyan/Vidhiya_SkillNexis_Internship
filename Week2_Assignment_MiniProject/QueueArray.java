package Week2_Assignment_MiniProject;

import java.util.*;

public class QueueArray {
    int[] queue;
    int front = 0, rear = -1;

    QueueArray(int size) {
        queue = new int[size];
    }

    void enqueue(int data) {
        queue[++rear] = data;
    }

    void dequeue() {
        if (front > rear) {
            System.out.println("Queue Empty");
            return;
        }

        System.out.println("Deleted: " + queue[front++]);
    }

    void display() {
        for (int i = front; i <= rear; i++)
            System.out.print(queue[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        QueueArray q = new QueueArray(n);

        for (int i = 0; i < n; i++)
            q.enqueue(sc.nextInt());

        System.out.println("Queue:");
        q.display();

        q.dequeue();

        System.out.println("After Dequeue:");
        q.display();

        sc.close();
    }
}
