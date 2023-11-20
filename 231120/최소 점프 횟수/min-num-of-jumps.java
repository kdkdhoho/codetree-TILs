import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, answer = Integer.MAX_VALUE;
    private static int[] arr;

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (arr[0] == 0) {
            System.out.print(-1);
            System.exit(0);
        }

        recursive(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(answer);
        }
    }

    private static void recursive(int pos, int cnt) {
        if (pos >= n || (pos != n - 1 && arr[pos] == 0)) {
            return;
        }

        if (pos == n - 1) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (int step = 1; step <= arr[pos]; step++) {
            int nextPos = pos + step;
            recursive(nextPos, cnt + 1);
        }
    }
}