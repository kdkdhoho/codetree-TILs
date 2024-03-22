import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int cnt = 0;
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                int result = sum[i] - sum[j - 1];

                if (result == k) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}