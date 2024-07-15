import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][] checked;
    static int N;


    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());

      arr = new int[N][N];

      int max = -1;

      for(int i = 0; i < N; i++){
          String s = br.readLine();
          StringTokenizer st = new StringTokenizer(s);

          for(int j = 0; j < N; j++){
              arr[i][j] = Integer.parseInt(st.nextToken());
              max = Math.max(max, arr[i][j]);
          }
      }

      int result = 0;

      for(int height = 0; height <= max; height++){
          checked = new boolean[N][N];

          int count = 0;

          for(int i = 0; i < N; i++) {
              for (int j = 0; j < N; j++) {

                  if (!checked[i][j] && arr[i][j] > height) {
                      count += dfs(i, j, height);
                  }

              }
          }

          result = Math.max(result, count);

      }

        System.out.println(result);

//         출력용
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < N; j++){
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    static int dfs(int x, int y, int height){
        checked[x][y] = true;

        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N && !checked[nx][ny]){
                if(arr[nx][ny] > height)
                    dfs(nx, ny, height);
            }
        }

        return 1;
    }

}
