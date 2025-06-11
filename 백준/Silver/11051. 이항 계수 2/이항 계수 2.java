
import java.util.Scanner;

public class Main {
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        dp  = new long[N+1][K+1];
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= K; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(combination(N, K));
    }

    static long combination(int n, int k){

        if(dp[n][k] != -1)
            return dp[n][k];

        if(k == 0 || n == k){
            return dp[n][k] = 1;
        }


        dp[n][k] = (combination(n - 1, k - 1)  + combination(n - 1, k)) % 10007;
        return dp[n][k];
    }

}
