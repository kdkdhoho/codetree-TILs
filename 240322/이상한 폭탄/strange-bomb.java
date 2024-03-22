import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static int n, k;
    private static int[] numbers;

    public static void main(String[] args) {
        n = sc.nextInt();
        k = sc.nextInt();
        
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        HashSet<Integer>[] R = new HashSet[n];
        for (int i = 0; i < n; i++) {
            R[i] = new HashSet<>();
        }
        R[n - 1].add(numbers[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            HashSet<Integer> beforeSet = R[i + 1];
            HashSet<Integer> newSet = new HashSet(beforeSet);
            newSet.add(numbers[i]);
            R[i] = newSet;
        }

        int answer = -1;
        for (int i = 0; i <= n - 1; i++) {
            int nextIndex = getNextIndex(i, k);

            if (R[nextIndex].contains(numbers[i])) {
                if (nextIndex + 1 >= n) {
                    answer = Math.max(answer, numbers[i]);
                    continue;
                }

                if (!R[getNextIndex(i, k + 1)].contains(numbers[i])) {
                    answer = Math.max(answer, numbers[i]);
                }
            }
        }
        System.out.print(answer);
    }
    
    private static int getNextIndex(int i, int next) {
        if (i + next >= n) {
            return n - 1;
        }
        return i + next;
    }
}