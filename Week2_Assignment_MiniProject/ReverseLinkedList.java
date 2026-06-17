package Week2_Assignment_MiniProject;

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class ReverseLinkedList {
    Node head;

    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    void reverse() {
        Stack<Integer> stack = new Stack<>();

        Node temp = head;

        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }
    }

    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ReverseLinkedList list = new ReverseLinkedList();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
            list.insert(sc.nextInt());

        System.out.println("Original:");
        list.display();

        list.reverse();

        System.out.println("Reversed:");
        list.display();

        sc.close();
    }
}
