import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, result;
	static int[] weights;
	static boolean[] visited;
	static int[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t = 1 ; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			weights = new int[N];
			result = 0;
			
			st = new StringTokenizer(br.readLine().trim());
			for(int i = 0; i < N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}
		
			// 1. 순열을 짬.
			// 2. 그 수열로 백트레킹 
			visited = new boolean[N];
			selected = new int[N];
			permutation(0);
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		
		
		System.out.println(sb);
		
	}
	
	
	static void permutation(int depth) {
		
		if(depth == N) {
			// 여기서 처리 
			solve(0, 0, 0);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i])
				continue;
			
			visited[i] = true;
			selected[depth] = i;
			permutation(depth + 1);
			visited[i] = false;	
		}
		
	}
	
	static void solve(int depth, int leftWeight, int rightWeight) {
		// back tracking 조건
		if(rightWeight > leftWeight) {
			return;
		}
		
		
		// 기저조건
		if(depth == N) {
			result++;
			return;
		}
		
		// left에 올리는거
		solve(depth + 1, leftWeight  + weights[selected[depth]], rightWeight);
		// right에 올리는거 
		solve(depth + 1, leftWeight, rightWeight + weights[selected[depth]]);
		
	}

}

//
//3
//3
//1 2 4
//3
//1 2 3
//9
//1 2 3 5 6 4 7 8 9