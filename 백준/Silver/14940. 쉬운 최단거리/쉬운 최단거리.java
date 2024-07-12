import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int start_n = 0;
        int start_m = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int a =  Integer.parseInt(st.nextToken());
                if(a == 2){
                    start_n = i;
                    start_m = j;
                }
                arr[i][j] = a;
            }
        }

        bfs(arr, visited,N, M, start_n, start_m);

        // 결과 출력
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int[][] arr,boolean[][] visited, int N, int M, int start_n, int start_m) {
        int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우 방향
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start_n, start_m});
        arr[start_n][start_m] = 0;
        visited[start_n][start_m] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 1
                && !visited[nx][ny] ) {
                    arr[nx][ny] = arr[x][y] + 1;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        // 도달할 수 없는 셀은 -1로 표시
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !visited[i][j] ) {
                    arr[i][j] = -1;
                }
            }
        }
    }
}
