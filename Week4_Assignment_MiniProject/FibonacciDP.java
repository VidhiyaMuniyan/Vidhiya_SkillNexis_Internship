package Week4_Assignment_MiniProject;
import java.util.*;

public class FibonacciDP {

    static int[] memo;

    static int fibMemo(int n) {

        if (n <= 1)
            return n;

        if (memo[n] != -1)
            return memo[n];

        memo[n] =
                fibMemo(n - 1) +
                fibMemo(n - 2);

        return memo[n];
    }

    static int fibTab(int n) {

        if (n <= 1)
            return n;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        System.out.println("Memoization: " + fibMemo(n));
        System.out.println("Tabulation: " + fibTab(n));

        sc.close();
    }
}
