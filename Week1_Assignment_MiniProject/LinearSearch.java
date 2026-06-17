import java.util.*;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int key = sc.nextInt();

        int pos = -1;
        for(int i = 0; i < n; i++) {
            if(arr[i] == key) {
                pos = i;
                break;
            }
        }

        if(pos != -1)
            System.out.println("Element found at index " + pos);
        else
            System.out.println("Element not found");
        sc.close();
    }
}