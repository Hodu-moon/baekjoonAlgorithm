import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
	
	static int N, W;
	static int[] weights, profits;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		weights = new int[N + 1];
		profits = new int[N + 1];
		
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " "); 
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		dp = new int[W + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int w = W; w >=1; w--) {
				if( w >= weights[i]) {
					dp[w] = Math.max(dp[w], dp[w - weights[i]] + profits[i]);
				}else {
					continue;
				}
			}
		}
		
		System.out.println(dp[W]);
		
		
	}
}

// 무게 가치 

//4 7
//6 13
//4 8
//3 6
//5 12