import java.util.*;

public class Main {
    static final int MAX_N = 500;
    static boolean[][] adj;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        adj = new boolean[N + 1][N + 1];

        // 입력 처리
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a][b] = true;
        }

        // 플로이드-워셜
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (adj[i][k] && adj[k][j]) {
                        adj[i][j] = true;
                    }
                }
            }
        }

        // 각 학생이 자신보다 작은 학생 수, 큰 학생 수
        int result = 0;
        for (int i = 1; i <= N; i++) {
            int smallCount = 0;
            int bigCount = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (adj[i][j]) bigCount++;    // i < j
                if (adj[j][i]) smallCount++; // j < i
            }

            if (smallCount + bigCount == N - 1) {
                result++;
            }
        }

        System.out.println(result);
    }
}
