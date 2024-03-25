import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();

        Map<String, Integer> strMap = new HashMap<>();
        Map<Integer, String> intMap = new HashMap<>();
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            String s = sc.nextLine();
            strMap.put(s, i);
            intMap.put(i, s);
        }

        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();

            try {
                int num = Integer.parseInt(s);
                answer.append(intMap.get(num)).append("\n");
            } catch (NumberFormatException e) {
                answer.append(strMap.get(s)).append("\n");
            }
        }

        System.out.print(answer);
    }
}