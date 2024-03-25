import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            C[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            D[i] = sc.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = A[i];
                int b = B[j];

                set.add(a + b);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int c = C[i];
                int d = D[j];

                if (set.contains(-(c + d))) {
                    answer++;
                }
            }
        }
        System.out.print(answer);
    }
}