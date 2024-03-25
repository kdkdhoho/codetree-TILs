import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new TreeMap<>();
        int index = 1;
        for (int number : numbers) {
            if (map.containsKey(number)) {
                continue;
            }
            map.put(number, index);
            index++;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.printf("%d %d\n", entry.getKey(), entry.getValue());
        }
    }
}