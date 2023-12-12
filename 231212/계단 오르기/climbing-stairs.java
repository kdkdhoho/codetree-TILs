import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int MAX_N = 1000;
    private static final int MOD = 10007;
    private static final int[] dp = new int[MAX_N + 1];

    static {
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 3]) % MOD;
        }
        System.out.println(dp[n]);
    }
}