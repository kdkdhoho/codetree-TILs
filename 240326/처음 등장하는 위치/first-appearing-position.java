import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();

            if (map.containsKey(number)) {
                continue;
            }

            map.put(number, i + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.printf("%d %d\n", entry.getKey(), entry.getValue());
        }
    }
}