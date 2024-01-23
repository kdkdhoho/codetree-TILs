import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

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
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];

                int k = i - coin;
                if (inArray(k)) {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                }
            }
        }

        System.out.println(dp[m]);
    }

    private static boolean inArray(int index) {
        return 0 <= index && index <= m;
    }
}