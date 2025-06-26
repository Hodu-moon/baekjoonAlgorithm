import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int k = sc.nextInt();
        Set<Integer> coinSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            coinSet.add(sc.nextInt()); 
        }

        int[] coins = coinSet.stream().mapToInt(Integer::intValue).toArray();

        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; 

        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
    }
}
