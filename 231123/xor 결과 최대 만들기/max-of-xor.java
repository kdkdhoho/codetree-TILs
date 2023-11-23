import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, m, answer = Integer.MIN_VALUE;
    private static int[] numbers;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        recursive(new ArrayList<>(), 0);

        System.out.println(answer);
    }

    private static void recursive(List<Integer> nums, int idx) {
        if (nums.size() == m) {
            int result = nums.get(0);
            for (int i = 1; i < nums.size(); i++) {
                result ^= nums.get(i);
            }
            answer = Math.max(answer, result);
        }

        for (int i = idx; i < n; i++) {
            nums.add(numbers[i]);
            recursive(nums, idx + 1);
            nums.remove(nums.size() - 1);
        }
    }
}