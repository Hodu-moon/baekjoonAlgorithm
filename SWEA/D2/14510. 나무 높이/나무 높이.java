import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, maxHeight, result;
	static int[] trees;
	public static void main(String[] args) throws Exception{
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			maxHeight = Integer.MIN_VALUE;
			trees = new int[N];
			
			st = new StringTokenizer(br.readLine().trim());
			for(int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, trees[i]);
			}
			
			int even = 0;
			int odd = 0;
			
			for(int i = 0; i < N; i++) {
				int difference = maxHeight - trees[i];
				
				if(difference == 0)
					continue;
				
				even += difference / 2;
				odd += difference % 2;
			}
			
			if(even > odd) {
				while(Math.abs(even - odd) > 1) {
					even--;
					odd += 2;
				}
			} 
			
			if(even == odd) {
				result = even + odd;
			}else if(even < odd) {
				result = odd * 2 - 1;
			}else {  // even > odd
				result = even * 2;
			}
			
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}
	
	

}

