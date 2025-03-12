
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N, M, result;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        BFS(0, 0);
        System.out.println(result);

    }

    static void BFS(int x, int y){
        Queue<int[] > queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new int[]{x, y, 1});
        visited[x][y] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            if(cur[0] == N - 1 && cur[1] == M - 1 ){
                result = cur[2];
            }

            for(int i = 0; i< 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(!isIn(nx, ny)){
                    continue;
                }

                if(!visited[nx][ny] && map[nx][ny] == 1 ){
                    queue.offer(new int[]{nx, ny, cur[2] + 1});
//                    System.out.println(nx + " " + ny + " " + (cur[2] + 1));
                    visited[nx][ny] = true;
                }


            }




        }

    }
    static boolean isIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
//4 6
//101111
//101010
//101011
//111011
