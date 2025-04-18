import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx= {1, 0};
	static int[] dy = {0, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dfs(0, 0) ? "HaruHaru" : "Hing");
	}


	
	static boolean dfs(int x, int y) {
		if(!isIn(x, y) || visited[x][y])
			return false;
		
		if(x == N - 1 && y == N - 1) {
			return true;
		}
		
		visited[x][y] = true;
		
		for(int i = 0; i < 2; i++) {
			int nx = x + dx[i] * map[x][y];
			int ny = y + dy[i] * map[x][y];
			
			
			if(dfs(nx, ny))
				return true;
		}
		
		return false;
	}
	
	static boolean isIn(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
