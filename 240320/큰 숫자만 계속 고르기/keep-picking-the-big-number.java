import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            int largeNumber = pq.poll();
            largeNumber -= 1;
            pq.add(largeNumber);
        }
        System.out.println(pq.peek());
    }
}