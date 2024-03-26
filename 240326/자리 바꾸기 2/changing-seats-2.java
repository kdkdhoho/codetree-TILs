import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        Map<Integer, Integer> seats = new HashMap<>(); // K 자리에 V 사람이 앉아있다.
        for (int i = 1; i <= n; i++) {
            seats.put(i, i);
        }

        Map<Integer, HashSet<Integer>> result = new TreeMap<>(); // K번 사람이 앉은 자리들
        for (int i = 1; i <= n; i++) {
            HashSet<Integer> init = new HashSet<>();
            init.add(i);
            result.put(i, init);
        }

        int k = sc.nextInt();
        int[][] commands = new int[k][2]; // k개의 명령들
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2; j++) {
                commands[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < k; j++) {
                int[] command = commands[j];
                int seatA = command[0];
                int seatB = command[1];

                int personA = seats.get(seatA);
                int personB = seats.get(seatB);

                HashSet<Integer> seatedA = result.get(personA);
                seatedA.add(seatB);
                result.put(personA, seatedA);
                HashSet<Integer> seatedB = result.get(personB);
                seatedB.add(seatA);
                result.put(personB, seatedB);

                seats.put(seatA, personB);
                seats.put(seatB, personA);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (Map.Entry<Integer, HashSet<Integer>> entry : result.entrySet()) {
            answer.append(entry.getValue().size()).append("\n");
        }
        System.out.print(answer);
    }
}