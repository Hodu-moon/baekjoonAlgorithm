
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    static int daily, monthly, threeMonthly, annually;
    static int[] dp;
    static int[] plan;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            daily = sc.nextInt();
            monthly = sc.nextInt();
            threeMonthly = sc.nextInt();
            annually = sc.nextInt();

            dp = new int[13];
            plan = new int[13];
            for(int i = 1; i <= 12; i++){
                plan[i] = sc.nextInt();
            }

            for (int i = 1; i <= 12; i++) {
                // 1일권
                dp[i] = dp[i - 1] + daily * plan[i];

                // 1달권
                dp[i] = Math.min(dp[i] , dp[i - 1] + monthly);

                // 3달권
                if(i > 2){
                    dp[i] = Math.min(dp[i], dp[i - 3] + threeMonthly);
                }


                if(i == 12){
                    dp[i] = Math.min(dp[i], annually);
                }

            }

            sb.append("#").append(t).append(" ").append(dp[12]).append("\n");
        }


        System.out.println(sb);
    }
}
//
//10
//10 40 100 300
//0 0 2 9 1 5 0 0 0 0 0 0
