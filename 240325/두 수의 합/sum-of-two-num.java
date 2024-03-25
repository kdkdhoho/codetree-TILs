import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int target = k - num;

            int targetCount = map.getOrDefault(target, 0);
            if (num == target) {
                targetCount -= 1;
            }

            answer += targetCount;
        }
        System.out.print(answer / 2);
    }
}