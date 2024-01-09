import static java.lang.Math.max;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n;
    private static int[] arr;

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = -1;
        for (int i = 0; i < n; i++) {
            answer = max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}