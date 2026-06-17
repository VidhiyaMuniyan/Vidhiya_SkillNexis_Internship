import java.util.*;
public class MiniProject_StudentMarksAnalyzer {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] marks = new int[n];

        int sum = 0;

        for(int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
            sum += marks[i];
        }

        Arrays.sort(marks);

        System.out.println("Top 3 Marks:");
        for(int i = n - 1; i >= Math.max(0, n - 3); i--)
            System.out.print(marks[i] + " ");

        double avg = (double) sum / n;
        System.out.println("\nAverage Score = " + avg);
        sc.close();
    }
}

