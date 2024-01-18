import static java.lang.Math.min;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, m;
    private static int[] numbers;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);

        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            for (int j = dp.length - 1; j >= 0; j--) {
                int k = j - number;

                if (k >= 0 && dp[k] != Integer.MAX_VALUE) {
                    dp[j] = min(dp[j], dp[k] + 1);
                }
            }
        }

        if (dp[m] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }
    }
}