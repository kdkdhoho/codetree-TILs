import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                arr[row][col] = sc.nextInt();
            }
        }

        int answer = -1;
        for (int row1 = 0; row1 < n; row1++) {
            for (int col1 = 0; col1 < m; col1++) {
                for (int row2 = row1; row2 < n; row2++) {
                    for (int col2 = col1; col2 < m; col2++) {
                        boolean isCond = true;

                        for (int row = row1; row <= row2; row++) {
                            for (int col = col1; col <= col2; col++) {
                                if (arr[row][col] <= 0) {
                                    isCond = false;
                                    break;
                                }
                            }
                            if (!isCond) {
                                break;
                            }
                        }

                        if (isCond) {
                            int area = (int) (((row2 - row1) + 1) * ((col2 - col1) + 1));
                            answer = Math.max(answer, area);
                        }
                    }
                }
            }
        }

        System.out.print(answer);
    }
}