import static java.lang.Math.abs;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            if (abs(n1) != abs(n2)) {
                return abs(n1) - abs(n2);
            }
            return n1 - n2;
        });

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (num != 0) {
                pq.add(num);
            } else {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            }
        }
    }
}