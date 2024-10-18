import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int [] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j * j <= i ; j++){
                dp[i] = Math.min(dp[i], dp [ i - j * j] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}