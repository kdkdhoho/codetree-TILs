import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, answer = 0;

    public static void main(String[] args) {
        n = sc.nextInt();
        recursive(0, new ArrayList<>());
        System.out.println(answer);
    }

    private static void recursive(int count, List<Integer> nums) {
        if (count >= n) {
            if (isBeautiful(nums)) {
                answer++;
            }
            return;
        }

        for (int num = 1; num <= 4; num++) {
            nums.add(num);
            recursive(count + 1, nums);
            nums.remove(nums.size() - 1);
        }
    }

    private static boolean isBeautiful(List<Integer> nums) {
        int count = 1;
        int lastNumber = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            int currNum = nums.get(i);

            if (lastNumber != currNum) {
                if (count % lastNumber == 0) {
                    count = 1;
                    lastNumber = nums.get(i);
                    continue;
                }
                if (count != lastNumber) {
                    return false;
                }
                count = 1;
                lastNumber = nums.get(i);
                continue;
            }
            if (lastNumber == currNum) {
                count++;
            }
        }

        if (count % lastNumber == 0) {
            return true;
        }
        if (count != lastNumber) {
            return false;
        }
        return true;
    }
}