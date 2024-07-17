import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int cost;
    static int N;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        cost = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            visited[i] = true;
            dfs(i, i, 0, 0);
        }

        System.out.println(cost);
    }

    static void dfs(int start, int now, int count, int sum){

        //끝 로직
        // 마지막엔
        // 0 1 1
        // 1 0 1
        // 1 1 0

        // 0 -> 1  -> 2 다 했으면 시작점으로 돌아와야함
        if(count == N - 1 ){
            if(arr[now][start] != 0){
                sum += arr[now][start];
                cost = Math.min(sum, cost);
            }
            return;

        }


        // 재귀함수 구현
        for(int i = 0; i < N; i++){

            if( !visited[i] && arr[now][i] > 0 ){
                visited[i] = true;
                dfs(start, i, count + 1, sum + arr[now][i]);
                visited[i] = false;
            }
        }

    }
}
