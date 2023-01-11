
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        long [][]dp = new long[100001][];
        dp[1] = new long[4];
        dp[2] = new long[4];
        dp[3] = new long[4];

        dp[1][1] = 1;
        dp[2][2] = 1;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i = 4; i < dp.length; i++){
            dp[i] = new long[4];
            dp[i][1] = (dp[i-1][2] + dp[i-1][3])%1000000009;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3])%1000000009;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2])%1000000009;
        }

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for(int i = 0; i < N; i++){
            int a = scanner.nextInt();
            System.out.println(((dp[a][1]+ dp[a][2])%1000000009 + dp[a][3])%1000000009);
        }

    }
}
