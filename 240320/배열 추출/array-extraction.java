import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();

            if (number > 0) {
                pq.add(number);
                continue;
            }

            if (pq.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(pq.poll());
            }
        }
    }
}