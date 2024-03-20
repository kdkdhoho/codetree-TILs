import java.util.Arrays;
import java.util.PriorityQueue;
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

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(arrA[i] + arrB[0], i, 0));
        }

        for (int i = 0; i < k - 1; i++) {
            Pair pair = pq.poll();
            int idx1 = pair.idx1;
            int idx2 = pair.idx2;

            idx2++;
            if (idx2 < m) {
                pq.add(new Pair(arrA[idx1] + arrB[idx2], idx1, idx2));
            }
        }

        System.out.println(pq.peek().sum);
    }
}

class Pair implements Comparable<Pair> {
    int sum;
    int idx1;
    int idx2;

    public Pair(int sum, int idx1, int idx2) {
        this.sum = sum;
        this.idx1 = idx1;
        this.idx2 = idx2;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.sum != o.sum) {
            return this.sum - o.sum;
        }
        if (this.idx1 != o.idx1) {
            return this.idx1 - o.idx1;
        }
        return this.idx2 - o.idx2;
    }
}