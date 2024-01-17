import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int NONE = Integer.MAX_VALUE;

    private static int n, m;
    private static int[] coins;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[m + 1];
        Arrays.fill(dp, NONE);
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            if (0 <= coin && coin <= m) {
                dp[coin] = 1;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                int k = i - coin;

                if (k >= 0 && dp[k] != NONE) {
                    dp[i] = Math.min(dp[i], dp[k] + 1);
                }
            }
        }

        if (dp[m] == NONE) {
            System.out.println(-1);
            return;
        }
        System.out.println(dp[m]);
    }
}