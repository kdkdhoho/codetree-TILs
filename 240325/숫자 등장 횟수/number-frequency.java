import java.util.*;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int a = sc.nextInt();
        int b = sc.nextInt();

        int resultA = map.getOrDefault(a, 0);
        int resultB = map.getOrDefault(b, 0);
        System.out.printf("%d %d", resultA, resultB);
    }
}