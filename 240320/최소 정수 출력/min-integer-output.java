import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();

            if (number == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(number);
            }
        }
    }
}