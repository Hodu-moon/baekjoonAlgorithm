
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String split[] = input.split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][M];
        visited = new boolean[2][N][M];


        for(int i = 0; i < N; i++){
            input = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        BFS(0, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void BFS(int x, int y){
        visited[0][x][y] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, 1, 0 });
        // x y count, crashed 0 x 1 o


        while(!queue.isEmpty()){
            int xy[] = queue.poll();

            visited[xy[3]][xy[0]][xy[1]] = true;

            if(xy[0] == N - 1 && xy[1] == M - 1){
                if(result > xy[2]){
                    result = xy[2];
                }
            }

            for(int i = 0; i < dx.length; i++){
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];

                if(isIn(nx, ny) && map[nx][ny] == 1){ // nx, ny 가 벽일경우
                    if(xy[3] == 0 && !visited[1][nx][ny]){
                        visited[1][nx][ny] = true;
                        queue.offer(new int[]{nx, ny, xy[2] + 1, 1});
                    }
                } else if(isIn(nx, ny) && map[nx][ny] == 0 ) {// 벽이 아닐경우
                    if(!visited[xy[3]][nx][ny]){ // 벽부신, 벽안부신
                        visited[xy[3]][nx][ny] = true;
                        queue.offer(new int[]{nx, ny, xy[2] + 1, xy[3]});
                    }

                }

            }


        }



    }

    static boolean isIn(int x, int y){
        return  x >= 0 && x < N && y >= 0 && y < M;
    }

    static void printArr(){
        System.out.println();
        for(int[] xx : map){
            for(int x : xx){
                System.out.print(x + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
///6 4
// 0100
// 1110
// 1000
// 0000
// 0111
// 0000

