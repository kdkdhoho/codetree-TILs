import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> strMap = new HashMap<>();
        Map<Integer, String> intMap = new HashMap<>();
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= m; i++) {
            String s = sc.nextLine();
            strMap.put(s, i);
            intMap.put(i, s);
        }
    }
}