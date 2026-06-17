package Week2_Assignment_MiniProject;
import java.util.*;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class SinglyLinkedList {
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

    void delete(int key) {
        if (head == null)
            return;

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != key)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;
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
        SinglyLinkedList list = new SinglyLinkedList();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
            list.insert(sc.nextInt());

        int del = sc.nextInt();

        System.out.println("Linked List:");
        list.display();

        list.delete(del);

        System.out.println("After Deletion:");
        list.display();

        sc.close();
    }
}
