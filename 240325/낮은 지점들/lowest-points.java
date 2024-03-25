import java.util.*;

/*
2차원 평면 위에 N개의 점이 주어질 때,
만약 동일한 x좌표를 갖는 점이 있다면 y좌표 값이 큰 점을 제거한다.

모든 점들이 주어졌을 때, 남아있는 점들의 y좌표의 합을 구하시오.
*/
public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            if (map.containsKey(x)) {
                int existsY = map.get(x);

                if (y < existsY) {
                    map.put(x, y);
                }
            } else {
                map.put(x, y);
            }
        }

        long sum = 0;
        for (int y : map.values()) {
            sum += y;
        }
        System.out.print(sum);
    }
}