
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int N = 16;
    static int[] start, end;
    static int[][] arr;
    static boolean[][] visited;

    //상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int canTouch ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < 10; t++){

            arr = new int[N][N];
            visited = new boolean[N][N];
            canTouch = 0;
            int num = Integer.parseInt(br.readLine());
            System.out.println(num);

            for(int i = 0; i < N; i++){
                String input = br.readLine();
//                System.out.println("here");
                for(int j = 0; j < N; j++){
                    arr[i][j] = input.charAt(j) - '0';

                    if(arr[i][j] == 2){
                        start = new int[]{i, j};
                    }

                    if(arr[i][j] == 3){
                        end = new int[]{i, j};
                    }
                }
//                System.out.println("here2");
            }

            BFS(start[0],start[1] );
            sb.append("#").append(num).append(" ").append(canTouch).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void BFS(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){

            int[] xy = queue.poll();

            if(xy[0] == end[0] && xy[1] == end[1]){
                canTouch = 1;
                return;
            }
//            visited[xy[0]][xy[1]] = true;

            for(int i = 0; i < 4; i++){
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];

                if(!isIn(nx, ny))
                    continue;

                if(!visited[nx][ny] ){

                    if(arr[nx][ny] == 0 || arr[nx][ny] == 3){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx,ny});
                    }

                }


            }
        }

    }

    static boolean isIn(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}


//1
//1111111111111111
//1210000000100011
//1010101110101111
//1000100010100011
//1111111010101011
//1000000010101011
//1011111110111011
//1010000010001011
//1010101111101011
//1010100010001011
//1010111010111011
//1010001000100011
//1011101111101011
//1000100000001311
//1111111111111111
//1111111111111111