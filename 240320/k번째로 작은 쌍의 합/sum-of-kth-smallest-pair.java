import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] arrA = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }

        int[] arrB = new int[m];
        for (int i = 0; i < m; i++) {
            arrB[i] = sc.nextInt();
        }

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = arrA[i];
            for (int j = 0; j < m; j++) {
                int b = arrB[j];

                pairs.add(new Pair(a, b));
            }
        }
        pairs.sort(Comparator.comparingInt(Pair::sum));
        Pair pair = pairs.get(k - 1);
        System.out.println(pair.sum());
    }
}

class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sum() {
        return a + b;
    }
}