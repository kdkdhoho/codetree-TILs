import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, m, answer = Integer.MIN_VALUE;
    private static int[] numbers;
    private static boolean[] used;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        numbers = new int[n];
        used = new boolean[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        recursive(0, 0);

        System.out.println(answer);
    }

    private static void recursive(int idx, int cnt) {
        if (cnt == m) {
            int result = 0;
            for (int i = 0; i < used.length; i++) {
                if (used[i]) {
                    result ^= numbers[i];
                }
            }
            answer = Math.max(answer, result);
        }

        if (idx == n) {
            return;
        }

        used[idx] = true;
        recursive(idx + 1, cnt + 1);
        used[idx] = false;
        recursive(idx + 1, cnt);
    }
}