import java.io.*;
import java.util.*;

public class Main {
    static int X, Y;
    static int[][] map;
    static boolean[][] visited;  // 시간 초과 방지용
    static Boolean[][] memo;     // 결과 메모이제이션

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new int[X][Y];
        visited = new boolean[X][Y];
        memo = new Boolean[X][Y];

        for (int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < Y; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0) ? "Yes" : "No");
    }

    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    static boolean dfs(int x, int y) {
        if (!isIn(x, y) || map[x][y] == 0)
            return false;

        if (x == X - 1 && y == Y - 1)
            return true;

        if (memo[x][y] != null)
            return memo[x][y];  // 이미 계산한 결과

        visited[x][y] = true;
        boolean result = false;

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                if (dfs(nx, ny)) {
                    result = true;
                    break;
                }
            }
        }

        visited[x][y] = false;
        return memo[x][y] = result;
    }

    static boolean isIn(int x, int y) {
        return 0 <= x && x < X && 0 <= y && y < Y;
    }
}
