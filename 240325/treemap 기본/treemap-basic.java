import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.nextLine();

        Map<Integer, Integer> map = new TreeMap<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(" ");
            String command = split[0];

            if (command.equals("add")) {
                int k = Integer.parseInt(split[1]);
                int v = Integer.parseInt(split[2]);
                map.put(k, v);
            } else if (command.equals("remove")) {
                int k = Integer.parseInt(split[1]);
                map.remove(k);
            } else if (command.equals("find")) {
                int k = Integer.parseInt(split[1]);
                if (map.containsKey(k)) {
                    answer.append(map.get(k)).append("\n");
                } else {
                    answer.append("None\n");
                }
            } else {
                if (map.isEmpty()) {
                    answer.append("None\n");
                } else {
                    StringBuilder totalValues = new StringBuilder();
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        totalValues.append(entry.getValue()).append(" ");
                    }
                    answer.append(totalValues).append("\n");
                }
            }
        }

        System.out.print(answer);
    }
}