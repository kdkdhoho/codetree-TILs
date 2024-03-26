import java.util.*;
import java.io.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();

        // i번 사람이 앉은 자리를 나타내는 배열을 초기화합니다.
        int[] seats = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            seats[i] = i;
        }

        // i번 사람이 앉았던 자리들을 기록하는 TreeMap을 초기화합니다.
        Map<Integer, HashSet<Integer>> result = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            HashSet<Integer> init = new HashSet<>();
            init.add(i);
            result.put(i, init);
        }

        // 자리 바꾸는 명령들을 입력받습니다.
        int k = sc.nextInt();
        int[][] commands = new int[k][2];
        for (int i = 0; i < k; i++) { // O(K)
            int a = sc.nextInt();
            int b = sc.nextInt();
            commands[i][0] = a;
            commands[i][1] = b;
        }

        // 3K에 걸쳐 자리를 바꿉니다.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < k; j++) { // O(K)
                int seatA = commands[j][0];
                int seatB = commands[j][1];

                int personA = seats[seatA];
                int personB = seats[seatB];

                HashSet<Integer> seatedA = result.get(personA);
                seatedA.add(seatB);
                result.put(personA, seatedA);
                HashSet<Integer> seatedB = result.get(personB);
                seatedB.add(seatA);
                result.put(personB, seatedB);

                seats[seatA] = personB;
                seats[seatB] = personA;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (Map.Entry<Integer, HashSet<Integer>> entry : result.entrySet()) { // O(N)
            answer.append(entry.getValue().size()).append("\n");
        }
        System.out.print(answer);
    }
}