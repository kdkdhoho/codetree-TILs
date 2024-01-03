import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int MOD = 10_007;

    private static int n;
    private static int[] arr;

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n + 1];

        if (n <= 1) {
            System.out.print(0);
            return;
        }
        if (n <= 3) {
            System.out.print(1);
            return;
        }

        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i <= n; i++) {
            arr[i] = (arr[i - 2] + arr[i - 3]) % MOD;
        }
        System.out.print(arr[n]);
    }
}