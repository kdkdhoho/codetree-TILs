import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> map = new HashMap<>();

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            String s = sc.nextLine();
            map.put(s, String.valueOf(i));
            map.put(String.valueOf(i), s);
        }

        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            System.out.println(map.get(s));
        }
    }
}