import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] inputs = sc.nextLine().split(" ");
            String command = inputs[0];

            if (command.equals("push")) {
                int number = Integer.parseInt(inputs[1]);
                pq.add(number);
                continue;
            }
            if (command.equals("pop")) {
                System.out.println(pq.poll());
                continue;
            }
            if (command.equals("size")) {
                System.out.println(pq.size());
                continue;
            }
            if (command.equals("empty")) {
                if (pq.isEmpty()) {
                    System.out.println(1);
                    continue;
                }
                System.out.println(0);
                continue;
            }
            if (command.equals("top")) {
                System.out.println(pq.peek());
            }
        }
    }
}