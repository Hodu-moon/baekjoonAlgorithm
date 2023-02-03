
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = Integer.MAX_VALUE;
    static int larva = 0;

    static int dx[] = {0, 0, -1, +1};
    static int dy[] = {-1, 1, 0, 0 };

   static int field[][];
   static boolean visited[][];

   static int M;
   static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        while (T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            field = new int[M][N];
            visited = new boolean[M][N];

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                field[x][y] = 1;
            }

            larva = 0;

            for(int i = 0; i < field.length; i++){
                for(int j = 0; j < field[0].length; j++){
                    if(field[i][j] == 1 && (visited[i][j] == false)){
                        DFS(i, j);

                        larva++;

                    }
                }
            }

            System.out.println(larva);
        }


    }
    static void DFS (int startX, int startY){
        visited[startX][startY] = true;

        for(int i =  0; i < 4; i++){
            int x = startX + dx[i];
            int y = startY + dy[i];

            if(x < 0 || x >= M || y < 0 || y >= N){
                continue;
            }

            if(visited[x][y] == false && field[x][y] == 1){
                DFS(x, y);
            }
        }

    }
}
