package Week2_Assignment_MiniProject;

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Stack_Linkedlist {
    Node top;

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    void pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return;
        }

        System.out.println("Popped: " + top.data);
        top = top.next;
    }

    void display() {
        Node temp = top;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack_Linkedlist s = new Stack_Linkedlist();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
            s.push(sc.nextInt());

        System.out.println("Stack:");
        s.display();

        s.pop();

        System.out.println("After Pop:");
        s.display();

        sc.close();
    }
}
