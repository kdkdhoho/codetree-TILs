import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int MAX_N = 19;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] dp = new int[MAX_N + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int sum = 0;

            for (int left = 0; left <= i - 1; left++) {
                sum += dp[left] * dp[i - 1 - left];
            }

            dp[i] = sum;
        }

        System.out.println(dp[n]);
    }
}