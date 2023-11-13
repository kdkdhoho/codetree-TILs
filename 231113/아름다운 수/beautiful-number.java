import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static int n, answer = 0;

    public static void main(String[] args) {
        n = sc.nextInt();
        func(new ArrayList<>());
        System.out.print(answer);
    }

    private static void func(List<Integer> nums) {
        if (nums.size() == n) {
            if (isBeautiful(nums)) {
                answer++;
            }
            return;
        }

        for (int num = 1; num <= 4; num++) {
            nums.add(num);
            func(nums);
            nums.remove(nums.size() - 1);
        }
    }

    private static boolean isBeautiful(List<Integer> nums) {
        int lastNum = nums.get(0);
        int cnt = 1;

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) == lastNum) {
                cnt++;
                continue;
            }

            if (cnt % lastNum == 0) {
                lastNum = nums.get(i);
                cnt = 1;
                continue;
            }

            return false;
        }

        if (cnt % lastNum == 0) {
            return true;
        }
        return false;
    }
}