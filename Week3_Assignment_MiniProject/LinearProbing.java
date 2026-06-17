package Week3_Assignment_MiniProject;
import java.util.*;

public class LinearProbing {

    int[] table;
    int size;

    LinearProbing(int size) {
        this.size = size;
        table = new int[size];
        Arrays.fill(table, -1);
    }

    void insert(int key) {
        int index = key % size;

        while (table[index] != -1)
            index = (index + 1) % size;

        table[index] = key;
    }

    void display() {
        for (int i = 0; i < size; i++)
            System.out.println(i + " -> " + table[i]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int n = sc.nextInt();

        LinearProbing h = new LinearProbing(size);

        for (int i = 0; i < n; i++)
            h.insert(sc.nextInt());

        h.display();

        sc.close();
    }
}
