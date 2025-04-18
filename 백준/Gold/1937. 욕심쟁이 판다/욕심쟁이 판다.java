import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int N;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max= 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				max = Math.max(max, DFS(i, j));
			}
		}

		System.out.println(max);
	}
	
	static int DFS(int x, int y) {
		if(dp[x][y] != 0)
			return dp[x][y];
		
		dp[x][y] = 1;
		
		
		for(int i = 0 ; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!isIn(nx, ny))
				continue;
			
			if(map[nx][ny] > map[x][y])
				dp[x][y] = Math.max(dp[x][y], DFS(nx, ny) + 1);
		}
		
		
		
		return dp[x][y];
		
	}
	
	
	
	static boolean isIn(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
	

}
