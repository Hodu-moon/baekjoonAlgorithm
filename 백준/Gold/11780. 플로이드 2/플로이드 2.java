
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static final long INF = 999999999;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        long[][] dist = new long[N + 1][N + 1];
        int[][] before = new int[N + 1][N + 1];

        // 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
                before[i][j] = -1;
            }
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (dist[start][end] > cost) {
                dist[start][end] = cost;
                before[start][end] = start;
            }
        }

        // Floyd-Warshall
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (i == k) continue;
                for (int j = 1; j <= N; j++) {
                    if (j == k || j == i) continue;

                    if (dist[i][k] == INF || dist[k][j] == INF) continue;

                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        if (before[k][j] != -1) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            before[i][j] = before[k][j];
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        // 거리 출력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(dist[i][j] == INF ? "0" : dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        // 경로 출력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                List<Integer> path = getPath(dist, before, i, j);
                if (path.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(path.size()).append(" ");
                    for (int value : path) sb.append(value).append(" ");
                    sb.append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    static List<Integer> getPath(long[][] dist, int[][] before, int start, int end) {
        List<Integer> path = new ArrayList<>();

        if (dist[start][end] == 0 || dist[start][end] == INF || before[start][end] == -1) {
            return path;
        }

        int cur = end;
        while (cur != start) {
            path.add(cur);
            cur = before[start][cur];
        }
        path.add(start);
        Collections.reverse(path);
        return path;
    }
}
