
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int card[] = new int[N+1];
        for(int i = 1; i <= N; i++){
            card[i] = scanner.nextInt();
        }

        int dp[] = new int[N+1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i],dp[i-j] + card[j]);
            }
        }

        System.out.println(dp[N]);


    }
}
