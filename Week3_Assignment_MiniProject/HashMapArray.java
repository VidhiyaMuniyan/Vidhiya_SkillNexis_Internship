package Week3_Assignment_MiniProject;
import java.util.*;

public class HashMapArray {

    int[] table;
    int size;

    HashMapArray(int size) {
        this.size = size;
        table = new int[size];
        Arrays.fill(table, -1);
    }

    void put(int key) {
        int index = key % size;
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

        HashMapArray map = new HashMapArray(size);

        for (int i = 0; i < n; i++)
            map.put(sc.nextInt());

        map.display();

        sc.close();
    }
}
