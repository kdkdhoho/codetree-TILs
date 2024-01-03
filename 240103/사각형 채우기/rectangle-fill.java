import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int MOD = 10_007;

    private static int n;
    private static int[] dp;

    public static void main(String[] args) {
        n = sc.nextInt();
        dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        System.out.print(dp[n]);
    }
}