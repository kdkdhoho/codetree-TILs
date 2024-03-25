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
            for (int j = i + 1; j < n; j++) {
                int numA = nums[i];
                int numB = nums[j];
                int targetNum = k - (numA + numB);

                int targetNumCnt = map.getOrDefault(targetNum, 0);
                if (numA == targetNum) {
                    targetNumCnt--;
                }
                if (numB == targetNum) {
                    targetNumCnt--;
                }

                answer += targetNumCnt;
            }
        }

        System.out.print(answer / 3);
    }
}