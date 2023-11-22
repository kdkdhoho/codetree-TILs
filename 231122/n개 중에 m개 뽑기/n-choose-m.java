import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, m;
    private static final List<Integer> nums = new ArrayList<>();

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();

        recursive(1);
    }

    private static void recursive(int currNum) {
        if (nums.size() == m) {
            print(nums);
            return;
        }

        for (int num = currNum; num <= n; num++) {
            nums.add(num);
            recursive(num + 1);
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