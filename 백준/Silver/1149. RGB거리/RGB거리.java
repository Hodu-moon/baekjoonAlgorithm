
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];

        int[][] input = new int[N][3];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
            input[i][2] = Integer.parseInt(st.nextToken());

        }

        dp[0][0] = input[0][0];
        dp[0][1] = input[0][1];
        dp[0][2] = input[0][2];

        for(int i = 1; i < N; i++){
            dp[i][0] = Math.min(dp[i - 1][1], dp[i-1][2]) + input[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i-1][2]) + input[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i-1][1]) + input[i][2];
        }

        System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));



    }
}
//3
//26 40 83
//49 60 57
//13 89 99
