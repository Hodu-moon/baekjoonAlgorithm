
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, maxNum, maxDistance;
    static int[][] map;
    static int[][] result;


    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = { 0, 0, -1, 1};

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            result = new int[N][N];

            maxNum = Integer.MAX_VALUE;
            maxDistance = 0;

            for(int i = 0; i < N; i++){
                String input = br.readLine();
                StringTokenizer st = new StringTokenizer(input, " ");
                for(int j = 0; j < N ; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

//            printMap();

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(result[i][j] > 0){
                        continue;
                    }

                    solve(i, j);

                    if(maxDistance == result[i][j]){
                        maxNum = Math.min(maxNum, map[i][j]);
                    }else if(maxDistance < result[i][j]){
                        maxDistance = result[i][j];
                        maxNum = map[i][j];
                    }

                }
            }

            sb.append("#").append(t).append(" ").append(maxNum).append(" ").append(maxDistance).append("\n");


        }
        System.out.println(sb);
    }

   static void solve(int i, int j){
        int count = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int d = 0; d < 4; d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(!isIn(nx, ny))
                    continue;

                if(map[nx][ny] == map[cur[0]][cur[1]] + 1){
                    queue.offer(new int[]{nx, ny});
                    count++;
                }
            }
        }

        result[i][j] = count;

   }

    static boolean isIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
