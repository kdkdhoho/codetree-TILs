import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) { // 5
            int m = sc.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            StringBuilder sb = new StringBuilder();

            for (int j = 1; j <= m; j++) { // 100000
                int number = sc.nextInt();
                pq.add(number);

                if (j % 2 != 0) {
                    Integer[] array = pq.toArray(new Integer[0]);
                    Arrays.sort(array); // O(j) // 100000
                    int middle = array[array.length / 2];
                    sb.append(middle).append(" ");
                }
            }
            System.out.println(sb);
        }
    }
}