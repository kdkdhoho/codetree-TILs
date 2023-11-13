import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static int k, n;

    public static void main(String[] args) {
        k = sc.nextInt();
        n = sc.nextInt();

        recursive(new ArrayList<>());
    }

    private static void recursive(List<Integer> nums) {
        if (nums.size() == n) {
            print(nums);
            return;
        }

        for (int num = 1; num <= k; num++) {
            if (nums.size() >= 2) {
                int last = nums.get(nums.size() - 1);
                int last2 = nums.get(nums.size() - 2);
                if (last == last2 && num == last) {
                    continue;
                }
            }

            nums.add(num);
            recursive(nums);
            nums.remove(nums.size() - 1);
        }
    }

    private static void print(List<Integer> nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}