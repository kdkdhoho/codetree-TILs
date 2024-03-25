import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> strKeyMap = new HashMap<>();
        Map<Integer, String> intKeyMap = new HashMap<>();

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int number = 1;
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            strKeyMap.put(s, number);
            intKeyMap.put(number, s);

            number += 1;
        }

        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();

            try {
                int num = Integer.parseInt(s);
                System.out.println(intKeyMap.get(num));
            } catch (Exception e) {
                System.out.println(strKeyMap.get(s));
            }
        }
    }
}