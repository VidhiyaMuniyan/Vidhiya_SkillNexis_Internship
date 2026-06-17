package Week3_Assignment_MiniProject;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class BSTSearch {
    Node root;

    Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (data < root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        return root;
    }

    boolean search(Node root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (key < root.data)
            return search(root.left, key);

        return search(root.right, key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BSTSearch tree = new BSTSearch();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
            tree.root = tree.insert(tree.root, sc.nextInt());

        int key = sc.nextInt();

        if (tree.search(tree.root, key))
            System.out.println("Found");
        else
            System.out.println("Not Found");

        sc.close();
    }
}
