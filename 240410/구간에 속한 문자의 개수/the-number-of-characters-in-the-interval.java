import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        char[][] arr = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < row.length(); j++) {
                char c = row.charAt(j);
                arr[i][j + 1] = c;
            }
        }

        int[][][] pre = new int[n + 1][m + 1][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                pre[i][j] = new int[3];
            }
        }

        // 누적 합 배열 생성
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = sub(add(pre[i - 1][j], pre[i][j - 1]), pre[i - 1][j - 1]);
                if (arr[i][j] == 'a') {
                    pre[i][j][0]++;
                } else if (arr[i][j] == 'b') {
                    pre[i][j][1]++;
                } else {
                    pre[i][j][2]++;
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < k; i++) {
            String[] split = sc.nextLine().split(" ");
            int r1 = Integer.parseInt(split[0]);
            int c1 = Integer.parseInt(split[1]);
            int r2 = Integer.parseInt(split[2]);
            int c2 = Integer.parseInt(split[3]);

            int[] count = count(r1, c1, r2, c2, pre);
            for (int j = 0; j < 3; j++) {
                answer.append(count[j]).append(" ");
            }
            answer.append("\n");
        }

        System.out.print(answer);
    }

    private static int[] add(int[] source, int[] target) {
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = source[i] + target[i];
        }
        return result;
    }

    private static int[] sub(int[] source, int[] target) {
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = source[i] - target[i];
        }
        return result;
    }

    private static int[] count(int r1, int c1, int r2, int c2, int[][][] pre) {
        return add(sub(sub(pre[r2][c2], pre[r1 - 1][c2]), pre[r2][c1 - 1]), pre[r1 - 1][c1 - 1]);
    }
}