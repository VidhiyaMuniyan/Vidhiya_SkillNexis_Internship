package Week3_Assignment_MiniProject;
import java.util.*;

class Contact {
    String name;
    Contact left, right;

    Contact(String name) {
        this.name = name;
    }
}

public class MiniProject_ContactDirectory {

    Contact root;

    Contact insert(Contact root, String name) {
        if (root == null)
            return new Contact(name);

        if (name.compareToIgnoreCase(root.name) < 0)
            root.left = insert(root.left, name);
        else
            root.right = insert(root.right, name);

        return root;
    }

    boolean search(Contact root, String name) {
        if (root == null)
            return false;

        if (root.name.equalsIgnoreCase(name))
            return true;

        if (name.compareToIgnoreCase(root.name) < 0)
            return search(root.left, name);

        return search(root.right, name);
    }

    Contact findMin(Contact root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    Contact delete(Contact root, String name) {
        if (root == null)
            return null;

        if (name.compareToIgnoreCase(root.name) < 0)
            root.left = delete(root.left, name);
        else if (name.compareToIgnoreCase(root.name) > 0)
            root.right = delete(root.right, name);
        else {
            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            Contact temp = findMin(root.right);
            root.name = temp.name;
            root.right = delete(root.right, temp.name);
        }

        return root;
    }

    void inorder(Contact root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.name);
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MiniProject_ContactDirectory cd = new MiniProject_ContactDirectory();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++)
            cd.root = cd.insert(cd.root, sc.nextLine());

        String searchName = sc.nextLine();

        System.out.println(
                cd.search(cd.root, searchName)
                ? "Contact Found"
                : "Contact Not Found");

        String deleteName = sc.nextLine();

        cd.root = cd.delete(cd.root, deleteName);

        System.out.println("Contacts:");
        cd.inorder(cd.root);

        sc.close();
    }
}