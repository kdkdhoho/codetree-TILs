import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int n;

    public static boolean isPossible(List<Integer> nums) {
        for (int l = 1; l <= nums.size() / 2; l++) {
            for (int start = 0; start <= nums.size() - (l * 2); start++) {
                int end = start + l - 1;

                int cnt = 0;
                for (int i = start; i <= end; i++) {
                    int idx = i + l;

                    if (nums.get(i).equals(nums.get(idx))) {
                        cnt++;
                    }
                }

                if (cnt == l) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void findMinSeries(List<Integer> nums) {
        if (nums.size() == n) {
            for (Integer num : nums)
                System.out.print(num);
            System.exit(0);
        }

        for (int num = 4; num <= 6; num++) {
            nums.add(num);
            if (isPossible(nums)) {
                findMinSeries(nums);
            }
            nums.remove(nums.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        findMinSeries(new ArrayList<>());
    }
}