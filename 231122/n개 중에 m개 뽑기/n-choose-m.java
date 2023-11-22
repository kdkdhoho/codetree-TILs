import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, m;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();

        recursive(new ArrayList<>(), 1);
    }

    private static void recursive(List<Integer> nums, int currNum) {
        if (nums.size() == m) {
            print(nums);
            return;
        }

        for (int num = currNum; num <= n; num++) {
            nums.add(num);
            recursive(nums, num + 1);
            nums.remove(nums.size() - 1);
        }
    }

    private static void print(List<Integer> nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num).append(" ");
        }
        sb.append(System.lineSeparator());
        System.out.print(sb);
    }

}