import java.io.*;
import java.util.*;


public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int[][] map;
	static int[][] distances;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
		for(int t = 1 ; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			distances = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine().trim();
				for(int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			
			solve();
			
			sb.append("#").append(t).append(" ").append(distances[N-1][N-1]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	
	static boolean [][] visited;
	static final int INF = 99999999;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	// 1. 다익스트라 
	static void solve() {
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				distances[i][j] = INF;
			}
		}
		
		PriorityQueue<Position> pq = new PriorityQueue<>();
		distances[0][0] = map[0][0];
		pq.offer(new Position(0, 0, map[0][0]));

		
		while(!pq.isEmpty()) {
			
			// 1.  미 방문 정점 중 출발지에서 가장 시간이 덜 걸리는 정점 찾기 
			Position current = pq.poll();
			
//			System.out.println(current);
			
			if(!isIn(current.x, current.y) && visited[current.x][current.y] )
				continue;
			
			visited[current.x][current.y] = true;
			
			if(current.x == N - 1 && current.y == N - 1) {
				break;
			}
			
			
			
			//2. 선택된 정점을 경유해서 갈 수 있는 미 방문 정점들의 최단경로 비용 update
			for(int d = 0; d < 4; d++) {
				int nx = current.x + dx[d];
				int ny = current.y + dy[d];
				
				if(!isIn(nx, ny) || visited[nx][ny])
					continue;
				
				if(distances[nx][ny] > distances[current.x][current.y] + map[nx][ny]) {
					distances[nx][ny] = distances[current.x][current.y] + map[nx][ny];
					pq.offer(new Position(nx, ny , distances[nx][ny]));
				}
			}
			
		}
		
		
	}
	
	static boolean isIn(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
	
	static class Position implements Comparable<Position>{
		int x,y, weight;

		public Position(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}



		@Override
		public int compareTo(Position o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}



		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + ", weight=" + weight + "]";
		}
		
		
	}
	
}

//4
//0100
//1110
//1011
//1010