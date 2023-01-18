
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        long []dp = new long[92];
        dp[1] = 1;
        dp[2] = 1;
        if(N == 1){
            System.out.println(dp[1]);
        } else if (N == 2) {
            System.out.println(dp[2]);
        }else {
            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            System.out.println(dp[N]);
        }
    }
}
