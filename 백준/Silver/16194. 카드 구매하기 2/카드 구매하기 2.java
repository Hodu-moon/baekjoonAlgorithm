
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int card[] = new int[N+1];
        int []dp =new int [N+1];

        for(int i = 1; i <= N; i++){
            card[i] = scanner.nextInt();
            dp[i] = card[i];
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i-j] + dp[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
