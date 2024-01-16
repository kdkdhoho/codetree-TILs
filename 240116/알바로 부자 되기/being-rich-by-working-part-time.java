import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        PartTimeJob[] jobs = new PartTimeJob[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new PartTimeJob(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = jobs[i].pay;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (!jobs[i].isOverlap(jobs[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + jobs[i].pay);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}

class PartTimeJob {
    int start;
    int end;
    int pay;

    public PartTimeJob(int start, int end, int pay) {
        this.start = start;
        this.end = end;
        this.pay = pay;
    }

    public boolean isOverlap(PartTimeJob other) {
        return other.end >= this.start && other.start <= this.end;
    }
}