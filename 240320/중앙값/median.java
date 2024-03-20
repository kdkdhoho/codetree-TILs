import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int t, m;

    public static void main(String[] args) {
        t = sc.nextInt();
        while (t-- > 0) { // 5
            int m = sc.nextInt(); // 100000

            StringBuilder sb = new StringBuilder();
            int median = 0;
            // maxHeap
            PriorityQueue<Integer> lowerNumbers = new PriorityQueue<>(Comparator.reverseOrder());
            // minHeap
            PriorityQueue<Integer> higherNumbers = new PriorityQueue<>();

            for (int i = 1; i <= m; i++) {
                int number = sc.nextInt();

                if (i == 1) {
                    median = number;
                    sb.append(median).append(" ");
                    continue;
                }

                if (i % 2 == 0) {
                    if (number >= median) {
                        higherNumbers.add(number);
                    } else if (number < median) {
                        lowerNumbers.add(number);
                    }
                } else {
                    int tmp;
                    if (lowerNumbers.size() > higherNumbers.size()) {
                        tmp = lowerNumbers.poll();
                    } else {
                        tmp = higherNumbers.poll();
                    }

                    int[] nums = {number, median, tmp};
                    Arrays.sort(nums);
                    median = nums[1];
                    lowerNumbers.add(nums[0]);
                    higherNumbers.add(nums[2]);
                    sb.append(median).append(" ");
                }
            }
            System.out.println(sb);
        }
    }
}