
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int N, resultLength;
    static int[][] map, result;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        result = new int[N][N];
        StringTokenizer st ;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int currentLength = DFS(i, j);
                resultLength = Math.max(currentLength, resultLength);
            }
        }

        System.out.println(resultLength);


    }

    static int DFS(int x, int y){

        if(result[x][y] > 0)
            return result[x][y];

        int maxLength = 1;


        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!isIn(nx, ny))
                continue;

            if(map[x][y] < map[nx][ny]){
                int next = DFS(nx, ny) + 1;

                if(maxLength < next){
                    maxLength = next;
                }

            }
        }

        return result[x][y] = maxLength;

    }


    static class Position{
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



    static boolean isIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}

// N 1< 500
//4
//14 9 12 10
//1 11 5 4
//7 15 2 13
//6 3 16 8
