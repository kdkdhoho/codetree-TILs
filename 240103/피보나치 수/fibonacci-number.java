import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static int n;
    private static int[] arr;

    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int[n + 1];

        if (n <= 2) {
            System.out.print(1);
            return;
        }

        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.print(arr[n]);
    }
}