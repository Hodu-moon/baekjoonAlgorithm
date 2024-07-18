import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int K;

    static boolean[][] arr;
    static boolean[][] checked;
    static int[][] x_y_position;
    static ArrayList<Integer> list;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        x_y_position = new int[K][4];

        int[] result = new int[K];
        arr = new boolean[N][M];
        list = new ArrayList<>();

        for(int i = 0; i < K; i++){

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                x_y_position[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < K; i++){
            int[]xy = x_y_position[i];
            makeRectangle(xy);
        }





        for(int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if(!arr[i][j]) {
                    count = 0;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }


        Collections.sort(list);
        System.out.println(list.size());
        for (int area : list) {
            System.out.print(area + " ");
        }


    }

    static void dfs(int n , int m){
        arr[n][m] = true;
        count++;

        int[] dx = new int[]{ -1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for(int i = 0; i < 4; i++){
            int nn = n + dx[i];
            int nm = m + dy[i];

            if(nn >= 0 && nn < N  && nm >= 0 && nm < M  && !arr[nn][nm] ){

                dfs(nn, nm );

            }
        }

    }

    static void makeRectangle(int[] xy){
        // xy[0] xy[1]
//             xy[2] xy[3]
        for(int j = xy[0] ; j <  xy[2]; j++ ){
            for(int k = xy[1]; k < xy[3]; k++){
                arr[j][k] = true;
            }
        }

    }
}
