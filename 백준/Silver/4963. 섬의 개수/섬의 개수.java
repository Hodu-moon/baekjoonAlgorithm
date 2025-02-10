
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int cnt = 0;
    static boolean[][] visited;
    static int w;
    static int h;

    // 상 하 좌 우  왼위 오위 왼아 오아
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            w = sc.nextInt();
            h = sc.nextInt();

            cnt = 0;

            if(w == 0 && h == 0){
                break;
            }

            arr = new int[h][w];
            visited = new boolean[h][w];

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){

                    if(!visited[i][j] && arr[i][j] == 1){
                        BFS(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);


        }
    }

    static void BFS(int x, int y){
        visited[x][y] = true;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});

        while(!queue.isEmpty()){

            int[]xy = queue.poll();

            for(int i = 0; i < 8; i++){
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];

                if(isIn(nx, ny) && !visited[nx][ny] && arr[nx][ny] == 1 ){
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }

        }


    }

    static boolean isIn( int x, int y){
        return  x >= 0 && x  < h && y >= 0 && y < w;
    }
}

// 1 1
//0
