
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int []dp = new int[N+1];

        for(int i = 2; i <= N; i++){
            dp[i] = dp[i-1] + 1;
            int c;
            if( i % 2 == 0){
               dp[i] = min(dp[i / 2] + 1, dp[i] );
            }
            if (i % 3 == 0) {
                dp[i] = min(dp[i / 3] +1 , dp[i]);
            }
        }
        System.out.println(dp[N]);
    }
}
