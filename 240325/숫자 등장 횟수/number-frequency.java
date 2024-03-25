import java.util.*;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final StringBuilder answer = new StringBuilder();
    
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            int result = map.getOrDefault(num, 0);
            answer.append(result).append(" ");
        }
        System.out.print(answer);
    }
}